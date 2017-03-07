package com.mingchu.mcreleaseworks;

import java.io.Serializable;


public class UpLoadFoodMessage implements Serializable {

    private String key;
    private String value;

    public final static int INGRAEDIENTS = 0x1;  //主料
    public final static int ACCESSORIES = 0x2;  //辅料
    public final static int SEASONING = 0x3; //调料
    public final static int METHOD = 0x4;  //方法

    private int MODE = 1;

    public UpLoadFoodMessage(int MODE) {
        this.MODE = MODE;
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

    public void setMODE(int MODE) {
        this.MODE = MODE;
    }

    public int getMODE() {
        return MODE;
    }
}
