package com.example.JaxBPoc.javaToxml;

import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;

public class JavaTOXml {
    public static void jaxBObjectToxml(Employee e) throws JAXBException {
      /** java objects to xml String **/
        JAXBContext jaxbContext=JAXBContext.newInstance(Employee.class);
        Marshaller jabMarshaller=jaxbContext.createMarshaller();
        //Required formatting??
        jabMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        //Print XML String to Console
        StringWriter sw = new StringWriter();

        //Write XML to StringWriter
        jabMarshaller.marshal(e, sw);

        //Verify XML Content
        String xmlContent = sw.toString();
        System.out.println( xmlContent );
    }
   public static  void jaxtoXmlfile(Employee e) throws JAXBException, FileNotFoundException {
       JAXBContext jaxbContext 	= JAXBContext.newInstance( Employee.class );
       Marshaller jaxbMarshaller 	= jaxbContext.createMarshaller();

       Employee employeeObj = new Employee(1, "hari", "krishna", new Department(101, "IT"));
       OutputStream os = new FileOutputStream( "C:\\Users\\NeoSOFT\\PersonalWork\\JaxBPoc\\src\\main\\java\\com\\example\\JaxBPoc\\javaToxml\\employee.xml" );
       jaxbMarshaller.marshal( employeeObj, os );

   }

    public static void main(String[] args) throws JAXBException, FileNotFoundException, ParserConfigurationException {
        Employee e=new Employee(24,"Ram","Maruti",new Department(1,"it"));
        jaxBObjectToxml(e);

        jaxtoXmlfile(e);
        JAXBContext jaxbContext 	= JAXBContext.newInstance( Employee.class );
        Marshaller jaxbMarshaller 	= jaxbContext.createMarshaller();

      Employee employeeObj = new Employee(1, "hari", "krishna", new Department(101, "IT"));
//        OutputStream os = new FileOutputStream( "employee.xml" );
//        jaxbMarshaller.marshal( employeeObj, os );

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        jaxbMarshaller.marshal( employeeObj, doc );



    }
}
