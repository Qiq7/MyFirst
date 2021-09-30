package com.cyexm.cyzhit.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMassage {
    private boolean isSystem;
    private String fromName;
    private Object massage;
}
