package com.cyexm.cyzhit.Controller;


import com.cyexm.cyzhit.DaoImpl.TextMapperIml;
import com.cyexm.cyzhit.Mapper.TextMapper;
import com.cyexm.cyzhit.POJO.TextPageHelper;
import com.cyexm.cyzhit.POJO.Texts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class TextController {

    @Resource
    TextPageHelper textPageHelper;

    @RequestMapping("/text")
    public String text()
    {
        return "redirect:/show";
    }
    @RequestMapping("/show")
    public String show(Map<String, TextPageHelper> map, @RequestParam(value = "b",defaultValue = "1")int b)
    {
        if (b<=0) {
            System.out.println(b);
            return "redirect:/show";
        }
        textPageHelper.setList(b);
        System.out.println(b);
        System.out.println(textPageHelper.isFirst());
        System.out.println(textPageHelper.getB());
        if(textPageHelper.getList()==null)return "text";
        map.put("page",textPageHelper);
        System.out.println("ok");
        return "text";
    }
}
