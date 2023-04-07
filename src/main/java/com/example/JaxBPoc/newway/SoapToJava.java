package com.example.JaxBPoc.newway;

import lombok.extern.slf4j.Slf4j;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
@Slf4j
public class SoapToJava {



    public static Map<String, String> parseXML(String xmlString) {
        String resultStr = "result";
        String receiptstr = "receipt";
        String rejectedItemStr = "rejectedItem";

        Map<String, String> response = new HashMap<>();
        xmlString = xmlString.replace("SYSTEM \"cp_reply.dtd\"", "");

        log.info("Data to be parsed: " + xmlString);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
            factory.setCoalescing(true);
            factory.setNamespaceAware(true);
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(xmlString));
            Document document = builder.parse(inputSource);

            NodeList result = document.getElementsByTagName(resultStr);
            response.put(resultStr, result.item(0).getTextContent());

            NodeList receipt = document.getElementsByTagName("cp_transaction_id");
            response.put(receiptstr, receipt.item(0).getTextContent());

            NodeList rejectedItem = document.getElementsByTagName("rejected_item");

            if (rejectedItem != null && rejectedItem.item(0) != null) {
                response.put(rejectedItemStr, rejectedItem.item(0).getTextContent());
            } else {
                response.put(rejectedItemStr, "");
            }

        } catch (SAXException | IOException | ParserConfigurationException exception) {
            log.error(exception.getClass().getSimpleName() + " Exception thrown. Message: " + exception.getMessage());
        }

        return response;

    }

    public static void main(String[] args) {

     String s="  <?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>\\n\" +\n" +
             "        \"<soapenv:Envelope xmlns:soapenv=\\\"http://schemas.xmlsoap.org/soap/envelope/\\\" xmlns:tem=\\\"http://tempuri.org/\\\">\\n\" +\n" +
             "        \"    <soapenv:Header />\\n\" +\n" +
             "        \"    <soapenv:Body>\\n\" +\n" +
             "        \"        <tem:SendToWallet>\\n\" +\n" +
             "        \"            <tem:strReq>\\n\" +\n" +
             "        \"                <![CDATA[\\n\" +\n" +
             "        \"                <MobiPay ver=\\\"1.0\\\" InstitutionID=\\\"letsbank1\\\" UserName=\\\"letsbank1\\\" Password=\\\"L3ttMo1paO12\\\">\\n\" +\n" +
             "        \"                <SendToWalletRequest>\\n\" +\n" +
             "        \"                <TransType>1</TransType>\\n\" +\n" +
             "        \"                <Amount>200000</Amount>\\n\" +\n" +
             "        \"                <Description>transfer</Description>\\n\" +\n" +
             "        \"                <Recipient>264815626131</Recipient>\\n\" +\n" +
             "        \"                <SMSText>Send2Wallet BlueWallet</SMSText\\n\" +\n" +
             "        \"                ><ReqTraceID>16430</ReqTraceID>\\n\" +\n" +
             "        \"                <DateTime>2019-06-28 16:52:59</DateTime>\\n\" +\n" +
             "        \"                </SendToWalletRequest>\\n\" +\n" +
             "        \"                </MobiPay>]]></tem:strReq>\\n\" +\n" +
             "        \"        </tem:SendToWallet>\\n\" +\n" +
             "        \"    </soapenv:Body>\\n\" +\n" +
             "        \"</soapenv:Envelope>\";";
        parseXML(s);

    }
}
