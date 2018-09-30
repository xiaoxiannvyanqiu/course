package com.qiujian.controller;

import com.qiujian.dto.LeixingDto;
import com.qiujian.dto.PhoneDto;
import com.qiujian.dto.ShuxingDto;
import com.qiujian.service.IPhService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private IPhService phService;
    @RequestMapping("/all")
    public String getPhone(Model model){
        List<PhoneDto> phoneDtoList = phService.queryAllByPhone();
        List<LeixingDto> leiXingByList = phService.getQueryAllLeixingDto();
        model.addAttribute("leiXingByList",leiXingByList);
        model.addAttribute("phoneDtoList",phoneDtoList);
        return "/index.jsp";
    }
    @RequestMapping("/leixing")
    public String getLeixing(int phId,Model model){
        Set<LeixingDto> leiXingByList = phService.getLeiXingById(phId);
        List<PhoneDto> phoneDtoList = phService.queryAllByPhone();
        model.addAttribute("phoneDtoList",phoneDtoList);
        model.addAttribute("leiXingByList",leiXingByList);
        return "/index.jsp";
    }

    @RequestMapping("/shuxing")
    public String getInfo(int lxId,Model model){
        List<Map<String,List<ShuxingDto>>> listMap = phService.getAll(lxId);
        LeixingDto leixingDto = phService.getPrice(lxId);
        model.addAttribute("leixingDto",leixingDto);
        model.addAttribute("listMap",listMap);
        return "/info.jsp";
    }

    @RequestMapping("/price")
    public String getPrice(String subTypeIds , int lxId, Model model){
        String idStr = subTypeIds;
        String[] split = StringUtils.split(subTypeIds, ",");
        System.out.println(split);
        int size = 0;
        for (String str:split) {
            Integer num = Integer.parseInt(str);
                Integer price = phService.getBySxIdAndLxId(num, lxId);
                size += price;
                System.out.println(num);
                System.out.println(price);
                System.out.println(size);
        }
        LeixingDto leixingDto = phService.getPrice(lxId);
        int price = leixingDto.getLxPrice() - size;
        System.out.println("最终价格："+price);
        model.addAttribute("idStr",idStr);
        model.addAttribute("price",price);
        model.addAttribute("leixingDto",leixingDto);
        return "/mycart.jsp";
    }
//    @RequestMapping("/price")
//    public String getPrice(int lxId, Model model){
//        LeixingDto leixingDto = phService.getPrice(lxId);
//        model.addAttribute("leixingDto",leixingDto);
//        return "mycart";
//    }
}
