package it.sella.contrattualistica.implementation.api.xsd;

import it.sella.contrattualistica.implementation.api.contractcreation.ContractInput;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public final class ContractInfoXmlConverter {

	public ContractInfoXmlConverter() {
	}

	public <T> ContractInput buildContractInput(final T inputObject) throws Exception {
		final String xmlData = marshalling(inputObject);
		final ContractInput contractInput = unmarshalling(xmlData);
		return contractInput;
	}

	private <T> String marshalling(final T inputObject) throws Exception {
		String xmlData = null;
		try {
			final JAXBContext jaxbContext = JAXBContext.newInstance(inputObject.getClass());
			final Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			final StringWriter sw = new StringWriter();
			marshaller.marshal(inputObject, sw);
			xmlData = sw.toString();
			System.out.println("Marshelled Xml Data.............."+ xmlData);
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
		return xmlData;
	}

	private ContractInput unmarshalling(final String xmlData) throws Exception {
		ContractInput data = null;
		try {
			final JAXBContext jaxbContext = JAXBContext.newInstance(ContractInput.class);
			final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			data = (ContractInput) unmarshaller.unmarshal(new ByteArrayInputStream(xmlData.getBytes()));
			System.out.println("Marshelled ContractInput Data.............."+ data);
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
		return data;
	}
}
