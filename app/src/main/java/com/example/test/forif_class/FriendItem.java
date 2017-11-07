package com.example.test.forif_class;

import android.graphics.drawable.Drawable;

/**
 * Created by Koo on 2017-10-10.
 */

public class FriendItem {
    private Drawable img;
    private String name;
    private String status;

    public void setImg(Drawable img) {
        this.img = img ;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Drawable getImg() {
        return this.img;
    }
    public String getName() {
        return this.name;
    }
    public String getStatus() {
        return this.status;
    }
}
