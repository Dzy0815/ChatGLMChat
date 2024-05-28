package com.example.chatglm.dao;

import com.example.chatglm.entity.Request;
import com.example.chatglm.entity.RequestTool;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Objects;

public interface ChatDao {
    public String chat(Request request) throws URISyntaxException;
    public String tool(Map<String, Object> request) throws URISyntaxException, IOException;
}
