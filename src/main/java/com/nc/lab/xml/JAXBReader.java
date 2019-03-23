package com.nc.lab.xml;

import com.nc.lab.model.Person;
import com.nc.lab.model.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBReader implements XMLReader {
    @Override
    public Repository getRepository(String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class, Repository.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Repository repository = (Repository) unmarshaller.unmarshal(new File(path));
            return repository;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
