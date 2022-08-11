package com.myproject.project.util;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExcelUtils
 * @description:
 * @author: xiongshanwen
 * @create: 2022-08-03 18:33
 **/
public class ExcelUtils {

    public static List<String> readExcel(InputStream inputStream) throws IOException {
        List<String> org = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
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

    public static void createExcel(List<String> org, ServletOutputStream outputStream) throws IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        XSSFRow row = sheet.createRow(0);

        //
        sheet.setColumnWidth(0, 20 * 256);
        sheet.setColumnWidth(1, 20 * 256);

        XSSFFont font = workbook.createFont();
        font.setFontName("华文行楷");
        font.setFontHeightInPoints((short)15);
        font.setColor(new XSSFColor(new Color(241, 5, 51)));

        XSSFCellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1.setFillForegroundColor(new XSSFColor(new Color(105, 224, 239)));
        cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        cellStyle1.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle1.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle1.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle1.setBorderRight(BorderStyle.THIN);//右边框

        XSSFCellStyle cellStyle2 = workbook.createCellStyle();
        cellStyle2.setFillForegroundColor(new XSSFColor(new Color(105, 224, 239)));
        cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle2.setFont(font);
        cellStyle2.setAlignment(HorizontalAlignment.CENTER);
        cellStyle2.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle2.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle2.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle2.setBorderRight(BorderStyle.THIN);//右边框

        XSSFCellStyle cellStyle3 = workbook.createCellStyle();
        cellStyle3.setFillForegroundColor(new XSSFColor(new Color(170, 226, 131)));
        cellStyle3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle3.setAlignment(HorizontalAlignment.CENTER);
        cellStyle3.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle3.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle3.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle3.setBorderRight(BorderStyle.THIN);//右边框

        XSSFCellStyle cellStyle4 = workbook.createCellStyle();
        cellStyle4.setFillForegroundColor(new XSSFColor(new Color(170, 226, 131)));
        cellStyle4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle4.setFont(font);
        cellStyle4.setAlignment(HorizontalAlignment.CENTER);
        cellStyle4.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle4.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle4.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle4.setBorderRight(BorderStyle.THIN);//右边框

        XSSFCell cell = row.createCell(0);
        cell.setCellValue("直播时间");
        cell.setCellStyle(cellStyle2);

        XSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("直播时间(分钟)");
        cell1.setCellStyle(cellStyle4);

        row.setHeightInPoints(30); // 设置行的高度


        for (int i = 1; i <= org.size(); i++) {
            int num = 0;
            XSSFRow row1 = sheet.createRow(i);
            XSSFCell cell2 = row1.createCell(0);
            cell2.setCellValue(org.get(i-1));
            cell2.setCellStyle(cellStyle1);
            String o = org.get(i - 1);
            String[] hour = o.split("小时");
            if (hour.length > 1) {
                num += Integer.parseInt(hour[0]) * 60;
                o = hour[1];
            }
            String[] minute = o.split("分");
            num += Integer.parseInt(minute[0]);
            XSSFCell cell3 = row1.createCell(1);
            cell3.setCellValue(num);
            cell3.setCellStyle(cellStyle3);
        }

        workbook.setActiveSheet(0);
        workbook.write(outputStream);
        outputStream.close();
    }
}
