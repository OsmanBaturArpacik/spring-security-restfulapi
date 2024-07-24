package com.roofstacks.restapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonSerializationService {

    public static String serialize(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.writeValueAsString(object);
        }catch (Exception e){

        }
        return null;
    }

    public static String serializeList(List<Object> objectList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(objectList);
        } catch (Exception e) {

        }
        return null;
    }
}