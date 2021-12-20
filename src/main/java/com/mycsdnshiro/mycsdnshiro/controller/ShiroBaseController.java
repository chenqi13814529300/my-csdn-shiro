package com.mycsdnshiro.mycsdnshiro.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("base")
public class ShiroBaseController {

    @RequiresRoles({"admin"}) //没有的话 AuthorizationException
    @GetMapping("/admin")
    public Map<String, Object> admin(@RequestHeader("token")String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有admin角色");
        return map;
    }
    @RequiresRoles({"teacher"}) //没有的话 AuthorizationException
    @GetMapping("/teacher")
    public Map<String, Object> teacher(@RequestHeader("token")String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有teacher角色");
        return map;
    }
    @RequiresRoles({"student"}) //没有的话 AuthorizationException
    @GetMapping("/student")
    public Map<String, Object> p(@RequestHeader("token")String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有student角色");
        return map;
    }

    @RequiresPermissions({"insert"}) //没有的话 AuthorizationException
    @PostMapping("insert")
    public Map<String, Object> save(@RequestHeader("token") String token) {
        System.out.println("insert");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有insert的权力");
        return map;
    }

    @RequiresPermissions({"delete"}) //没有的话 AuthorizationException
    @DeleteMapping("delete")
    public Map<String, Object> delete(@RequestHeader("token") String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有delete的权力");
        return map;
    }

    @RequiresPermissions({"update"}) //没有的话 AuthorizationException
    @PutMapping("update")
    public Map<String, Object> update(@RequestHeader("token") String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有update的权力");
        return map;
    }

    @RequiresPermissions({"select"}) //没有的话 AuthorizationException
    @GetMapping("select")
    public Map<String, Object> select(@RequestHeader("token") String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有select的权力");
        return map;
    }

}
