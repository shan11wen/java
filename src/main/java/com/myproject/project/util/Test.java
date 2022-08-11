package com.myproject.project.util;

import org.apache.commons.lang.StringUtils;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Test
 * @description:
 * @author: xiongshanwen
 * @create: 2021-11-10 14:56
 **/
public class Test {

    /*public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        *//*String format = simpleDateFormat.format(new Date(1636523492000l));
        System.out.println("format = " + format);*//*

        *//*Date parse = simpleDateFormat.parse("2021-11-10 15:01:53");
        System.out.println("parse = " + parse);

        *//**//*Date date = new Date("1636611373799000");
        String format = simpleDateFormat.format(date);
        System.out.println("format = " + format);*//**//*

        Date date1 = new Date(1635920300041L);
        System.out.println(date1);*//*
        //System.out.println("date = " + date1.getTime());

        Date parse = simpleDateFormat.parse("2022-06-18");
        //System.out.println("parse = " + parse.getTime()/(60 * 1000));

        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("1");
        System.out.println("list = " + list);
        List<String> collect = list.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }*/

    public static void main(String[] args) throws IOException {
        List<String> tar = new ArrayList<>();
        List<String> org = readExcel();
        createExcel(org);
    }

    public static List<String> readExcel() throws IOException {
        List<String> org = new ArrayList<>();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/$R2BVZ5U.xlsx";

        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int lastRowIndex = sheet.getLastRowNum();
        System.out.println(lastRowIndex);
        for (int i = 1; i <= lastRowIndex; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row == null) { break; }

            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                String cellValue = row.getCell(j).getStringCellValue();
                org.add(cellValue);
            }
        }

        return org;

    }

    public static void createExcel(List<String> org) throws IOException{
        // 获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/finish.xlsx";

        File file = new File(filePath);
        OutputStream outputStream = new FileOutputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("直播时间");
        row.createCell(1).setCellValue("直播时间(分钟)");

        row.setHeightInPoints(30); // 设置行的高度


        for (int i = 1; i <= org.size(); i++) {
            int num = 0;
            XSSFRow row1 = sheet.createRow(i);
            row1.createCell(0).setCellValue(org.get(i-1));
            String o = org.get(i - 1);
            String[] hour = o.split("小时");
            if (hour.length > 1) {
                num += Integer.parseInt(hour[0]) * 60;
                o = hour[1];
            }
            String[] minute = o.split("分");
            num += Integer.parseInt(minute[0]);
            row1.createCell(1).setCellValue(num);

        }


        /*// 日期格式化
        XSSFCellStyle cellStyle2 = workbook.createCellStyle();
        XSSFCreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle2.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        sheet.setColumnWidth(2, 20 * 256); // 设置列的宽度

        XSSFCell cell2 = row1.createCell(2);
        cell2.setCellStyle(cellStyle2);
        cell2.setCellValue(new Date());

        row1.createCell(3).setCellValue(2);


        // 保留两位小数
        XSSFCellStyle cellStyle3 = workbook.createCellStyle();
        cellStyle3.setDataFormat(XSSFDataFormat.getBuiltinFormat("0.00"));
        XSSFCell cell4 = row1.createCell(4);
        cell4.setCellStyle(cellStyle3);
        cell4.setCellValue(29.5);


        // 货币格式化
        XSSFCellStyle cellStyle4 = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontName("华文行楷");
        font.setFontHeightInPoints((short)15);
        font.setColor(XSSFColor.XSSFColorPredefined.RED.getIndex());
        cellStyle4.setFont(font);

        XSSFCell cell5 = row1.createCell(5);
        cell5.setCellFormula("D2*E2");  // 设置计算公式

        // 获取计算公式的值
        XSSFFormulaEvaluator e = new XSSFFormulaEvaluator(workbook);
        cell5 = e.evaluateInCell(cell5);
        System.out.println(cell5.getNumericCellValue());
*/

        workbook.setActiveSheet(0);
        workbook.write(outputStream);
        outputStream.close();
    }

}
