package com.cyexm.cyzhit.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Participation {
    private String itermName;
    private String itermType;
    private String picWay;
    private String content;
    private int status;
    private int limit;

    public Participation(String itermName, String itermType, String picWay, String content, int status, int limit) {
        this.itermName = itermName;
        this.itermType = itermType;
        this.picWay = picWay;
        this.content = content;
        this.status = status;
        this.limit = limit;
    }
}
