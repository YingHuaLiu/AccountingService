package com.hangain.accounting.manager;

import com.hangain.accounting.converter.p2c.UserInfoPersistenceToCommon;
import com.hangain.accounting.dao.UserInfoDao;
import com.hangain.accounting.model.common.UserInfo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoManagerImpl implements UserInfoManager{
    private UserInfoDao userInfoDao;
    private UserInfoPersistenceToCommon userInfoPersistenceToCommon;

    @Autowired
    public UserInfoManagerImpl(UserInfoDao userInfoDao, UserInfoPersistenceToCommon userInfoPersistenceToCommon) {
        this.userInfoDao = userInfoDao;
        this.userInfoPersistenceToCommon = userInfoPersistenceToCommon;
    }

    @Override
    public UserInfo getUserInfoById(Long userId) {
        val userInfo = userInfoDao.getUserInfoById(userId);
        return userInfoPersistenceToCommon.convert(userInfo);
    }
}
