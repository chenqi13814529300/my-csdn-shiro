package com.mycsdnshiro.mycsdnshiro.entity;

public class RoleAndPermission {
    private Integer userId;
    private Integer roleId;
    private String roleName;
    private String permission;

    public RoleAndPermission(Integer userId, Integer roleId, String roleName, String permission) {
        this.userId = userId;
        this.roleId = roleId;
        this.roleName = roleName;
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "RoleAndPermission{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    public RoleAndPermission() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
