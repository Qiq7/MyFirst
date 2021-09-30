package com.cyexm.cyzhit.DaoImpl;

import com.cyexm.cyzhit.Mapper.ManageMapper;
import com.cyexm.cyzhit.POJO.Manage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManageImpl implements ManageMapper {

    @Resource
    ManageMapper manageMapper;

    @Override
    public List<Manage> FindAll(int itermId) {
        return manageMapper.FindAll(itermId);
    }

    @Override
    public int ManageCreate(Manage manage) {
        return manageMapper.ManageCreate(manage);
    }

    @Override
    public int ManageUpDate(Manage manage) {
        return manageMapper.ManageUpDate(manage);
    }

    @Override
    public Manage findManage(int manageId) {
        return manageMapper.findManage(manageId);
    }

    @Override
    public int manageDel(int manageId) {
        return manageMapper.manageDel(manageId);
    }


}
