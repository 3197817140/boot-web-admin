package com.eternity.admin.mapper;

import com.eternity.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public User getUser(Integer id);
}
