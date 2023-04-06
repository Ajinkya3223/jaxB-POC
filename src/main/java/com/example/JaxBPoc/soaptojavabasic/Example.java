//package com.example.JaxBPoc.soaptojavabasic;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Unmarshaller;
//import javax.xml.soap.MessageFactory;
//import javax.xml.soap.SOAPException;
//import javax.xml.soap.SOAPMessage;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//
//public class Example {
//    public static void main(String[] args) throws SOAPException, IOException {
//        String example =
//                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header /><soapenv:Body><ns2:farm xmlns:ns2=\"http://adamish.com/example/farm\"><horse height=\"123\" name=\"glue factory\"/></ns2:farm></soapenv:Body></soapenv:Envelope>";
//
//        SOAPMessage message = MessageFactory.newInstance().createMessage(null,
//                new ByteArrayInputStream(example.getBytes()));
//
//        Unmarshaller unmarshaller = JAXBContext.newInstance(Farm.class).createUnmarshaller();
//        Farm farm = (Farm)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
//    }
//}
