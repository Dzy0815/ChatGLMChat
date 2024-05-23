package com.example.chatglm.service.impl;

import com.example.chatglm.dao.ChatDao;
import com.example.chatglm.entity.Request;
import com.example.chatglm.service.ChatGLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Service
public class ChatGLMServiceImpl implements ChatGLMService {

    @Autowired
    ChatDao chatDao;

    public String chat(Request request) throws URISyntaxException {
        return chatDao.chat(request);
    }
}
