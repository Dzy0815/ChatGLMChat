package com.example.chatglm.service.impl;

import com.example.chatglm.dao.ChatDao;
import com.example.chatglm.entity.Request;
import com.example.chatglm.entity.RequestTool;
import com.example.chatglm.service.ChatGLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@Service
public class ChatGLMServiceImpl implements ChatGLMService {

    @Autowired
    ChatDao chatDao;

    public String chat(Request request) throws URISyntaxException {
        return chatDao.chat(request);
    }

    public String tool(Map<String,Object> request) throws URISyntaxException, IOException {
        return chatDao.tool(request);
    }
}
