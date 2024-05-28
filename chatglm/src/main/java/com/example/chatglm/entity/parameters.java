package com.example.chatglm.entity;

public class parameters {

    private properties[] properties;
    private String type = "object";
    private String[] required;

    public String[] getRequired() {
        return required;
    }

    public void setRequired(String[] required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public properties[] getParameters() {
        return properties;
    }

    public void setParameters(properties[] properties) {
        this.properties = properties;
    }
}
