package com.security.core.social.weixin.connect;

import com.security.core.social.weixin.api.WeiXin;
import com.security.core.social.weixin.api.WeiXinUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * Created by Chris on 2018/6/10.
 */
public class WeiXInAdapter implements ApiAdapter<WeiXin> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String openId;

    public WeiXInAdapter() {
    }

    public WeiXInAdapter(String openId) {
        this.openId = openId;
    }

    @Override
    public boolean test(WeiXin api) {
        return false;
    }

    @Override
    public void setConnectionValues(WeiXin api, ConnectionValues values) {
        //获取数据
        WeiXinUserInfo weiXinUserInfo = api.getWeiXinUserInfo(openId);
        // 参数封装
        values.setProviderUserId(weiXinUserInfo.getOpenid());
        values.setDisplayName(weiXinUserInfo.getNickname());
        values.setImageUrl(weiXinUserInfo.getHeadimgurl());
        values.setProfileUrl(null);
    }

    @Override
    public UserProfile fetchUserProfile(WeiXin api) {
        return null;
    }

    @Override
    public void updateStatus(WeiXin api, String message) {

    }
}
