package com.example.JaxBPoc.soaptojavabasic;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SoMain {
    public static void main(String[] args) {
        try {
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("C:\\Users\\NeoSOFT\\Documents\\MyPersonalWorkSpace\\JaxBPoc\\src\\main\\java\\com\\example\\JaxBPoc\\soaptojavabasic\\input.xml"));
            xsr.nextTag(); // Advance to Envelope tag

            xsr.nextTag(); // Advance to Body tag
            xsr.nextTag();
            xsr.nextTag();


            JAXBContext jc = JAXBContext.newInstance(LoginResult.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<LoginResult> je = unmarshaller.unmarshal(xsr, LoginResult.class);

            System.out.println(je.getName());
            System.out.println(je.getValue());
            System.out.println(je.getValue().getErrorMessage());
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
