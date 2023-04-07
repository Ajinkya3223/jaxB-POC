/*
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
public class Main {
    public static void  processResponse(String xmlResponse) {

        Integer statusCode;
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            docFactory.setFeature(properties.getDisallowDocType(), true);
            docFactory.setCoalescing(true);
            docFactory.setNamespaceAware(true);
            docFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            docFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            docFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

            DocumentBuilder documentBuilder = docFactory.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setEncoding(StandardCharsets.UTF_8.name());
            is.setCharacterStream(new StringReader(xmlResponse));
            Document doc = documentBuilder.parse(is);

            NodeList nodes = doc.getElementsByTagName("SendToWalletResult");

            Map<String, String> responseMap = new HashMap<>();

            for (int i = 0; i < nodes.getLength(); i++) {

                Element element = (Element) nodes.item(i);


                NodeList responseCodeNode = element.getElementsByTagName(responseCodeStr);
                String responseCode = responseCodeNode.item(0).getTextContent();
                log.info("responseCode: {}", responseCode);
                responseMap.put(responseCodeStr, responseCode);

                NodeList descriptionNode = element.getElementsByTagName(descriptionStr);
                String description = descriptionNode.item(0).getTextContent();
                responseMap.put(descriptionStr, description);

                NodeList transactionIdNode = element.getElementsByTagName(transactionIdStr);
                String transactionId = transactionIdNode.item(0).getTextContent();
                responseMap.put(transactionIdStr, transactionId);

                NodeList reqTraceIdNode = element.getElementsByTagName(reqTraceIdStr);
                String reqTraceId = reqTraceIdNode.item(0).getTextContent();
                responseMap.put(reqTraceIdStr, reqTraceId);


            }
            return extractResponse(responseMap);

        } catch (Exception e) {
            log.info(e.getClass().getSimpleName() + " An error occurred while extracting Response" + e.getMessage());

            statusCode = coreConsumerProperties.getCpg().getEscalatedStatus();
            acknowledgement.setStatusCode(statusCode);
            acknowledgement.setStatusDescription("An error occurred while extracting Response");
            log.error(acknowledgement.toString());
            return acknowledgement;
        }
    }

    public static void main(String[] args) {

    }
}
*/
