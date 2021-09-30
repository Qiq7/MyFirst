package com.cyexm.cyzhit.POJO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Data
@Getter
@Setter
public class ItermAndUser {
    private int itermId;
    private int userId;
    private int limit;
    private Date time;
    private int status;
}
