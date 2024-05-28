package com.example.chatglm.entity;

import org.springframework.stereotype.Repository;

@Repository
public class properties {
    String type;
    String description;

    @Override
    public String toString() {
        return "Parameter{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
