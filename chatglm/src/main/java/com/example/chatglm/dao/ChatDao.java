package com.example.chatglm.dao;

import com.example.chatglm.entity.Request;

import java.net.URISyntaxException;

public interface ChatDao {
    public String chat(Request request) throws URISyntaxException;
}
