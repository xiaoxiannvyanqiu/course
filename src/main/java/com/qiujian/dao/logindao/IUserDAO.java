package com.qiujian.dao.logindao;

import com.qiujian.dto.PermissionDto;
import com.qiujian.dto.RoleDto;
import com.qiujian.dto.UserDto;

import java.util.List;

public interface IUserDAO {
    /**
     * 判断用户登陆名称是否正确
     */
    UserDto getUserDtoByName(String userName);
    /**
     * 通过用户名查询对应的角色信息
     */
    List<String> getRoleDtoByName(String userName);
    /**
     * 通过用户名查询对应角色的权限
     */
    List<String> getPermissionDtoByName(String userName);

    /**
     * 新增一条用户信息
     */
    int insretUser(String userName,String password)throws Exception;
}
