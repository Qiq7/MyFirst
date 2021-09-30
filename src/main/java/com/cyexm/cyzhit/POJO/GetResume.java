package com.cyexm.cyzhit.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class GetResume {
    private int itermsId;
    private String userName;
    private String education;
    private String type;
    private String picWay;
    private String function;
    private String itermName;

    public GetResume(int itermsId,String userName, String education, String type, String picWay, String function, String itermName) {
        this.userName = userName;
        this.education = education;
        this.type = type;
        this.picWay = picWay;
        this.function = function;
        this.itermName = itermName;
        this.itermsId = itermsId;
    }
}
