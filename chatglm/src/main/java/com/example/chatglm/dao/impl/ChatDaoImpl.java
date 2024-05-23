package com.example.chatglm.dao.impl;

import com.example.chatglm.dao.ChatDao;
import com.example.chatglm.entity.Request;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

@Repository
public class ChatDaoImpl implements ChatDao {
    @Override
    public String chat(Request request) throws URISyntaxException {
        WebClient webClient = WebClient.create();
        URI uri = new URI("http://8.139.254.238:8080/v1/chat/completions");
        Mono<String> response = webClient.post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request),Request.class)
                .retrieve()
                .bodyToMono(String.class);
        return response.block();
    }
}
