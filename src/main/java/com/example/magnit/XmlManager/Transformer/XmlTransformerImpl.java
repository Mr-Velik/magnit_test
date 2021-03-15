package com.example.magnit.XmlManager.Transformer;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import org.springframework.stereotype.*;

@Component
public class XmlTransformerImpl implements XmlTransformer {

    public void transformByXsl() {
        transform();
    }

    private void transform() {
        final String xmlFilePathInput = "1.xml";
        final String xmlFilePathResult = "2.xml";
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File("src/main/resources/transformerByXSLT.xsl"));
            Transformer transformer = factory.newTransformer(xslt);

            Source input = new StreamSource(new File(xmlFilePathInput));
            StreamResult streamResult = new StreamResult(new File(xmlFilePathResult));
            transformer.transform(input, streamResult);

            System.out.println("Файл 2.xml успешно создан");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
