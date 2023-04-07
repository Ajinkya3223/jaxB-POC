package com.example.JaxBPoc.newway;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Slf4j
public class SoapToMapConverter {

    public static Map<String, Object> convertSoapToMap(String soapXml) throws Exception {
        Map<String, Object> result = new HashMap<>();

        /** Use the built-in XML parser to parse the SOAP XML into a DOM document **/
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new ByteArrayInputStream(soapXml.getBytes("UTF-8")));

        /** Extract the body element from the SOAP envelope **/
        Element bodyElement = (Element) doc.getElementsByTagName("soapenv:Body").item(0);

        /** Extract the strReq element from the SendToWallet element **/
        Element sendToWalletElement = (Element) bodyElement.getElementsByTagName("tem:SendToWallet").item(0);
        Element strReqElement = (Element) sendToWalletElement.getElementsByTagName("tem:strReq").item(0);

        /** Get the CDATA content from the strReq element **/
        String cdataContent = strReqElement.getTextContent();

        /** Parse the CDATA content as XML **/
        DocumentBuilder innerBuilder = dbFactory.newDocumentBuilder();
        Document innerDoc = innerBuilder.parse(new ByteArrayInputStream(cdataContent.getBytes("UTF-8")));
        Element mobiPayElement = (Element) innerDoc.getElementsByTagName("MobiPay").item(0);

        /** Extract the attributes from the MobiPay element **/
        Map<String, String> mobiPayAttributes = new HashMap<>();
        mobiPayAttributes.put("ver", mobiPayElement.getAttribute("ver"));
        mobiPayAttributes.put("InstitutionID", mobiPayElement.getAttribute("InstitutionID"));
        mobiPayAttributes.put("UserName", mobiPayElement.getAttribute("UserName"));
        mobiPayAttributes.put("Password", mobiPayElement.getAttribute("Password"));
        result.put("MobiPay", mobiPayAttributes);

        /** Extract the SendToWalletRequest element **/
        Element sendToWalletRequestElement = (Element) mobiPayElement.getElementsByTagName("SendToWalletRequest").item(0);

        /** Extract the child elements of the SendToWalletRequest element **/
        NodeList childNodes = sendToWalletRequestElement.getChildNodes();
        Map<String, Object> sendToWalletRequest = new HashMap<>();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) childNode;
                sendToWalletRequest.put(childElement.getTagName(), childElement.getTextContent());
            }
        }
        result.put("SendToWalletRequest", sendToWalletRequest);

        return result;
    }

    public static void main(String[] args) throws Exception {
       String s="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
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

           Map<String,Object> map=convertSoapToMap(s);
        log.info("input in string --{}",s);
        log.info("output is map {}",map);
    }
}
