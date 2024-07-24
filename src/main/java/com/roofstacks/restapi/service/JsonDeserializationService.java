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
//    public List<UserFetch> deserializaUserFetch(String responseBody) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            List<UserFetch> userFetchList = objectMapper.readValue(responseBody, new TypeReference<List<UserFetch>>() {});
//            for (UserFetch userFetch : userFetchList) {
//                System.out.println(userFetch);
//            }
//            return userFetchList;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//            //            throw new Exception(ex.getMessage());
//        }
//    }
}
