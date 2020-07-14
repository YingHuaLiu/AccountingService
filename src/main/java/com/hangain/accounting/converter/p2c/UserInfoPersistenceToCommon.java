package com.hangain.accounting.converter.p2c;

import com.google.common.base.Converter;
import com.hangain.accounting.model.persistence.UserInfo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserInfoPersistenceToCommon extends Converter<UserInfo, com.hangain.accounting.model.common.UserInfo> {
    @Override
    protected com.hangain.accounting.model.common.UserInfo doForward(UserInfo userInfo) {
        return com.hangain.accounting.model.common.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
    }

    @Override
    protected UserInfo doBackward(com.hangain.accounting.model.common.UserInfo userInfo) {
        return UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
    }
}
