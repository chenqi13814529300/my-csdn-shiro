package com.mycsdnshiro.mycsdnshiro.controller;


import com.mycsdnshiro.mycsdnshiro.dto.LoginDTO;
import com.mycsdnshiro.mycsdnshiro.entity.User;
import com.mycsdnshiro.mycsdnshiro.service.ShiroLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class ShiroLoginController {
@Autowired
private ShiroLoginService shiroLoginService;

    @PostMapping("login")
    public Map<String, Object> login(@RequestBody @Validated LoginDTO loginDTO, BindingResult bindingResult) {
//       把后端处理后的数据，封装在里面，返回给前端
        Map<String, Object> result = new HashMap<>();

//前端返回值校验
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

//        获取登录前端传入的值
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        System.out.println(username);
//        在数据库中查找是否有此用户名
        User user = shiroLoginService.findByUsername(username);
        if(user==null){
            result.put("status",300);
            result.put("mg","账号不存在");
        }else if(!user.getPassword().equals(password)){
            result.put("status",400);
            result.put("mg","密码错误");
        }else {
//            账号和密码验证正确，生成新token或者更新token并保存到数据库中
            result = shiroLoginService.createToken(user.getUserId());
            result.put("status",200);
            result.put("mg","检验通过，登录成功");
        }

        return result;
    }

}
