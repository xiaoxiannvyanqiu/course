package com.qiujian.dao;

import com.qiujian.dto.*;

import java.util.List;
import java.util.Set;

public interface IPhone {
    /**
     * 查询所有手机品牌信息
     */
    List<PhoneDto> queryAllByPhone();

    /**
     * 查询所有手机类型信息
     */
    List<LeixingDto> getQueryAllLeixingDto();

    /**
     * 根据手机品牌名称查询对应的手机类型
     */
    List<String> getByNameAllLeiXing(String phoneName);

    /**
     * 根据手机类型名称查询其所对应的属性信息
     */
    List<String> getShuxingNameQureyLxName(String phName);

    /**
     * 根据品牌ID查询该ID对应的手机类型信息
     */
    Set<LeixingDto> getLeiXingByPhId(int phId);



    /**
     * 查询所有父属性信息
     */
    List<InfoDto> getAllQureyInfo();

    List<SxPhDto> getAll(int id);

    List<InfoDto> getAllInfo();

    /**
     * 根据类型ID查询类型对象
     */
    LeixingDto getByLxId(int lxId);

    /**
     * 通过手机属性ID手机类型ID查询子属性的价格
     */
    Integer getBySxIdAndLxId(int sxId,int lxId);

    /**
     * 通过子属性ID算出扣除的价格
     */
    int sumPrice(String str,int lxId);
}
