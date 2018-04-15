package com.security.core.properties;

/**
 * Created by Chris on 2018/4/15.
 */
public class ImageCodeProperties {

    private int length = 4;
    private int width = 100;

    private int height = 50;

    private int expireIn = 60;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
