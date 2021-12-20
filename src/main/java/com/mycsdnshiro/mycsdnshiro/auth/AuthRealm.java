package com.mycsdnshiro.mycsdnshiro.auth;



import com.mycsdnshiro.mycsdnshiro.entity.RoleAndPermission;
import com.mycsdnshiro.mycsdnshiro.entity.User;
import com.mycsdnshiro.mycsdnshiro.entity.UserToken;
import com.mycsdnshiro.mycsdnshiro.service.ShiroLoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Component
public class AuthRealm  extends AuthorizingRealm {

    @Autowired
    private ShiroLoginService shiroLoginService;


//    授权 获取用户角色和权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        1.从 PrincipalCollection 中获取登录用户的信息
        User user = (User) principals.getPrimaryPrincipal();
        List<RoleAndPermission> users = shiroLoginService.rolePermissionByRoleId(user.getRoleId());
//        2.添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//
        Iterator<RoleAndPermission> it = users.iterator();
        while (it.hasNext()){
            RoleAndPermission u=it.next();
            simpleAuthorizationInfo.addRole(u.getRoleName());
            simpleAuthorizationInfo.addStringPermission(u.getPermission());
            System.out.println(u.getPermission());
        }


        return simpleAuthorizationInfo;
    }



//    认证 判断token的有效性
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//       获取token,即前端传入的token
        String accessToken=(String)token.getPrincipal();
        System.out.println("此处判断token有效性"+accessToken);

//        1.根据accessToken,查询用户信息（token里面就是前端传来的用户名和密码封装后的）findByToken
        UserToken tokenEntity = shiroLoginService.findByToken(accessToken);
        System.out.println("得到用户实体"+tokenEntity);

//        2.token失败
        if(tokenEntity==null||tokenEntity.getExpireTime().isBefore(LocalDateTime.now())){

            throw new IncorrectCredentialsException("token,请重新登录");
        }

//        3.调用数据库的方法，从数据库中查询 username 对应的用户记录
        User user = shiroLoginService.findByUserId(tokenEntity.getUserId());

//        4.若用户不存在，则异常
        if(user==null){
            throw new UnknownAccountException("用户不存在");
        }

//        5.根据用户的情况，来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, this.getName());


        return info;
    }


}
