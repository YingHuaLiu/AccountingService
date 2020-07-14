package com.hangain.accounting.converter.c2s;

import com.google.common.base.Converter;
import com.hangain.accounting.model.common.UserInfo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserInfoCommonToService extends Converter<UserInfo, com.hangain.accounting.model.Service.UserInfo> {

    @Override
    protected com.hangain.accounting.model.Service.UserInfo doForward(UserInfo userInfo) {
        return com.hangain.accounting.model.Service.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .build();
    }

    @Override
    protected UserInfo doBackward(com.hangain.accounting.model.Service.UserInfo userInfo) {
        return UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
    }
}
