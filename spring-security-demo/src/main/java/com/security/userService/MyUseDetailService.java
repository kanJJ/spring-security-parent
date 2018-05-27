package com.security.userService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * Created by Chris on 2018/4/11.
 */
@Component("myUserDetailService")
public class MyUseDetailService implements UserDetailsService, SocialUserDetailsService {
    Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserDetails(username);
    }

    private UserDetails getUserDetails(String username) {
        log.info(username);
        //  return new User(username, "111", AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
        return new User(username, new BCryptPasswordEncoder().encode("111"), true,true,true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        log.info(userId);
        return (SocialUserDetails) getUserDetails(userId);
    }
}
