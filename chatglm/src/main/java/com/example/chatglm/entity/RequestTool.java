package com.example.chatglm.entity;

import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class RequestTool {
    private double temperature = 1.1;
    private double presence_penalty=1.1;
    private int max_tokens =256;
    private Message[] messages;
    private final String model = "chatglm3-6b";
    private boolean stream = true;
    private tools[] tools;

    @Override
    public String toString() {
        return "RequestTool{" +
                "temperature=" + temperature +
                ", presence_penalty=" + presence_penalty +
                ", max_tokens=" + max_tokens +
                ", messages=" + Arrays.toString(messages) +
                ", model='" + model + '\'' +
                ", stream=" + stream +
                ", tools=" + Arrays.toString(tools) +
                '}';
    }



    public double getPresence_penalty() {
        return presence_penalty;
    }

    public void setPresence_penalty(double presence_penalty) {
        this.presence_penalty = presence_penalty;
    }

    public com.example.chatglm.entity.tools[] getTools() {
        return tools;
    }

    public void setTools(com.example.chatglm.entity.tools[] tools) {
        this.tools = tools;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(int max_tokens) {
        this.max_tokens = max_tokens;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

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

}
