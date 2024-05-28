package com.example.chatglm.dao.impl;

import com.example.chatglm.dao.ChatDao;
import com.example.chatglm.entity.Request;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChatDaoImpl implements ChatDao {
    WebClient webClient = WebClient.create();
    @Override
    public String chat(Request request) throws URISyntaxException {
        URI uri = new URI("http://8.139.254.238:8080/v1/chat/completions");
        Mono<String> response = webClient.post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request),Request.class)
                .retrieve()
                .bodyToMono(String.class);
        return response.block();
    }

    @Override
    public String tool(Map<String, Object> request) throws URISyntaxException, IOException {
            URI uri = new URI("http://8.139.254.238:8080/v1/chat/completions");
            Mono<List<String>> response = webClient.post()
                    .uri(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(request)
                    .retrieve()
                    .bodyToFlux(String.class)
                    .collectList();
            List<String> list = response.block();
            List<List<Map>> JsonList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
        assert list != null;
        for (String s : list) {
            try {
                Map map = mapper.readValue(s, Map.class);
                Object obj = map.get("choices");
                if (obj instanceof ArrayList<?>) {
                    JsonList.add((ArrayList<Map>) obj);
                }
            } catch (Exception ignored) {

            }
        }
        StringBuilder result = new StringBuilder();
        for (List<Map> l : JsonList){
            Map map = l.get(0);
            if (map.get("delta") instanceof Map<?,?>) {
                String line = (String) ((Map<?, ?>) map.get("delta")).get("content");
                if(line != null&& !line.equals("\n")){
                    result.append(line);
                }
            }
        }
        result = new StringBuilder("{\"result\":\""+result+"\"}");
        System.out.println(result);
        JsonNode jsonNode = mapper.readTree(result.toString());
        return jsonNode.toString();
    }
}
