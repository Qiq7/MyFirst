package com.cyexm.cyzhit.DaoImpl;

import com.cyexm.cyzhit.POJO.ResultMassage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChatUtils {
    public static String getMassage(boolean isSystem,String fromName,Object massage) throws JsonProcessingException {
        ResultMassage resultMassage = new ResultMassage();
        resultMassage.setSystem(isSystem);
        resultMassage.setMassage(massage);
        if (fromName!=null)
        {
            resultMassage.setFromName(fromName);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(resultMassage);
    }
}
