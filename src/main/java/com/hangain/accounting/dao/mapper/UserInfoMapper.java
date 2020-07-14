package com.hangain.accounting.dao.mapper;

import com.hangain.accounting.model.persistence.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("select * from hcas_userinfo where id=#{id}")
    UserInfo getUserInfoByUserId(@Param("id") Long id);
}
