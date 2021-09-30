package com.cyexm.cyzhit.POJO;

import com.cyexm.cyzhit.DaoImpl.TextMapperIml;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;


@Service
public class TextPageHelper{
    private int b;
    private List<Texts> list = null;
    private int size = 3;
    @Resource
    TextMapperIml mapperIml;


    public boolean isok()
    {
        if(this.getList()==null) return false;
        return true;
    }

    public void setList(int b) {
        this.b = b;
        this.list = mapperIml.findPage((b-1)*this.size,this.size);
    }
    public List<Texts> getList(){
        return this.list;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public boolean isFirst(){
        return this.b == 1;
    }
    public boolean isLast()
    {
        return list.size()==this.size?b*this.size==mapperIml.pageCount():true;
    }

    public int getB() {
        return b;
    }
    public int getLastPage()
    {
        if(mapperIml.pageCount()==0)
        {
            return 1;
        }
        return mapperIml.pageCount()%this.size==0? mapperIml.pageCount()/this.size:mapperIml.pageCount()/this.size+1;
    }

    @Override
    public String toString() {
        return "TextPageHelper{" +
                "b=" + b +
                ", list=" + list +
                ", size=" + size +
                ", mapperIml=" + mapperIml +
                '}';
    }
}
