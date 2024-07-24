package com.roofstacks.restapi.api.controller;

import com.roofstacks.restapi.api.model.UserDto;
import com.roofstacks.restapi.service.ApiFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.roofstacks.restapi.service.JsonDeserializationService.deserialize;
import static com.roofstacks.restapi.service.JsonDeserializationService.deserializeList;
import static com.roofstacks.restapi.service.JsonSerializationService.serialize;

@RestController
@RequestMapping("/fetch")
public class ApiFetchController {
    private ApiFetchService apiFetchService;

    @Autowired
    public ApiFetchController(ApiFetchService apiFetchService) {
        this.apiFetchService = apiFetchService;
    }

    @GetMapping("/posts")
    public String fetchData() {
        String responseBody = apiFetchService.getAllPosts();
        List<UserDto> deserializedList = deserializeList(responseBody, UserDto.class);
        for (UserDto userDto : deserializedList) {
            System.out.println("id: " + userDto.id());
        }
        String serialize = serialize(deserializedList);
        System.out.println("serialize:\n" + serialize);
        return responseBody;
    }
    @GetMapping("/posts/{id}")
    public String fetchData(@PathVariable("id") String id) {
        String responseBody = apiFetchService.getPostsById(id);
        System.out.println(responseBody);
        UserDto deserialize = deserialize(responseBody, UserDto.class);
        String serialize = serialize(deserialize);
        return deserialize.userId() +" "+ deserialize.id() + "\n" + serialize;
    }

}