package com.hangain.accounting.controller;

import com.hangain.accounting.converter.c2s.UserInfoCommonToService;
import com.hangain.accounting.converter.p2c.UserInfoPersistenceToCommon;
import com.hangain.accounting.manager.UserInfoManager;
import com.hangain.accounting.model.Service.UserInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("v1/users")
public class UserController {
    private final UserInfoManager userInfoManager;
    private UserInfoCommonToService userInfoCommonToService;

    @Autowired
    public UserController(UserInfoManager userInfoManager, UserInfoCommonToService userInfoCommonToService) {
        this.userInfoManager = userInfoManager;
        this.userInfoCommonToService = userInfoCommonToService;
    }

    @GetMapping("/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") Long userId) {
        val userInfo = userInfoManager.getUserInfoById(userId);
        return userInfoCommonToService.convert(userInfo);
    }
}
