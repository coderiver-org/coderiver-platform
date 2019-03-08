package com.coderiver.codeforum.common.entity;

import java.io.Serializable;

/**
 * Created by Shiyu Rao on 08/03/2019.
 */
public class Message<T> implements Serializable {
    private Integer type;
    private T t;

    public Message() {
    }

    public Message(Integer type, T t) {
        this.type = type;
        this.t = t;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                ", t=" + t +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
