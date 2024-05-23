package com.example.chatglm.controller;

import com.example.chatglm.entity.Request;
import com.example.chatglm.service.ChatGLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/chatglm-api")
public class Controller {

    @Autowired
    ChatGLMService chatGLMService;

    @PostMapping(value = "/chat",produces = "text/plain;charset=UTF-8")
    public String chat(@RequestBody Request request) throws URISyntaxException {
        System.out.println(request);
        return chatGLMService.chat(request);
    }
}
