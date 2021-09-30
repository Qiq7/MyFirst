package com.cyexm.cyzhit.POJO;


import com.cyexm.cyzhit.DaoImpl.DataImpl;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@Getter
@Setter
public class Iterm {
    private int itermId;
    private String itermName;
    private String itermContent;
    private String proposalWay;
    private Date startDate;
    private int status;
    private int memberNum;
    private String type;
    private int userId;
    private int life;
    private String itermAddr;
    private int budget;
    private String picWay;
    private String technical;
    private int authority;


    public String getYYMMdd()
    {return DataImpl.getYMd(this.startDate);
    }
    public boolean isTecknologyin(String x)
    {
        Set<String> set = new HashSet<>();
        String[] a = this.technical.split(",");
        for (String x0:a) {
            set.add(x0);
        }
        return set.contains(x);
    }
    public Iterm(String itermName, String itermContent, Date startDate, int status, int memberNum, String type, int userId, int life, String itermAddr, int budget, String picWay, String technical, int authority) {
        this.itermName = itermName;
        this.itermContent = itermContent;
        this.startDate = startDate;
        this.status = status;
        this.memberNum = memberNum;
        this.type = type;
        this.userId = userId;
        this.life = life;
        this.itermAddr = itermAddr;
        this.budget = budget;
        this.picWay = picWay;
        this.technical = technical;
        this.authority = authority;
    }

    public Iterm() {
    }

    public String getStatusshow()
    {
        if (this.status==1) return "初创期";
        else if (this.status==2) return "种子期";
        else if(this.status==3) return "成长期";
        else return "---";
    }
}
