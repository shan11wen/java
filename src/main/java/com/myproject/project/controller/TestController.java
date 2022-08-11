package com.myproject.project.controller;

import com.myproject.project.util.ExcelUtils;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName TestController
 * @description:
 * @author: xiongshanwen
 * @create: 2021-05-21 15:30
 **/
@RestController
@RequestMapping("/file")
public class TestController {

    @PostMapping("/calculate")
    public void test(@RequestParam("fileUpload")MultipartFile fileUpload, HttpServletResponse response
            ,@RequestParam("fileName") String fileName) throws IOException {
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


}
