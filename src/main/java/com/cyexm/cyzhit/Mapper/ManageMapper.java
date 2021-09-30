package com.cyexm.cyzhit.Mapper;


import com.cyexm.cyzhit.POJO.Manage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageMapper {
    @Select("select * from manage where itermId = #{itermId}")
    List<Manage> FindAll(@Param("itermId")int itermId);

    @Insert("insert into manage (itermId,memberName,sex,age,education,authority,userId) " +
            "values (#{itermId},#{memberName},#{sex},#{age},#{education},#{authority},#{userId})")
    int ManageCreate(Manage manage);

    @Update("update manage set itermId=#{itermId},memberName=#{memberName},sex=#{sex},age=#{age},education=#{education},authority=#{authority}" +
            " where manageId = #{manageId}")
    int ManageUpDate(Manage manage);

    @Select("select * from manage where manageId = #{manageId}")
    Manage findManage(@Param("manageId")int manageId);

    @Delete("delete from manage where manageId = #{manageId}")
    int manageDel(@Param("manageId")int manageId);

}
