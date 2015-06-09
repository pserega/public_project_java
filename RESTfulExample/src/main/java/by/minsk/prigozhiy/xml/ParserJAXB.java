package by.minsk.prigozhiy.xml;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

public class ParserJAXB {

	public ParserJAXB() {
	}

	private org.springframework.oxm.jaxb.Jaxb2Marshaller unmarshaller;

	public org.springframework.oxm.jaxb.Jaxb2Marshaller getUnmarshaller() {
		return unmarshaller;
	}

	public void setUnmarshaller(
			org.springframework.oxm.jaxb.Jaxb2Marshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public Object getParser(byte in[]) throws JAXBException {
		return getUnmarshaller().unmarshal(
				new StreamSource(new ByteArrayInputStream(in)));
	}

}
