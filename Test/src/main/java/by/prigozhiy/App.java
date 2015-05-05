package by.prigozhiy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {

		try {
			PropertiesXMLWriteExample();
			PropertiesXMLReadExample();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void PropertiesXMLWriteExample() throws IOException {
		Properties props = new Properties();
		props.setProperty("ARC.Columns1",
 "[Начисления;Начисления;9=2;2,3;9,8,6]");
		props.setProperty("ARC.Columns2",
 "[Счет;Оплачено_за_период;9=2;0,2;9,8,0]");
		props.setProperty(
				"ARC.Columns3",
 "[Прочие расчеты;Прочие_расчеты;9=2;2,3;9,8,2]");

		// where to store?
		OutputStream os = new FileOutputStream(System.getProperty("user.dir") + File.separator + "email-configuration.xml");

		// store the properties detail into a pre-defined XML file
		props.storeToXML(os, "Parser", "UTF-8");

		System.out.println("Done");

		os.close();
	}

	private static void PropertiesXMLReadExample() throws IOException
	{
		Properties props = new Properties();
		 
    	InputStream is = new FileInputStream(System.getProperty("user.dir") + File.separator + "email-configuration.xml");
    	//load the xml file into properties format
    	props.loadFromXML(is);
 
		String email = props.getProperty("ARC.Columns1");
		String email1 = props.getProperty("ARC.Columns2");
		String email2 = props.getProperty("ARC.Columns3");
 
    	System.out.println(email);
		System.out.println(email1);
		System.out.println(email2);

		is.close();

	}

	private String test(String[] s) {
		// TODO не доработанное место
		for (String string : s) {
			System.out.println(string);
		}
		return null;

	}
}
