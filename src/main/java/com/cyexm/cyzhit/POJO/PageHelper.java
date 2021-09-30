package com.cyexm.cyzhit.POJO;

import java.util.List;

public interface PageHelper<T>{
     boolean isOk();
     void setList();
     List<T> getList();
     void setSize();
     boolean isFirst();
     boolean isLast();
     int getB();
     int getLastPage();
}
