package com.cyexm.cyzhit.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Manage {
    int userId;
    int manageId;
    int itermId;
    String memberName;
    int sex;
    int age;
    String education;
    int authority;
    public String getshowSex()
    {
        if(this.sex==1)return "男";
        else {
            return "女" ;
        }
    }

    public Manage(int userId, int itermId, String memberName, int sex, int age, String education, int authority) {
        this.userId = userId;
        this.itermId = itermId;
        this.memberName = memberName;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.authority = authority;
    }

    public Manage() {
    }

    public String getShowauthority()
    {

        if(this.authority==2) return "管理员";
        else return "成员";
    }
}
