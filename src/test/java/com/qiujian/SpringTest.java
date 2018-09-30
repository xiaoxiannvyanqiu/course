package com.qiujian;

import com.qiujian.dao.IPhone;
import com.qiujian.dto.*;
import com.qiujian.service.IPhService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class SpringTest {

    @Autowired
    private IPhService phService;
    @Autowired
    private IPhone phone;
    @Test
    public void testCase1(){
        List<PhoneDto> phoneDtos = phService.queryAllByPhone();
        for (PhoneDto phoneDto:phoneDtos){
            System.out.println(phoneDto.getPhName());
        }
    }
    @Test
    public void testCase2(){
        List<String> iphone = phService.getByNameLeiXing("iphone");
        for (String leixingDto:iphone){
            System.out.println(leixingDto);
        }
    }

    @Test
    public void testCase3(){
        List<String> sxNameList = phService.getShuxingNameQureyLxName("iphone7");
        for (String sxName : sxNameList){
            System.out.println(sxName);
        }
    }

    @Test
    public void testCase4(){
        Set<LeixingDto> leiXingByPhId = phone.getLeiXingByPhId(1);
        for (LeixingDto leixingDto : leiXingByPhId){
            System.out.println(leixingDto.getLxPrice());
        }
    }

    @Test
    public void testCase6(){
        List<SxPhDto> all = phone.getAll(1);
        for (SxPhDto sxPhDto : all){
            System.out.println(sxPhDto.getShuxingDto().getSxName());
            System.out.println(sxPhDto.getSpPrice());
            System.out.println(sxPhDto.getLeixingDto().getLxName());
            System.out.println(sxPhDto.getShuxingDto().getInfoDto().getIfName()
            );
        }
    }

    @Test
    public void testCase7() {
        List<Map<String, List<ShuxingDto>>> mapList = phService.getAll(1);
        Map<String,List<ShuxingDto>> map = mapList.get(1);
//        Set<String> strings = all.keySet();
       // for (Map<String, List<ShuxingDto>> map : mapList) {
            for (Map.Entry<String, List<ShuxingDto>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<ShuxingDto> valueList = entry.getValue();
                for (ShuxingDto value : valueList) {
                    String sxName = value.getSxName();
                    System.out.println(key + ":\t" + sxName);
                }
            }
        //}
    }
    @Test
    public void testCase8(){
        LeixingDto price = phService.getPrice(1);
        System.out.println(price.getLxName() + price.getLxImg() + price.getLxPrice());
    }
    @Test
    public void testCase9(){
        int num = phone.sumPrice("1,2,3,4",1);
        System.out.println(num);
    }
}
