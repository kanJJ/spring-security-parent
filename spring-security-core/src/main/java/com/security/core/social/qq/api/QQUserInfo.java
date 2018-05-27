package com.security.core.social.qq.api;

/**
 * Created by Chris on 2018/5/24.
 */
public class QQUserInfo {
    private String openId;
    private String nickname;    //用户在QQ空间的昵称。
    private String figureurl;    //大小为30×30像素的QQ空间头像URL。
    private String figureurl_1;//大小为50×50像素的QQ空间头像URL。
    private String figureurl_2;    //大小为100×100像素的QQ空间头像URL。
    private String figureurl_qq_1;    //大小为40×40像素的QQ头像URL。
    private String figureurl_qq_2;    //大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
    private String gender;    //性别。 如果获取不到则默认返回"男"
    private Integer is_yellow_vip;    //标识用户是否为黄钻用户（0：不是；1：是）。
    private Integer vip;//标识用户是否为黄钻用户（0：不是；1：是）
    private Integer yellow_vip_level;    //黄钻等级
    private Integer level;    //黄钻等级
    private Integer is_yellow_year_vip;   //标识是否为年费黄钻用户（0：不是； 1：是)

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFigureurl() {
        return figureurl;
    }

    public void setFigureurl(String figureurl) {
        this.figureurl = figureurl;
    }

    public String getFigureurl_1() {
        return figureurl_1;
    }

    public void setFigureurl_1(String figureurl_1) {
        this.figureurl_1 = figureurl_1;
    }

    public String getFigureurl_2() {
        return figureurl_2;
    }

    public void setFigureurl_2(String figureurl_2) {
        this.figureurl_2 = figureurl_2;
    }

    public String getFigureurl_qq_1() {
        return figureurl_qq_1;
    }

    public void setFigureurl_qq_1(String figureurl_qq_1) {
        this.figureurl_qq_1 = figureurl_qq_1;
    }

    public String getFigureurl_qq_2() {
        return figureurl_qq_2;
    }

    public void setFigureurl_qq_2(String figureurl_qq_2) {
        this.figureurl_qq_2 = figureurl_qq_2;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIs_yellow_vip() {
        return is_yellow_vip;
    }

    public void setIs_yellow_vip(Integer is_yellow_vip) {
        this.is_yellow_vip = is_yellow_vip;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getYellow_vip_level() {
        return yellow_vip_level;
    }

    public void setYellow_vip_level(Integer yellow_vip_level) {
        this.yellow_vip_level = yellow_vip_level;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIs_yellow_year_vip() {
        return is_yellow_year_vip;
    }

    public void setIs_yellow_year_vip(Integer is_yellow_year_vip) {
        this.is_yellow_year_vip = is_yellow_year_vip;
    }
}
