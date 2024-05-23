package com.example.chatglm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ChatglmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatglmApplication.class, args);
    }

}
