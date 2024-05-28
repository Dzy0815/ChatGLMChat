package com.example.chatglm.entity;

import java.lang.reflect.Parameter;

public class Function {
    private String name;
    private String description;
    private parameters parameters;

    public com.example.chatglm.entity.parameters getParameters() {
        return parameters;
    }

    public void setParameters(com.example.chatglm.entity.parameters parameters) {
        this.parameters = parameters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
