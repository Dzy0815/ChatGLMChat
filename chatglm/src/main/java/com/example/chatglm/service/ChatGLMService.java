package com.example.chatglm.service;

import com.example.chatglm.entity.Request;

import java.net.URISyntaxException;

public interface ChatGLMService {

    public String chat(Request request) throws URISyntaxException;
}
