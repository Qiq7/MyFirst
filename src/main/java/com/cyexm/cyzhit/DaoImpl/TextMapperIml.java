package com.cyexm.cyzhit.DaoImpl;

import com.cyexm.cyzhit.Mapper.TextMapper;
import com.cyexm.cyzhit.POJO.Texts;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TextMapperIml implements TextMapper {

    @Resource
    TextMapper mapper;

    @Override
    public List<Texts> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Texts> findPage(int b, int n) {
        return mapper.findPage(b,n);
    }

    @Override
    public int pageCount() {
        return mapper.pageCount();
    }
}
