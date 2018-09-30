package com.qiujian.dao.logindao;

import com.qiujian.dto.UserDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDAO implements IUserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * 判断用户登陆名称是否正确
     *
     * @param userName
     */
    public UserDto getUserDtoByName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Query<UserDto> query = session.createQuery("from UserDto where userName=:name");
        query.setParameter("name",userName);
        UserDto userDto = query.uniqueResult();
        return userDto;
    }

    /**
     * 通过用户名查询对应的角色信息
     *
     * @param userName
     */
    public List<String> getRoleDtoByName(String userName) {
        NativeQuery query = sessionFactory.getCurrentSession().
                createNativeQuery("select role_name from user u " +
                        "join us_ro ur join role r " +
                        "on u.user_id = ur.fk_user_id " +
                        "and ur.fk_role_id = r.role_id and u.user_name=:name");
        query.setParameter("name",userName);
        List<String> list = query.list();
        return list;
    }

    /**
     * 通过用户名查询对应角色的权限
     *
     * @param userName
     */
    public List<String> getPermissionDtoByName(String userName) {
        NativeQuery query = sessionFactory.getCurrentSession().
                createNativeQuery(" select pm_name from user u\n" +
                        "join us_ro ur\n" +
                        "join role r\n" +
                        "join ro_pm rp\n" +
                        "join permission p\n" +
                        "on u.user_id = ur.fk_user_id\n" +
                        "and ur.fk_role_id = r.role_id\n" +
                        "and r.role_id = rp.fk_role_id\n" +
                        "and rp.fk_pm_id = p.pm_id\n" +
                        "and u.user_name=:name");
        query.setParameter("name",userName);
        List<String> list = query.list();
        return list;
    }

    /**
     * 新增一条用户信息
     *
     * @param
     */
    public int insretUser(String userName,String password) throws Exception {
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setUserPassword(password);
        currentSession.save(userDto);
        currentSession.getTransaction().commit();
        currentSession.close();
        return 1;
    }
}
