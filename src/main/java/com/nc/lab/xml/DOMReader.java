package com.nc.lab.xml;

import com.nc.lab.model.Person;
import com.nc.lab.model.Repository;
import org.joda.time.LocalDate;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMReader implements XMLReader {

    @Override
    public Repository getRepository(String path) {
        Repository repository = new Repository();
        try {
            // Получение фабрики, чтобы после получить билдер документов.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
            Document document = builder.parse(new File(path));

            // Получение списка всех элементов person  внутри корневого элемента (getDocumentElement возвращает ROOT элемент XML файла).
            NodeList elements = document.getDocumentElement().getElementsByTagName("person");

            // Перебор всех элементов person
            for (int i = 0; i < elements.getLength(); i++) {
                Node person = elements.item(i);
                // Получение атрибутов каждого элемента
                NamedNodeMap attributes = person.getAttributes();

                repository.addPerson(
                        new Person(
                                attributes.getNamedItem("name").getNodeValue(),
                                attributes.getNamedItem("sex").getNodeValue(),
                                new LocalDate(attributes.getNamedItem("birthday").getNodeValue())
                        )
                );
            }
            return repository;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
