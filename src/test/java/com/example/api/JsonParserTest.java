package com.example.api;



import net.minidev.json.writer.CollectionMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
//import com.fasterxml.jackson.databind.type.MapType;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

//@Test
public class JsonParserTest {

    // TODO: Use this import "import com.fasterxml.jackson.databind.type.MapType;"
//    public void JsonParserTest1(){
//        final String json = "{}";
//        final ObjectMapper mapper = new ObjectMapper();
//        final CollectionMapper.MapType type = mapper.getTypeFactory().constructMapType(
//                Map.class, String.class, Object.class
//        );
//        final Map<String, Object> data = mapper.readValue(json, type);
//    }

    public void parse(String json) throws JsonProcessingException {
        JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = mapper.readTree(json);

        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
        }
    }

    @Test
    public void parseTest1(){
//        Path resourceDirectory = Paths.get("src","test","resources");
//        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
//
//        System.out.println(absolutePath+"sample_json1.json");
        String filePath = "src/test/resources/sample_json2.json";

        try {
            // Read the JSON file content
            Path jsonFilePath = Paths.get(filePath);
            byte[] jsonBytes = Files.readAllBytes(jsonFilePath);
            String jsonContent = new String(jsonBytes, StandardCharsets.UTF_8);

            // Create a JSONObject from the JSON content
//            JSONObject jsonObject = new JSONObject(jsonContent);

            // Use the jsonObject for your test assertions or processing
            parse(jsonContent);
        } catch (IOException e) {
            // Handle any IO exceptions that may occur
            e.printStackTrace();
        }
    }

}


