package com.cyexm.cyzhit.DaoImpl;

import com.cyexm.cyzhit.Mapper.ResumeMapper;
import com.cyexm.cyzhit.POJO.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResumeMapperImpl implements ResumeMapper{

    @Qualifier("resume")
    @Autowired
    ResumeMapper mapper;

    @Override
    public Resume findResume1(int id) {
        return mapper.findResume1(id);
    }

    @Override
    public Resume findResume(int id) {
        return mapper.findResume(id);
    }

    @Override
    public int ResumeCreat(Resume resume) {
        System.out.println(resume);
        return mapper.ResumeCreat(resume);
    }

    @Override
    public int UpDate(Resume resume) {
        return mapper.UpDate(resume);
    }

    @Override
    public List<Resume> findAll() {
        return mapper.findAll();
    }
}
