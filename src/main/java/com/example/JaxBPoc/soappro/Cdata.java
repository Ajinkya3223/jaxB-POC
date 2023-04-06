package com.example.JaxBPoc.soappro;

import com.example.JaxBPoc.soapexmltojava.SendToWallet;
import com.example.JaxBPoc.soapexmltojava.SendToWalletRequest;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cdata {
public static String s=" <?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
        "    <soapenv:Header />\n" +
        "    <soapenv:Body>\n" +
        "        <tem:SendToWallet>\n" +
        "            <tem:strReq>\n" +
        "                <![CDATA[\n" +
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
        "                </MobiPay>]]></tem:strReq>\n" +
        "        </tem:SendToWallet>\n" +
        "    </soapenv:Body>\n" +
        "</soapenv:Envelope>";
    public static String removeCDATA (String s) {
        s = s.replaceAll("!\\[CDATA", "");
        s = s.replaceAll("]]", "");
        s = s.replaceAll("\\[", "");

        return s;
    }
//    public static String removeCDATA2 (String s) {
//
//        return s;
//    }

    public static void stringToDom(String xmlSource)
            throws SAXException, ParserConfigurationException, IOException, TransformerException {
        // Parse the given input
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlSource)));

        // Write the parsed document to an xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result =  new StreamResult(new File("my-file.xml"));
        transformer.transform(source, result);
    }

    public static void main(String[] args) throws JAXBException, SOAPException, IOException, XMLStreamException, ParserConfigurationException, TransformerException, SAXException {



        String t=removeCDATA(s);

        stringToDom(t);

        File file = new File("my-file.xml");
        JAXBContext jaxbcontext1=JAXBContext.newInstance(SendToWallet.class);
        Unmarshaller jaxUnmarshaller2=jaxbcontext1.createUnmarshaller();
        SendToWallet  ep= (SendToWallet) jaxUnmarshaller2.unmarshal(file);
        System.out.println(ep);
        //System.out.println(t);
System.out.println("***********************************************************");
        try {
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("soapmsg.xml"));
            xsr.nextTag(); // Advance to Envelope tag

            xsr.nextTag(); // Advance to Body tag
            xsr.nextTag();
            xsr.nextTag();
            xsr.nextTag();
            xsr.nextTag();
            xsr.nextTag();
            xsr.nextTag();



            JAXBContext jc = JAXBContext.newInstance(SendToWalletRequest.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<SendToWalletRequest> je = unmarshaller.unmarshal(xsr, SendToWalletRequest.class);

            System.out.println(je.getName());
            System.out.println(je.getValue());
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}




