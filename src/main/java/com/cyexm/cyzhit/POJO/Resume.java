package com.cyexm.cyzhit.POJO;

import com.cyexm.cyzhit.DaoImpl.DataImpl;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Data
@Setter
@Getter
public class Resume {
    private int resumeId;
    private int userId;
    private String nowAddr;
    private Date schoolDate;
    private String school;
    private String education;
    private int salary;
    private String type;
    private String addr;
    private String function;
    private String workDate;
    private String company;
    private String post;
    private String workContent;
    private String picWay;
    private int sex;
    private String major;
    private String realName;
    private String tel;
    private String email;
    private int age;

    public boolean isokAge(){return this.age==0;}
    public boolean isokNowaddr(){return this.nowAddr==null;}
    public boolean isokMajor(){return this.major==null;}
    public boolean isPic()
    {
        return this.picWay==null;
    }
    public String getYYMMddDate()
    {
        return DataImpl.getYMd(this.schoolDate);
    }
    public boolean isokSchoolDate()
    {
        return this.schoolDate==null;
    }
    public boolean isokSchool()
    {
        return this.school==null;
    }
    public boolean isokEducation()
    {
        return this.education==null;
    }
    public boolean isokSalary()
    {
        return this.salary==0;
    }
    public boolean isokType()
    {
        return this.type==null;
    }
    public boolean isokAddr()
    {
        return this.addr==null;
    }
    public boolean isokFunction()
    {
        return this.function==null;
    }
    public boolean isokWorkdata()
    {
        return this.workDate==null;
    }
    public boolean isokCompany()
    {
        return this.company==null;
    }
    public boolean isokPost()
    {
        return this.post==null;
    }
    public boolean isokWorkContent()
    {
        return this.workContent==null;
    }
    public boolean isokSex(){return this.sex==-1;}
    public String getshowSex()
    {
        if(this.sex==1) return "男";
        return "女";
    }

    public Resume() {
    }

    public Resume(int userId, String picWay,String realName,String tel,String email,int sex) {
        this.userId = userId;
        this.picWay = picWay;
        this.realName=realName;
        this.tel = tel;
        this.email = email;
        this.sex = sex;
    }
}
