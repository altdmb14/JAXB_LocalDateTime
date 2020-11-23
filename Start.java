package ru;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class Start {
    public static final String DEFAULT_DATE_UNMARSHALLING_FILE = "file.xml";

    public static InputStream getInputStream(String file) {
        ClassLoader classLoader = Start.class.getClassLoader();
        return classLoader.getResourceAsStream(file);
    }

    public static Book unmarshalDates(InputStream inputFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Book) jaxbUnmarshaller.unmarshal(inputFile);
    }

    public static void main(String[] args) throws JAXBException {
        Book book = unmarshalDates(getInputStream(DEFAULT_DATE_UNMARSHALLING_FILE));
        System.out.println(book);
    }
}
