package com.cyexm.cyzhit.DaoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataImpl {

    static Calendar calendar = Calendar.getInstance();

    public static Date getData(String data) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = data+" 00:00:00";
        return sd.parse(d);
    }
    public static String getYMd(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(date);
    }

    public static int getAge(Date userDate)
    {
        Date nowDate = new Date();
        int nY = calendar.get(Calendar.YEAR)
                ,nM = calendar.get(Calendar.MONTH)
                ,nd = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTime(userDate);

        int uY = calendar.get(Calendar.YEAR)
                ,uM = calendar.get(Calendar.MONTH)
                ,ud = calendar.get(Calendar.DAY_OF_MONTH);

        int age = nY - uY;
        if(nM<=uM)
        {
            if(nM==uM)
            {
                if(nd<ud)
                {
                    age--;
                }
            }else{
                    age--;
            }
        }
        calendar.setTime(nowDate);
        return age>0?age:0;
    }
    public static boolean isAge(String bdate) throws ParseException {
        Date data = DataImpl.getData(bdate);
        if (calendar.before(data))
        {
            return false;
        }
        return true;
    }
}
