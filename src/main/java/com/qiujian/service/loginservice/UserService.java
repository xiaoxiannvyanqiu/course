package com.qiujian.service.loginservice;

import com.qiujian.dao.logindao.IUserDAO;
import com.qiujian.dto.UserDto;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Repository
@Transactional
public class UserService implements IUserService {
    @Autowired
    private IUserDAO userDAO;
    /**
     * 判断用户登陆名称是否正确
     *
     * @param userName
     */
    public UserDto getUserDtoByName(String userName) {
        UserDto userDto = userDAO.getUserDtoByName(userName);
        return userDto;
    }

    /**
     * 通过用户名查询对应的角色信息
     *
     * @param userName
     */
    public List<String> getRoleDtoByName(String userName) {
        List<String> roleDtoByName = userDAO.getRoleDtoByName(userName);
        return roleDtoByName;
    }

    /**
     * 通过用户名查询对应角色的权限
     *
     * @param userName
     */
    public List<String> getPermissionDtoByName(String userName) {
        List<String> permissionDtoByName = userDAO.getPermissionDtoByName(userName);
        return permissionDtoByName;
    }

    /**
     * 新增一条用户信息
     *
     * @param userName
     * @param password
     */
    public int insretUser(String userName, String password) {
        SimpleHash simpleHash = new SimpleHash("MD5", password, userName);
        try {
            userDAO.insretUser(userName,simpleHash.toString());
            System.out.println("新增成功");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("新增失败");
        }
        return 0;
    }
}
