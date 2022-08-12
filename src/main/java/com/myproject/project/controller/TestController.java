package com.myproject.project.controller;

import com.myproject.project.util.ExcelUtils;
import org.apache.commons.lang.StringUtils;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName TestController
 * @description:
 * @author: xiongshanwen
 * @create: 2021-05-21 15:30
 **/
@Controller
public class TestController {

    @PostMapping("/calculate")
    public void test(@RequestParam("fileUpload")MultipartFile fileUpload, HttpServletResponse response
           /* ,@RequestParam("fileName") String fileName*/) throws IOException {
        String fileName = null;
        if (StringUtils.isBlank(fileName)) {
            fileName = UUID.randomUUID() + "";
        }
        InputStream inputStream = fileUpload.getInputStream();
        List<String> list = ExcelUtils.readExcel(inputStream);
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("Content-Type", "application/force-download");
        response.setContentType("application/x-download;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Content-Disposition", "attachment;filename="+ fileName +".xlsx");
        ExcelUtils.createExcel(list,outputStream);
    }

    /*
     * 获取file.html页面
     */
    @RequestMapping("file")
    public String file(){
        return "file";
    }


}
