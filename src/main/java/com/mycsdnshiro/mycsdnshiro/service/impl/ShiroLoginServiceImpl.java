package com.mycsdnshiro.mycsdnshiro.service.impl;

import com.mycsdnshiro.mycsdnshiro.auth.TokenGenerator;
import com.mycsdnshiro.mycsdnshiro.entity.RoleAndPermission;
import com.mycsdnshiro.mycsdnshiro.entity.User;
import com.mycsdnshiro.mycsdnshiro.entity.UserToken;
import com.mycsdnshiro.mycsdnshiro.mapper.UserMapper;
import com.mycsdnshiro.mycsdnshiro.mapper.UserTokenMapper;
import com.mycsdnshiro.mycsdnshiro.service.ShiroLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ShiroLoginServiceImpl implements ShiroLoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTokenMapper userTokenMapper;
    private  final  static  int EXPIRE=12;

    @Override
    public List<User> queryAllUser() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

//    给当前登录的用户生成token
    @Override
    public Map<String, Object> createToken(Integer userId) {
        Map<String,Object> result=new HashMap<>();
//        生成一个token，代表这个用户的标识
        String token = TokenGenerator.generateValue();
//        当前时间
        LocalDateTime now = LocalDateTime.now();
//        过期时间
        LocalDateTime expireTime = now.plusHours(EXPIRE);

//        通过Id 判断是否生成过token 若有则更新，若没有则添加
        UserToken tokenEntity = userTokenMapper.findByUserId(userId);

        if(tokenEntity==null){
//            新增
            tokenEntity = new UserToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
//            新增就sql添加
            userTokenMapper.insertUserToken(tokenEntity);

        }else {
//            更新
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
//            更新就sql更新
            userTokenMapper.updateUserToken(tokenEntity);

        }
        result.put("token",token);
        result.put("expire",expireTime);
        return result;

    }

    @Override
    public void logout(String token) {

    }

    @Override
    public UserToken findByToken(String accessToken) {
        return userTokenMapper.findByToken(accessToken);
    }

    @Override
    public User findByUserId(Integer userId) {
        return userMapper.findByUserId(userId);
    }

    @Override
    public List<RoleAndPermission> rolePermissionByRoleId(Integer roleId) {
        return userMapper.rolePermissionByRoleId(roleId);
    }
}
