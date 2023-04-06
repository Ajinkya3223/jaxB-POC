package com.example.JaxBPoc.soapexmltojava;



import org.springframework.core.io.ClassPathResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.File;
import java.io.IOException;

public class MainAnother {
    public static void main(String[] args) {
        try {

           // File file = new File("C:\\Users\\NeoSOFT\\Documents\\MyPersonalWorkSpace\\JaxBPoc\\src\\main\\java\\com\\example\\JaxBPoc\\soapexmltojava\\soapmsg.xml");
            SOAPMessage message = MessageFactory.newInstance().createMessage(null, new ClassPathResource("soapmsg.xml").getInputStream());
            JAXBContext jaxbContext = JAXBContext.newInstance(SendToWallet.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            SendToWallet response = (SendToWallet) jaxbUnmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
            System.out.println(response);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SOAPException e) {
            throw new RuntimeException(e);
        }

    }
    }

