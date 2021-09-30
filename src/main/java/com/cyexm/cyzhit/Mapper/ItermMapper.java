package com.cyexm.cyzhit.Mapper;


import com.cyexm.cyzhit.POJO.Iterm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItermMapper {


    @Options(useGeneratedKeys =true, keyProperty = "itermId")
    @Insert("insert into iterm (authority,itermName,itermContent,startDate,status,memberNum,type,userId,life,itermAddr,budget,picWay,technical)" +
            "values (#{authority},#{itermName},#{itermContent},#{startDate},#{status},#{memberNum},#{type},#{userId},#{life},#{itermAddr},#{budget},#{picWay},#{technical}) ")
    int ItermCreat(Iterm iterm);

    @Select("select * from iterm where userId = #{userId} and life = 1")
    List<Iterm> findIterms(@Param("userId")int userId);

    @Delete("delete from iterm where itermId = #{itermId}")
    int delIterm(@Param("itermId")int itermId);

    @Select("select * from iterm where itermId = #{itermId}")
    Iterm findIterm(@Param("itermId")int itermId);

    @Update("update iterm set authority = #{authority},itermName = #{itermName},itermContent = #{itermContent},startDate = #{startDate},status = #{status},memberNum = #{memberNum}," +
            "type = #{type},itermAddr = #{itermAddr},budget = #{budget},picWay = #{picWay},technical = #{technical} where itermId = #{itermId}")
    int UpIterm(Iterm iterm);

    @Select("select * from iterm")
    List<Iterm> fidAll();
}
