package com.hangain.accounting.dao;

import com.hangain.accounting.model.persistence.UserInfo;

public interface UserInfoDao {
    UserInfo getUserInfoById(Long id);

    void createNewUser(String username,String password);
}
