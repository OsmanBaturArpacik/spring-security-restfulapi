package com.roofstacks.restapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JsonDeserializationService {

    public static <T> T deserialize(String responseBody, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(responseBody,type);
        } catch (Exception e){
            //daha sonra bakarız
        }
        return null;
    }

    public static <T> List<T> deserializeList(String responseBody, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(responseBody, mapper.getTypeFactory().constructCollectionType(List.class, type));
        } catch (Exception e) {

        }
        return null;
    }
}