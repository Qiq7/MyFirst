package com.cyexm.cyzhit.DaoImpl;


import com.cyexm.cyzhit.Mapper.ItermsMapper;
import com.cyexm.cyzhit.POJO.Iterms;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItermsImpl implements ItermsMapper {

    @Resource
    ItermsMapper itermsMapper;

    @Override
    public int ItermsInsert(Iterms iterms) {
        return itermsMapper.ItermsInsert(iterms);
    }

    @Override
    public Iterms ItermsFind(int userId, int itermId) {
        return itermsMapper.ItermsFind(userId,itermId);
    }

    @Override
    public List<Iterms> ItermFind(int userId) {
        return itermsMapper.ItermFind(userId);
    }

    @Override
    public Iterms ItermsOne(int itermsId) {
        return itermsMapper.ItermsOne(itermsId);
    }

    @Override
    public int ItermsUpdate(Iterms iterms) {
        return itermsMapper.ItermsUpdate(iterms);
    }

    @Override
    public int ItermsDel(int ItermsId) {
        return itermsMapper.ItermsDel(ItermsId);
    }

    @Override
    public List<Iterms> ItermsPerson(int itermId) {
        return itermsMapper.ItermsPerson(itermId);
    }
}
