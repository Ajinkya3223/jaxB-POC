package com.example.JaxBPoc.soapexmltojava;

import net.bytebuddy.agent.VirtualMachine;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

public class SoapTOJava {

    public static void main(String[] args) throws SOAPException {

          String XML_MSG=" <?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                "    <soapenv:Header />\n" +
                "    <soapenv:Body>\n" +
                "        <tem:SendToWallet>\n" +
                "            <tem:strReq><![CDATA[<MobiPay ver=\"1.0\" InstitutionID=\"letsbank1\" UserName=\"letsbank1\" Password=\"L3ttMo1paO12\"><SendToWalletRequest><TransType>1</TransType><Amount>200000</Amount><Description>transfer</Description><Recipient>264815626131</Recipient><SMSText>Send2Wallet BlueWallet</SMSText><ReqTraceID>16430</ReqTraceID><DateTime>2019-06-28 16:52:59</DateTime></SendToWalletRequest></MobiPay>]]></tem:strReq>\n" +
                "        </tem:SendToWallet>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope> ";

        SOAPMessage soapMessage = createSOAPMessage(XML_MSG);
        System.out.println("\n\n--- Print SOAPMessage as String --- \n" + getStringFromSOAPMessage(soapMessage));


    }


    private static SOAPMessage createSOAPMessage(String xmlMessage) throws SOAPException {

        // Get SOAPMessage object from XML String
        SOAPMessage soapMessage = getSOAPMessageFromXMLString(xmlMessage, "tem", "http://tempuri.org/");
        // Add some headers
        SOAPHeader soapHeader = soapMessage.getSOAPPart().getEnvelope().addHeader();

        SOAPHeaderElement commonHeader = soapHeader.addHeaderElement(new QName("http://tempuri.org/", "LIJHeader", "lijcommon"));

        commonHeader.addAttribute(new QName("Version"), "1.0");
        commonHeader.addAttribute(new QName("MsgID"), UUID.randomUUID().toString());
        commonHeader.addAttribute(new QName("Timestamp"), new Date().toString());

        soapMessage.saveChanges();
        return soapMessage;
    }

    public static SOAPMessage getSOAPMessageFromXMLString(String xmlString,
                                                          String namespacePrefix, String namespaceURI) {

        SOAPMessage soapMessage = null;
        try {
            InputStream is = new ByteArrayInputStream(xmlString.getBytes());
            soapMessage = MessageFactory.newInstance().createMessage(null, is);

            SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
            soapEnvelope.addNamespaceDeclaration(namespacePrefix, namespaceURI);

            soapMessage.saveChanges();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soapMessage;
    }


    private static String getStringFromSOAPMessage(SOAPMessage soapMessage) {

        final StringWriter sw = new StringWriter();
        try {
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(soapMessage.getSOAPPart()),
                    new StreamResult(sw));
        } catch (TransformerException | TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}
