package com.cyexm.cyzhit.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class Iterms {
    private int itermsId;
    private int itermId;
    private int userId;
    private int limit1;
    private Date time;
    private int status;
    private int boosId;

    public Iterms(int itermId, int userId, int limit, int status,int boosId) {
        this.itermId = itermId;
        this.userId = userId;
        this.limit1 = limit;
        this.status = status;
        this.boosId = boosId;
    }

    public Iterms() {
    }
}
