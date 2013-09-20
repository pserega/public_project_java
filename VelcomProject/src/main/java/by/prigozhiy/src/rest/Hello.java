package by.prigozhiy.src.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.prigozhiy.entity.Person;
import by.prigozhiy.entity.PersonUser;
import by.prigozhiy.spring.mybatis.service.Service;

/*
 * http://www.mkyong.com/webservices/jax-rs/jersey-hello-world-example/
 * http://www.mkyong.com/webservices/jax-rs/json-example-with-jersey-jackson/
 * https://github.com/jasonray/jersey-starterkit/wiki/Serializing-a-POJO-to-xml-or-json-using-JAXB
 */
@Path("/hello")
public class Hello {

	private Service service = null;

	public Hello() {

		ApplicationContext cxt = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		service = (Service) cxt.getBean("service");
	}

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey1";
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey1" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}

	@GET
	@Path("/json/get/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getJSONLogin(@PathParam("param") int id) {

		List<Person> persons = service.selectAllPerson();

		// PersonUser user = new PersonUser();
		// user.setLogin("i'm login");
		// user.setPassword("i'm password");
		return persons.get(id);
	}

	@POST
	@Path("/json/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(PersonUser user) {

		String result = "PersonUser saved : " + user;
		return Response.status(201).entity(result).build();

	}

	@GET
	@Path("/xml/{par1}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getXMLLogin(@PathParam("par1") String id) {
		try {
			Integer idO = Integer.valueOf(id);

			List<Person> persons = service.selectAllPerson();
			Person person = persons.get(idO);

			return Response.status(200).entity(person).build();

		} catch (Exception e) {
			return Response
					.status(200)
					.entity("<?xml version=\"1.0\"?>" + "<err>" + "ошибка :"
							+ e.getMessage() + "</err>").build();
		}

	}

	@GET
	@Path("/xml/{par1}/{par2}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getXMLLogin(@PathParam("par1") String id,
			@PathParam("par2") String str) {
		try {
			Integer idO = Integer.valueOf(id);

			List<Person> persons = service.selectAllPerson();
			Person person = persons.get(idO);

			return Response.status(200).entity(person).build();

		} catch (Exception e) {
			return Response
					.status(200)
					.entity("<?xml version=\"1.0\"?>" + "<err>" + "ошибка :"
							+ e.getMessage() + str + "</err>").build();
		}

	}

	@GET
	@Path("/both")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public PersonUser getLogin() {
		PersonUser user = new PersonUser();
		user.setLogin("i'm login");
		user.setPassword("i'm password");
		return user;
	}

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

}
