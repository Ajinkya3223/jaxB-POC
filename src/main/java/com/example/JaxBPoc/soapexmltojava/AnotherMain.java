package com.example.JaxBPoc.soapexmltojava;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class AnotherMain {
    public static void main(String[] args) throws Exception {
        File file = new File("soapmsg.xml");
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);

        NodeList nodes = doc.getElementsByTagName("topic");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            NodeList title = element.getElementsByTagName("title");
            Element line = (Element) title.item(0);
            System.out.println("Title: " + getCharacterDataFromElement(line));
        }
    }
    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }
}
