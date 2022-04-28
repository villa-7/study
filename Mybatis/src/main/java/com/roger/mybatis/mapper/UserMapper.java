package com.roger.mybatis.mapper;

import com.roger.mybatis.bean.User;

import java.util.List;

public interface UserMapper {

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 查询指定用户
     * @return 用户
     */
    User getById(int id);

    /**
     * 查询所有用户
     * @return 所有用户
     */
    List<User> getAll();
}
