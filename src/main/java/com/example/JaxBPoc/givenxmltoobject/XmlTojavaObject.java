package com.example.JaxBPoc.givenxmltoobject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlTojavaObject {
    public static void main(String[] args) throws  javax.xml.bind.JAXBException {

        File file=new File("promountfinancialresponse.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(PromountfinancialResponse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        //JAXBElement<PromountfinancialResponse> resultJAXBElement = (JAXBElement<PromountfinancialResponse>)
        PromountfinancialResponse promountfinancialResponse = (PromountfinancialResponse) jaxbUnmarshaller.unmarshal(file);

     System.out.println(promountfinancialResponse);


    }
}
