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
		props.setProperty("email.support", "p_serega_");

		// where to store?
		OutputStream os = new FileOutputStream(System.getProperty("user.dir") + File.separator + "email-configuration.xml");

		// store the properties detail into a pre-defined XML file
		props.storeToXML(os, "Support", "UTF-8");

		System.out.println("Done");
	}

	private static void PropertiesXMLReadExample() throws IOException
	{
		Properties props = new Properties();
		 
    	InputStream is = new FileInputStream(System.getProperty("user.dir") + File.separator + "email-configuration.xml");
    	//load the xml file into properties format
    	props.loadFromXML(is);
 
    	String email = props.getProperty("email.support");
 
    	System.out.println(email);
	}

	private String test(String[] s) {
		// TODO не доработанное место
		for (String string : s) {
			System.out.println(string);
		}
		return null;

	}
}
