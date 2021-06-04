package com.myproject.project.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CommonResult
 * @description:
 * @author: xiongshanwen
 * @create: 2021-06-03 10:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    private Boolean success;
    private String message;
    private T Data;

    public CommonResult(T date) {
        this.Data = date;
        this.message = "success";
        this.success = true;
    }

}
