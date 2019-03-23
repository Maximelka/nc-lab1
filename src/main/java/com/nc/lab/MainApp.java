package com.nc.lab;

import com.nc.lab.model.Person;
import com.nc.lab.model.Repository;
import com.nc.lab.reflection.Injector;
import com.nc.lab.xml.DOMReader;
import com.nc.lab.xml.JAXBReader;
import com.nc.lab.xml.SAXReader;
import com.nc.lab.xml.XMLReader;
import org.joda.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.io.StringReader;

public class MainApp {

    private static String XML_PATH = "src/main/resources/persons.xml";

    public static void main(final String... args) throws Exception {
        //Repository repository = Injector.inject(new Repository());

        XMLReader xmlReader = new DOMReader();
        //XMLReader xmlReader = new SAXReader();
        //XMLReader xmlReader = new JAXBReader();
        Repository repository = xmlReader.getRepository(XML_PATH);

        System.out.println(repository.toString());

    }

}
