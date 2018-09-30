package com.qiujian;

import com.qiujian.dao.logindao.IUserDAO;
import com.qiujian.dto.UserDto;
import com.qiujian.service.loginservice.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class LoginTest {
    @Autowired
    private IUserService userService;
    @Autowired
    IUserDAO userDAO;
    @Test
    public void testCase1(){
        UserDto userDto = userService.getUserDtoByName("zhangsan");
        System.out.println(userDto.getUserId() + userDto.getUserName() + userDto.getUserSalf());
    }

    @Test
    public void testCase2(){
        List<String> name = userService.getRoleDtoByName("wangwu");
        for (String str:name){
            System.out.println(str);
        }
    }

    @Test
    public void testCase3(){
        List<String> lisi = userService.getPermissionDtoByName("wangwu");
        for (String str : lisi){
            System.out.println(str);
        }
    }

    @Test
    public void hibernateTest(){
        //加载Shiro的配置文档
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-hibernate.ini");
        //创建一个安全管理公司对象
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        //选择一个保安公司
        SecurityUtils.setSecurityManager(instance);
        //聘请保安
        Subject subject = SecurityUtils.getSubject();
        try {
            //进行登陆验证
            subject.login(new UsernamePasswordToken("zhangsan","123"));
            System.out.println("登陆成功");

        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("账号或密码有误");
        }
    }

    @Test
    public void test2(){

        try {
            int i = userService.insretUser("guaiguai", "123");
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMD5(){
        SimpleHash simpleHash = new SimpleHash("MD5", "123", "zhangsan");
        System.out.println(simpleHash.toString());
        SimpleHash simpleHash1 = new SimpleHash("MD5", "123", "lisi");
        System.out.println(simpleHash1.toString());
        SimpleHash simpleHash2 = new SimpleHash("MD5", "123", "wangwu");
        System.out.println(simpleHash2.toString());
        SimpleHash simpleHash3 = new SimpleHash("MD5", "123", "huqi");
        System.out.println(simpleHash3.toString());
        SimpleHash simpleHash4 = new SimpleHash("MD5", "123", "laowang");
        System.out.println(simpleHash4.toString());
    }
}
