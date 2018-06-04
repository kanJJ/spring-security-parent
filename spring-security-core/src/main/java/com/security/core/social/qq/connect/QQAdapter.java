package com.security.core.social.qq.connect;

import com.security.core.social.qq.api.QQ;
import com.security.core.social.qq.api.QQUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * 用于封装数据到spring social 管理的容器内
 * Created by Chris on 2018/5/27.
 */
public class QQAdapter implements ApiAdapter<QQ> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        logger.info("get user info");
        QQUserInfo qqUserInfo = api.getQQUserInfo();
        values.setDisplayName(qqUserInfo.getNickname());
        values.setImageUrl(qqUserInfo.getFigureurl_qq_1());
        values.setProfileUrl(null);
        values.setProviderUserId(qqUserInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {
        // do nothing
    }
}
