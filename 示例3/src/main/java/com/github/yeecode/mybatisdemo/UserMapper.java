package com.github.yeecode.mybatisdemo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> queryUserBySchoolName(User user);

    List<User> queryUserBySchoolName2(int id, String name, @Param("emailAddress") String email, int age, String schoolName);
}
