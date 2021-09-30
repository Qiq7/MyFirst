package com.cyexm.cyzhit.Mapper;


import com.cyexm.cyzhit.POJO.ItermAndUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItermAndUserMapper {

    @Select("select * from iterms where itermId = #{itermId}")
    public List<ItermAndUser> findAll(@Param("itermId")int itermId);
}
