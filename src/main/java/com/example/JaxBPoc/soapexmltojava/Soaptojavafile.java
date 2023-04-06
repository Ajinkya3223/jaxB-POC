package com.example.JaxBPoc.soapexmltojava;

import com.example.JaxBPoc.soaptojavabasic.LoginResult;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.VirtualMachine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

@Slf4j
public class Soaptojavafile {
    public static void main(String[] args) {
        try {
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("C:\\Users\\NeoSOFT\\Documents\\MyPersonalWorkSpace\\JaxBPoc\\src\\main\\java\\com\\example\\JaxBPoc\\soapexmltojava\\soapmsg.xml"));
            xsr.nextTag(); // Advance to Envelope tag

            xsr.nextTag(); // Advance to Body tag
            xsr.nextTag();
            xsr.nextTag();


            JAXBContext jc = JAXBContext.newInstance(SendToWallet.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<SendToWallet> je = unmarshaller.unmarshal(xsr, SendToWallet.class);

            log.info(je.toString());
            System.out.println(je.getValue());
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            String xmml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                    "    <soapenv:Header />\n" +
                    "    <soapenv:Body>\n" +
                    "        <tem:SendToWallet>\n" +
                    "            <tem:strReq>\n" +
                    "                \n" +
                    "                <MobiPay ver=\"1.0\" InstitutionID=\"letsbank1\" UserName=\"letsbank1\" Password=\"L3ttMo1paO12\">\n" +
                    "                <SendToWalletRequest>\n" +
                    "                <TransType>1</TransType>\n" +
                    "                <Amount>200000</Amount>\n" +
                    "                <Description>transfer</Description>\n" +
                    "                <Recipient>264815626131</Recipient>\n" +
                    "                <SMSText>Send2Wallet BlueWallet</SMSText\n" +
                    "                ><ReqTraceID>16430</ReqTraceID>\n" +
                    "                <DateTime>2019-06-28 16:52:59</DateTime>\n" +
                    "                </SendToWalletRequest>\n" +
                    "                </MobiPay></tem:strReq>\n" +
                    "        </tem:SendToWallet>\n" +
                    "    </soapenv:Body>\n" +
                    "</soapenv:Envelope>";

            File file = new File("C:\\Users\\NeoSOFT\\Documents\\MyPersonalWorkSpace\\JaxBPoc\\src\\main\\java\\com\\example\\JaxBPoc\\soapexmltojava\\soapmsg.xml");
            SOAPMessage message = MessageFactory.newInstance().createMessage(null,
                    new ByteArrayInputStream(xmml.getBytes()));
            JAXBContext jaxbContext = JAXBContext.newInstance(SendToWallet.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            SendToWallet response = (SendToWallet) jaxbUnmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
            System.out.println(response);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
