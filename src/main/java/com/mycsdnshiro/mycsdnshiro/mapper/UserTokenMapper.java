package com.mycsdnshiro.mycsdnshiro.mapper;

import com.mycsdnshiro.mycsdnshiro.entity.UserToken;

public interface UserTokenMapper {

    UserToken findByToken(String token);

    UserToken findByUserId(Integer userId);

    int  insertUserToken(UserToken userToken);
    int updateUserToken(UserToken userToken);
}
