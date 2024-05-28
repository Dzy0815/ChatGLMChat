package com.example.chatglm.controller;

import com.example.chatglm.entity.Request;
import com.example.chatglm.entity.RequestTool;
import com.example.chatglm.service.ChatGLMService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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
    @PostMapping(value = "/tools",produces = "text/plain;charset=UTF-8")
    public String tools(@RequestBody Map<String,Object> request) throws URISyntaxException, ExecutionException, IOException, InterruptedException {
        System.out.println(request);
        return chatGLMService.tool(request);
    }
}
