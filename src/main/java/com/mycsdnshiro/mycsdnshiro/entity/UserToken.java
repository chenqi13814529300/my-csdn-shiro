package com.mycsdnshiro.mycsdnshiro.entity;

import java.time.LocalDateTime;

public class UserToken {


    private Integer userId;

    private String token;

//    过期时间
    private LocalDateTime expireTime;


//    更新时间
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "UserTokenMapper{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", expireTime=" + expireTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public UserToken(Integer userId, String token, LocalDateTime expireTime, LocalDateTime updateTime) {
        this.userId = userId;
        this.token = token;
        this.expireTime = expireTime;
        this.updateTime = updateTime;
    }

    public UserToken() {
    }
}
