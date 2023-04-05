package com.example.JaxBPoc.jsontojava2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToJavaMain {
    public static void main(String[] args) throws IOException {
       File file=new File("file3.json");
        // ObjectMapper instantiation
        ObjectMapper objectMapper = new ObjectMapper();

// Deserialization into the `Employee` class
        Root r = objectMapper.readValue(file, Root.class);

// Print information
        System.out.println(r);
    }
}
