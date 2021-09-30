package com.cyexm.cyzhit.DaoImpl;

import com.cyexm.cyzhit.Mapper.ItermMapper;
import com.cyexm.cyzhit.POJO.Iterm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ItermImpl implements ItermMapper {

    @Resource
    ItermMapper itermMapper;
    @Override
    public int ItermCreat(Iterm iterm) {
        return itermMapper.ItermCreat(iterm);
    }

    @Override
    public List<Iterm> findIterms(int userId) {
        return itermMapper.findIterms(userId);
    }

    @Override
    public int delIterm(int itermId) {
        return itermMapper.delIterm(itermId);
    }

    @Override
    public Iterm findIterm(int itermId) {
        return itermMapper.findIterm(itermId);
    }

    @Override
    public int UpIterm(Iterm iterm) {
        return itermMapper.UpIterm(iterm);
    }

    @Override
    public List<Iterm> fidAll() {
        return itermMapper.fidAll();
    }

}
