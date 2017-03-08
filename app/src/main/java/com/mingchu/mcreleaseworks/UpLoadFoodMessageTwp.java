package com.mingchu.mcreleaseworks;

import java.io.Serializable;


public class UpLoadFoodMessageTwp implements Serializable {

    private String key;
    private String value;


    public UpLoadFoodMessageTwp() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
