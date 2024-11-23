package com.example.titleapi.DTOModels;

public class UserRoleDTO {
    private UserModelDTO user;
    private RoleModelDTO role;

    public UserRoleDTO(UserModelDTO user, RoleModelDTO role) {
        this.user = user;
        this.role = role;
    }

    public UserModelDTO getUser() {
        return user;
    }

    public void setUser(UserModelDTO user) {
        this.user = user;
    }

    public RoleModelDTO getRole() {
        return role;
    }

    public void setRole(RoleModelDTO role) {
        this.role = role;
    }
}
