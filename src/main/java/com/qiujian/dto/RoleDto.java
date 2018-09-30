package com.qiujian.dto;

import java.util.Set;

public class RoleDto {
    private int roleId;
    private String roleName;
    private Set<PermissionDto> permissionDtos;

    public Set<PermissionDto> getPermissionDtos() {
        return permissionDtos;
    }

    public void setPermissionDtos(Set<PermissionDto> permissionDtos) {
        this.permissionDtos = permissionDtos;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleDto roleDto = (RoleDto) o;

        if (roleId != roleDto.roleId) return false;
        if (roleName != null ? !roleName.equals(roleDto.roleName) : roleDto.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
