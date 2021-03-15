package com.example.magnit.XmlManager;

import com.example.magnit.XmlManager.CreateXml.XmlCreate;
import com.example.magnit.XmlManager.Transformer.XmlTransformer;
import com.example.magnit.XmlManager.SumFields.SumFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XmlManagerImpl implements XmlManager {
    private XmlCreate createXml;
    private XmlTransformer xmlTransformer;
    private SumFields sumFields;

    @Autowired
    public void setAutowired(XmlCreate createXml, XmlTransformer xmlTransformer, SumFields sumFields) {
        this.createXml = createXml;
        this.xmlTransformer = xmlTransformer;
        this.sumFields = sumFields;
    }

    @Override
    public void createXml() {
        createXml.createXml();
    }

    @Override
    public void sumField() {
        sumFields.sumField();
    }

    @Override
    public void transformByXsl() {
        xmlTransformer.transformByXsl();
    }
}
