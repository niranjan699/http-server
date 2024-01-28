package org.example.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParse
{

    private static final ObjectMapper mapper=getDefaultMapper();

    private static ObjectMapper getDefaultMapper() {
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return objectMapper;
    }


    public <T> T fromJson(String content, Class<T> tClass)  {

        try {
            return mapper.readValue(content,tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
