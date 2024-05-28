package com.example.chatglm.service;

import com.example.chatglm.entity.Request;
import com.example.chatglm.entity.RequestTool;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface ChatGLMService {

    public String chat(Request request) throws URISyntaxException;
    public String tool(Map<String, Object> request) throws URISyntaxException, IOException;
}
