package com.example.magnit.XmlManager.CreateXml;

import com.example.magnit.Model.Test;
import com.example.magnit.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class XmlCreateImpl implements XmlCreate {
    private TestService testService;
    private final List<Test> list = new ArrayList<>();

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public void createXml() {
        createXmlDoc();
    }

    private void createXmlDoc() {
        final String xmlFilePath = "1.xml";
        list.addAll(testService.findAll());

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element entries = document.createElement("entries");
            document.appendChild(entries);

            for(int i = 0; i <= list.size() - 1; i++) {
                Element entry = document.createElement("entry");
                entries.appendChild(entry);

                Element field = document.createElement("field");
                field.appendChild(document.createTextNode(String.valueOf(list.get(i).getField())));
                entry.appendChild(field);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

            System.out.println("Файл 1.xml успешно создан");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
