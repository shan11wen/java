package com.myproject.project.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName HotListDto
 * @description:
 * @author: xiongshanwen
 * @create: 2021-06-03 10:35
 **/
@Data
public class HotListDto{
    private String coverImg;
    private String title;
    private String playNum;
    private Integer commentNum;
    private String avid;
}
