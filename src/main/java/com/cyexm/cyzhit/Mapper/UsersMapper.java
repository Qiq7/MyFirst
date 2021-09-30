package com.cyexm.cyzhit.Mapper;

import com.cyexm.cyzhit.POJO.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersMapper {
//    @Select("select * from users where userId = #{id}")
//    Users show(@Param("id") int id);
//    @Insert("insert into users (username, password ,roles) values (#{username},#{password},#{roles}) ")
//    int creat(@Param("username") String username,@Param("password") String password
//    ,@Param("roles") int roles);
//    @Select("select username,password,roles,userId from users where username = #{username}")
//    Users login(@Param("username") String username);

//    @Select("select * from users where username = #{username}")
//    Users user(@Param("username") String username);
//    @Select("select username from users where username = #{username}")
//    Users findUser(@Param("username") String username);
    @Select("select tel from users where tel = #{tel}")
    Users findUser(@Param("tel") String tel);

    @Select("select * from users where tel = #{tel}")
    Users user(@Param("tel") String tel);

    @Insert("insert into users (realName ,username ,tel ,email ,password ,roles ,picWay) values (#{realName} ," +
            "#{username} ,#{tel} ,#{email} ,#{password} ,#{roles} ,#{picWay} )")
    int CreateUser(Users users);

    @Update("update users set addr = #{addr} ,username = #{username} ,password = #{password}" +
            ", tel = #{tel} ,email = #{email} ,birthdate = #{birthdate} ,realName = #{realName}" +
            ", picWay = #{picWay} where userId = #{userId}")
    int UpDateUser(Users users);

    @Select("select * from users where userId = #{userId}")
    Users findUser1(@Param("userId")int userId);
}