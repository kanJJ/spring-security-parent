package com.security.core.properties;

/**
 * Created by Chris on 2018/4/15.
 */
public class ValidateCodeProperties {

    public ValidateCodeProperties() {
    }

    private ImageCodeProperties image = new ImageCodeProperties();
    private String urls;

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
