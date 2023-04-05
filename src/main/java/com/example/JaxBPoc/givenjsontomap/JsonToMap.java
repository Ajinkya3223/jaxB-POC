package com.example.JaxBPoc.givenjsontomap;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonToMap {
    public static void main(String[] args) throws IOException {
        // create instance of the ObjectMapper class to map JSON data
        ObjectMapper mapper = new ObjectMapper();
        // create instance of the File class
        File file=new File("file2.json");
        Map <String,Object> userData=mapper.readValue(file,
                new TypeReference<Map<String,Object>>(){});


        userData.forEach((k,v)->{System.out.println(k+""+v);});
   System.out.println("*************************************************************");

//        ObjectMapper mapper2=new ObjectMapper();
       File file2=new File("file3.json");
//        Map <String,Object> userData2=mapper2.readValue(file2,
//                new TypeReference<Map<String,Object>>(){});
//
//
//        userData2.forEach((k,v)->{System.out.println(k+""+v);});


        // ObjectMapper instantiation
        ObjectMapper objectMapper3 = new ObjectMapper();

// Deserialization into the `Employee` class
        AuthInfo e = objectMapper3.readValue(file, AuthInfo.class);

// Print information
        System.out.println(e);

    }
}
