package com.cyexm.cyzhit.Mapper;


import com.cyexm.cyzhit.POJO.Texts;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextMapper {

    @Select("select * from text")
    List<Texts> findAll();

    @Select("select * from text limit #{b},#{n} ")
    List<Texts> findPage(@Param("b")int b,@Param("n")int n);

    @Select("select count(*) from text")
    int pageCount();
}
