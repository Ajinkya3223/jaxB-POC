package com.example.JaxBPoc.xmlToJava;

import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

public class XmlStringToJava {


    @SneakyThrows
    public static void main(String[] args) throws JAXBException {
       /**xml String to java Object **/
        String xmlString = "<employee>" +
                "    <department>" +
                "        <id>101</id>" +
                "        <name>IT</name>" +
                "    </department>" +
                "    <firstName>Ram</firstName>" +
                "    <id>1</id>" +
                "    <lastName>Krishna</lastName>" +
                "</employee>";

       JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

        Unmarshaller jaxbUnmarshaller = null;

            jaxbUnmarshaller = jaxbContext.createUnmarshaller();


        Employee employee = (Employee) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));

        System.out.println(employee);



        /** xml file to java object Unmarshalling**/
        File file=new File("C:\\Users\\NeoSOFT\\PersonalWork\\JaxBPoc\\src\\main\\java\\com\\example\\JaxBPoc\\xmlToJava\\employee.xml");
        JAXBContext jaxbcontext1=JAXBContext.newInstance(Employee.class);
        Unmarshaller jaxUnmarshaller2=jaxbcontext1.createUnmarshaller();
        Employee e= (Employee) jaxUnmarshaller2.unmarshal(file);
        System.out.println(e);
    }
}
