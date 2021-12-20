package com.mycsdnshiro.mycsdnshiro.entity;

public class User {

    private Integer userId;
    private String username;
    private String password;
    private Integer roleId;
    private String roleName;
    private String permission;
    private Integer permissionId;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", permission='" + permission + '\'' +
                ", permissionId=" + permissionId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public User() {
    }

    public User(Integer userId, String username, String password, Integer roleId, String roleName, String permission, Integer permissionId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.roleName = roleName;
        this.permission = permission;
        this.permissionId = permissionId;
    }
}
