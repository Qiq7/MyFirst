package com.cyexm.cyzhit.Mapper;

import com.cyexm.cyzhit.POJO.Iterms;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItermsMapper {

    @Insert("insert into iterms (itermId,userId,limit1,time,status,boosId) values" +
            " (#{itermId},#{userId},#{limit1},#{time},#{status},#{boosId})")
    int ItermsInsert(Iterms iterms);

    @Select("select * from iterms where userId = #{userId} and itermId = #{itermId}")
    Iterms ItermsFind(@Param("userId")int userId,@Param("itermId")int itermId);

    @Select("select * from iterms where boosId = #{userId}")
    List<Iterms> ItermFind(@Param("userId")int userId);

    @Select("select * from iterms where  itermsId = #{itermsId}")
    Iterms ItermsOne(@Param("itermsId")int itermsId);

    @Update("update iterms set itermId=#{itermId},userId=#{userId},limit1=#{limit1},time=#{time},status=#{status},boosId=#{boosId} where itermsId = #{itermsId}")
    int ItermsUpdate(Iterms iterms);

    @Delete("delete from iterms where itermsId = #{itermsId}")
    int ItermsDel(@Param("itermsId")int ItermsId);

    @Select("select * from iterms where  userId = #{userId}")
    List<Iterms> ItermsPerson(@Param("userId")int userId);
}
