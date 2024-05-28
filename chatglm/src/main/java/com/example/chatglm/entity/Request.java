package com.example.chatglm.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class Request {
    private double temperature = 1.1;
    private double presence_penalty=1.1;
    private int max_tokens =256;
    private Message[] messages;
    private final String model = "chatglm3-6b";

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPresencePenalty() {
        return presence_penalty;
    }

    public void setPresencePenalty(double presence_enalty) {
        this.presence_penalty = presence_enalty;
    }

    public int getMaxTokens() {
        return max_tokens;
    }

    public void setMaxTokens(int max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessage(Message[] messages) {
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Message{" +
                "temperature=" + temperature +
                ", presencePenalty=" + presence_penalty +
                ", maxTokens=" + max_tokens +
                ", message='" + Arrays.toString(messages)+ '\'' +
                    ", model='" + model + '\'' +
                    '}';
        }
    }

