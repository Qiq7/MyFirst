package com.cyexm.cyzhit.Mapper;

import com.cyexm.cyzhit.POJO.Resume;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("resume")
public interface ResumeMapper {


    @Select("select * from resume where resumeId = #{id} ")
    Resume findResume1(@Param("id")int id);

    @Select("select * from resume where userId = #{id} ")
    Resume findResume(@Param("id")int id);

    @Insert("insert into resume (userId ,picWay,sex,nowAddr,schoolDate,school,education,major,salary,type,function,workDate,company,post,workContent,realName,tel,email,age)" +
            " values (#{userId} , #{picWay},#{sex},#{nowAddr},#{schoolDate},#{school},#{education},#{major},#{salary},#{type},#{function},#{workDate},#{company},#{post},#{workContent},#{realName},#{tel},#{email},#{age})")
    int ResumeCreat(Resume resume);

    @Update("update resume set addr = #{addr}, picWay = #{picWay},sex = #{sex},nowAddr = #{nowAddr},schoolDate = #{schoolDate}, school=#{school},education=#{education},major=#{major},salary=#{salary},type=#{type},function=#{function},workDate=#{workDate},company=#{company},post=#{post},workContent=#{workContent},realName=#{realName},tel=#{tel},email=#{email},age=#{age} where resumeId = #{resumeId}")
    int UpDate(Resume resume);

    @Select("select * from resume")
    List<Resume> findAll();
}
