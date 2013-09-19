package by.prigozhiy.src.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import by.prigozhiy.entity.PersonUser;

/*
 * http://www.mkyong.com/webservices/jax-rs/jersey-hello-world-example/
 * http://www.mkyong.com/webservices/jax-rs/json-example-with-jersey-jackson/
 * https://github.com/jasonray/jersey-starterkit/wiki/Serializing-a-POJO-to-xml-or-json-using-JAXB
 */
@Path("/hello")
public class Hello {
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
	@Path("/json/get")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonUser getJSONLogin() {
		PersonUser user = new PersonUser();
		user.setLogin("i'm login");
		user.setPassword("i'm password");
		return user;
	}

	@POST
	@Path("/json/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(PersonUser user) {

		String result = "PersonUser saved : " + user;
		return Response.status(201).entity(result).build();

	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public PersonUser getXMLLogin() {
		PersonUser user = new PersonUser();
		user.setLogin("i'm login");
		user.setPassword("i'm password");
		return user;
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
