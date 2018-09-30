package com.qiujian.service.impl;

import com.qiujian.dao.IPhone;
import com.qiujian.dto.*;
import com.qiujian.service.IPhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Transactional
public class PhService implements IPhService {
    @Autowired
    private IPhone phone;
    public List<PhoneDto> queryAllByPhone() {
        List<PhoneDto> phoneDtoList = phone.queryAllByPhone();
        return phoneDtoList;
    }

    public List<String> getByNameLeiXing(String phName) {
        List<String> byNameAllLeiXing = phone.getByNameAllLeiXing(phName);
        return byNameAllLeiXing;
    }

    public List<String> getShuxingNameQureyLxName(String lxName) {
        List<String> shuxingNameQureyLxName = phone.getShuxingNameQureyLxName(lxName);
        return shuxingNameQureyLxName;
    }

    public Set<LeixingDto> getLeiXingById(int phId) {
        Set<LeixingDto> leiXingByPhId = phone.getLeiXingByPhId(phId);
        return leiXingByPhId;
    }

    /**
     * 1
     * @param id
     * @return
     */
//    public Map<String,List<ShuxingDto>> getAll(int id) {
//        List<Map<String,List<ShuxingDto>>> mapList = new LinkedList<Map<String, List<ShuxingDto>>>();
//        List<InfoDto> allInfo = phone.getAllInfo();
//        List<SxPhDto> sxPhDtoList = phone.getAll(id);
//        Map<String,List<ShuxingDto>> map = new HashMap<String,List<ShuxingDto>>();
//        Map<String,List<ShuxingDto>> map1 = new HashMap<String,List<ShuxingDto>>();
//        Map<String,List<ShuxingDto>> map2 = new HashMap<String,List<ShuxingDto>>();
//        for (InfoDto infoDto : allInfo){
//            List<ShuxingDto> shuxingDtoList = new LinkedList<ShuxingDto>();
//            for (SxPhDto sxPhDto : sxPhDtoList){
//                if (infoDto.getIfId() == sxPhDto.getShuxingDto().getInfoDto().getIfId()){
//                    shuxingDtoList.add(sxPhDto.getShuxingDto());
//                }
//            }
//
//            if (shuxingDtoList != null){
//                /**
//                 * 第一页
//                 */
//                if(infoDto.getIfId()<=6 && !(infoDto.getIfName().equals("功能情况"))) {
//                    map.put(infoDto.getIfName(), shuxingDtoList);
//                }
//                /**
//                 * 第二页
//                 */
//                if (infoDto.getIfName().equals("功能情况")){
//                    map1.put(infoDto.getIfName(),shuxingDtoList);
//                }
//                /**
//                 * 第三页
//                 */
//                if (infoDto.getIfId() > 7 && !(infoDto.getIfName().equals("功能情况"))){
//                    map2.put(infoDto.getIfName(),shuxingDtoList);
//                }
//            }
//        }
//        mapList.add(map);
//        mapList.add(map1);
//        mapList.add(map2);
//        return map;
//    }

    public List<Map<String,List<ShuxingDto>>> getAll(int id) {
        List<Map<String,List<ShuxingDto>>> mapList = new LinkedList<Map<String, List<ShuxingDto>>>();
        List<InfoDto> allInfo = phone.getAllInfo();
        List<SxPhDto> sxPhDtoList = phone.getAll(id);
        Map<String,List<ShuxingDto>> map = new HashMap<String,List<ShuxingDto>>();
        Map<String,List<ShuxingDto>> map1 = new HashMap<String,List<ShuxingDto>>();
        Map<String,List<ShuxingDto>> map2 = new HashMap<String,List<ShuxingDto>>();
        for (InfoDto infoDto : allInfo){
            List<ShuxingDto> shuxingDtoList = new LinkedList<ShuxingDto>();
            for (SxPhDto sxPhDto : sxPhDtoList){
                if (infoDto.getIfId() == sxPhDto.getShuxingDto().getInfoDto().getIfId()){
                    shuxingDtoList.add(sxPhDto.getShuxingDto());
                }
            }

            if (shuxingDtoList != null){
                /**
                 * 第一页
                 */
                if(infoDto.getIfId()<=6 && !(infoDto.getIfName().equals("功能情况"))) {
                    map.put(infoDto.getIfName(), shuxingDtoList);
                }
                /**
                 * 第二页
                 */
                if (infoDto.getIfName().equals("功能情况")){
                    map1.put(infoDto.getIfName(),shuxingDtoList);
                }
                /**
                 * 第三页
                 */
                if (infoDto.getIfId() > 7 && !(infoDto.getIfName().equals("功能情况"))){
                    map2.put(infoDto.getIfName(),shuxingDtoList);
                }
            }
        }
        mapList.add(map);
        mapList.add(map1);
        mapList.add(map2);
        return mapList;
    }

    public LeixingDto getPrice(int id) {
        LeixingDto byLxId = phone.getByLxId(id);
        return byLxId;
    }

    public Integer getBySxIdAndLxId(int sxId, int lxId) {
        Integer bySxIdAndLxId = phone.getBySxIdAndLxId(sxId, lxId);
        return bySxIdAndLxId;
    }

    /**
     * 查询所有手机类型信息
     */
    public List<LeixingDto> getQueryAllLeixingDto() {
        List<LeixingDto> queryAllLeixingDto = phone.getQueryAllLeixingDto();
        return queryAllLeixingDto;
    }

//    public Integer sumPrice(String str) {
//        int i = phone.sumPrice(str);
//        return i;
//    }

}
