package com.example.dao;


import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Chilly Cui on 2020/9/9.
 */
@Mapper
public interface UserDAO {
    User login(User user);
}
