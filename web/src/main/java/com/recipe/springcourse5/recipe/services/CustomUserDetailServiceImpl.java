package com.recipe.springcourse5.recipe.services;


import com.recipe.springcourse5.recipe.models.UserInfo;
import com.recipe.springcourse5.recipe.repositories.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import javax.security.auth.login.CredentialNotFoundException;
import java.util.Collections;

@Slf4j
@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    public CustomUserDetailServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    private final UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        UserInfo activeUserInfo = userInfoRepository.findByUserName(userName);
        if (activeUserInfo == null){
            log.info("Wrong credentials for user : "+userName);
            throw new UsernameNotFoundException("Wrong credentials for user : "+userName);
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
        return new User(activeUserInfo.getUserName(), activeUserInfo.getPassword(), Collections.singletonList(authority));
    }
}
