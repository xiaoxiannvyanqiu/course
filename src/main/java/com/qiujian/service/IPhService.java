package com.qiujian.service;

import com.qiujian.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface IPhService {
    List<PhoneDto> queryAllByPhone();

    List<String> getByNameLeiXing(String phName);

    List<String> getShuxingNameQureyLxName(String lxName);

    Set<LeixingDto> getLeiXingById(int phId);

    List<Map<String,List<ShuxingDto>>> getAll(int id);

    LeixingDto getPrice(int id);

    Integer getBySxIdAndLxId(int sxId,int lxId);

    /**
     * 查询所有手机类型信息
     */
    List<LeixingDto> getQueryAllLeixingDto();
}
