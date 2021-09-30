package com.cyexm.cyzhit.DaoImpl;

import com.cyexm.cyzhit.Mapper.UsersMapper;
import com.cyexm.cyzhit.POJO.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UsersMapperImpl implements UsersMapper {


    @Resource
    UsersMapper mapper;

    @Override
    public Users findUser(String tel) {
        return mapper.findUser(tel);
    }

    @Override
    public Users user(String tel) {
        return mapper.user(tel);
    }


    @Override
    public int CreateUser(Users user) {
        return mapper.CreateUser(user);
    }

    @Override
    public int UpDateUser(Users users) {
        return mapper.UpDateUser(users);
    }

    @Override
    public Users findUser1(int userId) {
        return mapper.findUser1(userId);
    }
}
