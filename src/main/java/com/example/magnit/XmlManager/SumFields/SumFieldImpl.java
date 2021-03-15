package com.example.magnit.XmlManager.SumFields;

import java.io.*;
import java.util.stream.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import org.springframework.stereotype.*;

@Component
public class SumFieldImpl implements SumFields {

    public void sumField() {
        sum(parseToArray());
    }

    private long[] parseToArray() {
        try {
            File file = new File("2.xml");
            InputStream inputStream = new FileInputStream(file);

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            NodeList nodeList = document.getElementsByTagName("entry");

            long[] resultArray = new long[nodeList.getLength() + 1];

            for (int x = 0; x <= nodeList.getLength() - 1; x++) {
                Node node = nodeList.item(x);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    resultArray[x] = Long.parseLong(element.getAttribute("field"));
                }
            }
            return resultArray;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sum(long[] array) {
        System.out.println("Сумма всех Fields = " + LongStream.of(array).parallel().sum());
    }
}
