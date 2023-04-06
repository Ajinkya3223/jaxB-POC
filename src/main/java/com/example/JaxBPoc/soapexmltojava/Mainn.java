package com.example.JaxBPoc.soapexmltojava;

import com.example.JaxBPoc.xmlToJava.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Mainn {
    public static void main(String[] args) throws JAXBException {
        File file = new File("soapmsg.xml");
        JAXBContext jaxbcontext1=JAXBContext.newInstance(SendToWallet.class);
        Unmarshaller jaxUnmarshaller2=jaxbcontext1.createUnmarshaller();
        SendToWallet  e= (SendToWallet) jaxUnmarshaller2.unmarshal(file);
        System.out.println(e);
    }
}
