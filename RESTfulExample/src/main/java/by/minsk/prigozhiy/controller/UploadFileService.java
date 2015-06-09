package by.minsk.prigozhiy.controller;

import by.minsk.prigozhiy.entity.Payment;
import by.minsk.prigozhiy.entity.db.PaymentDB;
import by.minsk.prigozhiy.entity.Registry;
import by.minsk.prigozhiy.entity.db.MapTreeDB;
import by.minsk.prigozhiy.entity.db.SumDB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import by.minsk.prigozhiy.xml.ParserJAXB;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.bind.JAXBException;
import org.springframework.stereotype.Component;

@Component
@Path("/file")
public class UploadFileService {

	@Autowired
	ParserJAXB parser;
        
        @Autowired
	by.minsk.prigozhiy.spring.mybatis.service.Service service;

        
        private static final String FILE_PATH = "d:\\_development\\my_work_remote\\uploaded\\sample.xml";
 
	@GET
	@Path("/download")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response getFile() {
 
		File file = new File(FILE_PATH);
 
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=\"sample.xml");
		return response.build();
 
	}
        
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException, JAXBException {
 
                String uploadedFileLocation = "d:\\_development\\my_work_remote\\uploaded\\" + fileDetail.getFileName();
 
		// save it
                writeToFile(uploadedInputStream, uploadedFileLocation);
                
		Registry req = (Registry) parser.getParser(getFileBytes(new File(uploadedFileLocation)));
                
                for (Payment p: req.getPayment().getPaymentList())
                {
                    if (p.getPayment()!= null)
                    {    
                    System.out.println("1.x level -> " + p.getId() +" : "+ p.getName()); 
                    System.out.println("1.x size -> " + p.getPaymentList().size());
                        int i=0;
                        for (Payment p1: p.getPayment())
                        {
                            System.out.println("1.1."+(i++)+" level -> " + p1.getId() +" : "+ p1.getName());
                            PaymentDB paymentDB = new PaymentDB();
                            paymentDB.setPath("1.1."+(i));
                            paymentDB.setName(p1.getName());
                            paymentDB.setAccount(p1.getAccount());
                            service.insertPayment(paymentDB);
                        }
                    }
                }
                
                List<PaymentDB> payments = service.selectAllPayment();
		System.out.println("payments -> " + payments.size() + "\n");
                
		for (PaymentDB p: payments)
                {
                 System.out.println("-> " + p.getPath()+" : "+ p.getName()+" : "+ p.getAccount());
                }
                
                List<SumDB> sum = service.selectAllSum();
		System.out.println("sum -> " + sum.size() + "\n");
                
                List<MapTreeDB> mapTree = service.selectAllMapTree();
		System.out.println("mapTree -> " + mapTree.size() + "\n");
                
                return Response.status(200).entity(uploadedFileLocation +" : payments = " +payments.size()).build();
 
	}
        
        @POST
	@Path("/select")
	public Response getCount(@FormParam("level") String level) {

                PaymentDB payment = service.selectPayment(level);
		String output = "Payment level " + level + " = " + payment.getPath() + ": " + payment.getAccount();
                System.out.println(output);
                
		return Response.status(200).entity(output).build();

	}
        
        public static byte[] getFileBytes(File file) throws IOException {

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		try {
			byte[] buffer = new byte[4096];
			ous = new ByteArrayOutputStream();
			ios = new FileInputStream(file);
			int read = 0;
			while ((read = ios.read(buffer)) != -1)
				ous.write(buffer, 0, read);
		} finally {
			try {
				if (ous != null)
					ous.close();
			} catch (IOException e) {
				// swallow, since not that important
			}
			try {
				if (ios != null)
					ios.close();
			} catch (IOException e) {
				// swallow, since not that important
			}
		}
		return ous.toByteArray();
	}
 
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) throws IOException {
 
		File file = new File(uploadedFileLocation);

		byte[] buffer = new byte[(int) file.length()];

		FileOutputStream out = null;
		
            try {
			out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];
 
			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
 
			e.printStackTrace();
		}
	}
 
}