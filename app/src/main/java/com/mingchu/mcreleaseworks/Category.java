package com.mingchu.mcreleaseworks;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by wuyinlei on 2017/3/7.
 */

public class Category implements Serializable {

    public String title;

    public int img;



    public Category(String title, int img) {
        this.title = title;
        this.img = img;
    }
}
