package com.qiujian.dao.impl;

import com.qiujian.dao.IPhone;
import com.qiujian.dto.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class Phone implements IPhone {
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * 查询所有手机品牌信息
     */
    public List<PhoneDto> queryAllByPhone() {
        Query query = sessionFactory.getCurrentSession().createQuery("from PhoneDto");
        List<PhoneDto> phoneDtoList = query.list();
        return phoneDtoList;
    }

    /**
     * 查询所有手机类型信息
     */
    public List<LeixingDto> getQueryAllLeixingDto() {
        Query query = sessionFactory.getCurrentSession().createQuery("from LeixingDto ");
        List<LeixingDto> leixingDtoList = query.list();
        return leixingDtoList;
    }

    /**
     * 根据手机品牌名称查询对应的手机类型
     *
     * @param phoneName
     */
    public List<String> getByNameAllLeiXing(String phoneName) {
        NativeQuery nativeQuery = sessionFactory.getCurrentSession().createNativeQuery("select lx_name from phone p inner join leixing l on p.ph_id = l.fk_ph_id and p.ph_name =?;");
        nativeQuery.setParameter(1,phoneName);
        List<String> leixingDtoList = nativeQuery.list();
        return leixingDtoList;
    }

    /**
     * 根据手机类型名称查询其所对应的属性信息
     *
     * @param lxName
     */
    public List<String> getShuxingNameQureyLxName(String lxName) {
        NativeQuery nativeQuery = sessionFactory.getCurrentSession().createNativeQuery("select sx_name from leixing l\n" +
                "join sx_ph sp\n" +
                "join shuxing s\n" +
                "on sp.fk_lx_id = l.lx_id\n" +
                "and sp.fk_sx_id = s.sx_id\n" +
                "and l.lx_name = ?;");
        nativeQuery.setParameter(1,lxName);
        List<String> sxNameList = nativeQuery.list();
        return sxNameList;
    }

    /**
     * 根据品牌ID查询该ID对应的手机类型信息
     *
     * @param phId
     */
    public Set<LeixingDto> getLeiXingByPhId(int phId) {
        PhoneDto phoneDto = sessionFactory.getCurrentSession().get(PhoneDto.class, phId);
        Set<LeixingDto> leixingDtos = phoneDto.getLeixingDtos();
        return leixingDtos;
    }


    /**
     * 查询所有父属性信息
     */
    public List<InfoDto> getAllQureyInfo() {
        Query query = sessionFactory.getCurrentSession().createQuery("from InfoDto ");
        List<InfoDto> infoDtos = query.list();
        return infoDtos;
    }
   public List<SxPhDto> getAll(int id){
       Query query = sessionFactory.getCurrentSession().createQuery("from SxPhDto where leixingDto.lxId=:id");
       query.setParameter("id",id);
       List<SxPhDto> sxPhDtos = query.list();
       return sxPhDtos;
   }

    public List<InfoDto> getAllInfo() {
        Query query = sessionFactory.getCurrentSession().createQuery("from InfoDto ");
        List<InfoDto> infoDtos = query.list();
        return infoDtos;
    }

    /**
     * 根据类型ID查询类型对象
     *
     * @param lxId
     */
    public LeixingDto getByLxId(int lxId) {
        LeixingDto leixingDto = sessionFactory.getCurrentSession().get(LeixingDto.class, lxId);
        return leixingDto;
    }

    /**
     * 通过手机属性ID手机类型ID查询子属性的价格
     *
     * @param sxId
     * @param lxId
     */
    public Integer getBySxIdAndLxId(int sxId, int lxId) {
        //sum
        Query query = sessionFactory.getCurrentSession().createQuery("select spPrice from SxPhDto where shuxingDto.sxId=:idtwo and leixingDto.lxId=:id");
        query.setParameter("idtwo",sxId);
        query.setParameter("id",lxId);
        Integer price = (Integer) query.uniqueResult();
        return price;
    }

    /**
     * 通过子属性ID算出扣除的价格
     *
     * @param str
     */
    public int sumPrice(String  str,int lxId) {
        NativeQuery nativeQuery = sessionFactory.getCurrentSession()
                .createNativeQuery("select sum(sp_price) from sx_ph where fk_lx_id=? and fk_sx_id in (?);");
        nativeQuery.setParameter(1,lxId);
        nativeQuery.setParameter(2,str);
        String s = nativeQuery.uniqueResult().toString();
        int i = Integer.parseInt(s);
        return i;
    }

}
