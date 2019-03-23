package com.nc.lab.xml;

import com.nc.lab.model.Person;
import com.nc.lab.model.Repository;
import org.joda.time.LocalDate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXReader implements XMLReader {

    private Repository repository = new Repository();

    @Override
    public Repository getRepository(String path) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            XMLHandler handler = new XMLHandler();
            parser.parse(new File(path), handler);
            return repository;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                repository.addPerson(
                        new Person(
                                attributes.getValue("name"),
                                attributes.getValue("sex"),
                                new LocalDate(attributes.getValue("birthday"))
                        )
                );
            }
        }
    }
}
