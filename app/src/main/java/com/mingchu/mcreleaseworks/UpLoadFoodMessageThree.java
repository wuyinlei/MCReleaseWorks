package com.mingchu.mcreleaseworks;

import java.io.Serializable;


public class UpLoadFoodMessageThree implements Serializable {

    private String key;
    private String value;


    public UpLoadFoodMessageThree() {

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
