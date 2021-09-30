package com.cyexm.cyzhit.Service;

import com.cyexm.cyzhit.DaoImpl.*;
import com.cyexm.cyzhit.POJO.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

@Service
public class RegistService {


    @Resource
    ManageImpl manageImpl;

    @Resource
    ItermsImpl iterms;
    @Resource
    ItermImpl itermImpl;

    @Resource
    UsersMapperImpl usersMapperImpl;

    @Resource
    ResumeMapperImpl resumeMapper;
    public int CreatUser(String realName,String username,String tel,String email,String
                         password) {
        int roles = 0;
        String picWay = "image/13.jpg";
        Users  user = new Users(username,password,roles,tel,email,realName,picWay);
        return usersMapperImpl.CreateUser(user);
    }
    public int CreatResume(int userId,String picWay,String realName,String tel,String email)
    {
        Resume resume = new Resume(userId,picWay,realName,tel,email, Tools.getRandom1or0());
        return resumeMapper.ResumeCreat(resume);
    }

    public int CreatIterm(String title, String type, int secrecy, String technology, String time
            , int schedule, int number, String city, int budget, String description, String picWay,int UserId) throws ParseException {
        Iterm iterm = new Iterm(title,description, DataImpl.getData(time),schedule,number,type,UserId,1,city,budget,picWay,technology,secrecy);
        itermImpl.ItermCreat(iterm);
//        System.out.println(iterm);

        return iterm.getItermId() ;
    }
    public Users findUser1(int userId) {
        return usersMapperImpl.findUser1(userId);
    }

    public void CreatIterms(int itermId, int userId, int boosId)
    {
        Iterms t = new Iterms(itermId,userId,3,2,boosId);
        iterms.ItermsInsert(t);
    }
    public int CreatItermsAdmin(int itermId,int userId,int boosId)
    {
        Iterms t = new Iterms(itermId,userId,1,1,boosId);
        return iterms.ItermsInsert(t);
    }


    public List<GetResume> GetgetResume(int userId){
        List<Iterms> b = iterms.ItermFind(userId);
        List<GetResume> a = new LinkedList<>();
        for (Iterms x:b) {
            int uId = x.getUserId();
            int iId = x.getItermId();

            System.out.println(x);
            Iterm it = itermImpl.findIterm(iId);
            Resume re = resumeMapper.findResume(uId);
//            System.out.println(it);
//            System.out.println(re);
            GetResume getResume = new GetResume(x.getItermsId(),re.getRealName(),re.getEducation(),re.getType(),re.getPicWay(),re.getFunction(),it.getItermName());
            if(x.getStatus()==2) {
                a.add(getResume);
            }
        }
        return a;
    }

    public List<Participation> getParticipation(int userId)
    {
        List<Iterms> la = iterms.ItermsPerson(userId);
        List<Participation> lp = new LinkedList<>();
        for (Iterms x:la) {
//            System.out.println(x);
            Iterm it = itermImpl.findIterm(x.getItermId());
            String itermName = it.getItermName(),itermType = it.getType()
                    ,picWay = it.getPicWay(),content = it.getItermContent();
            int status = x.getStatus(),limit = x.getLimit1();
        Participation p = new Participation(itermName,itermType,picWay,content,status,limit);
        if(x.getBoosId()!=userId) {
            lp.add(p);
        }
//            System.out.println(p);
        }
        return lp;
    }

    public void ManageCreat(Iterms it){
        Resume re = resumeMapper.findResume(it.getUserId());
        String memberName = re.getRealName(),
                education = re.getEducation();
        int sex = re.getSex(),authority = 3,age = re.getAge(),
        userId = re.getUserId(),itermId = it.getItermId();
        Manage manage = new Manage(userId,itermId,memberName,sex,age,education,authority);
        manageImpl.ManageCreate(manage);
    };

}
