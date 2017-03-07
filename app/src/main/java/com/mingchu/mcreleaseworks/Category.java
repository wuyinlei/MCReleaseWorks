package com.mingchu.mcreleaseworks;


import java.io.Serializable;


public class Category implements Serializable {

    public String title;

    public int img;



    public Category(String title, int img) {
        this.title = title;
        this.img = img;
    }
}
