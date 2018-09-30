package com.qiujian.dto;

import java.util.Set;

public class UserDto {
    private int userId;
    private String userName;
    private String userPassword;
    private String userSalf;
    private Set<RoleDto> roleDtoSet;

    public Set<RoleDto> getRoleDtoSet() {
        return roleDtoSet;
    }

    public void setRoleDtoSet(Set<RoleDto> roleDtoSet) {
        this.roleDtoSet = roleDtoSet;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSalf() {
        return userSalf;
    }

    public void setUserSalf(String userSalf) {
        this.userSalf = userSalf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (userId != userDto.userId) return false;
        if (userName != null ? !userName.equals(userDto.userName) : userDto.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(userDto.userPassword) : userDto.userPassword != null)
            return false;
        if (userSalf != null ? !userSalf.equals(userDto.userSalf) : userDto.userSalf != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userSalf != null ? userSalf.hashCode() : 0);
        return result;
    }
}
