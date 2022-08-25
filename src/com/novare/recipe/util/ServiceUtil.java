package com.novare.recipe.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import jakarta.xml.bind.Unmarshaller;

public final class ServiceUtil {

	public static Marshaller getMarshaller(Class<?> className) throws JAXBException, PropertyException {
		JAXBContext jaxbContext = JAXBContext.newInstance(className);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		return jaxbMarshaller;
	}

	public static Unmarshaller getUnmarshaller(Class<?> className) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(className);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return jaxbUnmarshaller;
	}
}
