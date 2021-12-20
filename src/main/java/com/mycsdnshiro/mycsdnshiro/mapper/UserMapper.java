package com.mycsdnshiro.mycsdnshiro.mapper;

import com.mycsdnshiro.mycsdnshiro.entity.RoleAndPermission;
import com.mycsdnshiro.mycsdnshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
    User findByUserId(Integer userId);

    List<RoleAndPermission> rolePermissionByRoleId(Integer roleId);
}
