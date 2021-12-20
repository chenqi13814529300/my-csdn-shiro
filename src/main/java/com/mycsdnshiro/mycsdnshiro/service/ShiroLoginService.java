package com.mycsdnshiro.mycsdnshiro.service;

import com.mycsdnshiro.mycsdnshiro.entity.RoleAndPermission;
import com.mycsdnshiro.mycsdnshiro.entity.User;
import com.mycsdnshiro.mycsdnshiro.entity.UserToken;

import java.util.List;
import java.util.Map;

public interface ShiroLoginService {

    List<User> queryAllUser();

    User findByUsername(String username);

    Map<String,Object> createToken(Integer userId);

    void logout(String token);

    UserToken findByToken(String accessToken);


    User findByUserId(Integer userId);

    List<RoleAndPermission> rolePermissionByRoleId(Integer roleId);

}
