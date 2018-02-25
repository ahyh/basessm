package com.yanhuan.yhssm.utils;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/**
 * 写Excel工具
 */
public class ExcelWriteUtil {

    /**
     * 在第rowNum行，columnNum列写str的方法
     */
    public static void writeString(Workbook workbook, Sheet sheet, Integer rowNum, Integer columnNum, String str) {
        // 设置列头
        Row row = sheet.createRow(rowNum);
        // 指定行高
        row.setHeight((short) 700);
        CellStyle cellStyle = setCellStyle(workbook);
        Cell cell = row.createCell(columnNum);
        cell.setCellType(CellType.STRING);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(new XSSFRichTextString(str));
    }

    /**
     * 写一行数据的方法
     */
    public static void writeRowStrings(Workbook workbook, Sheet sheet, Integer rowNum, String[] strings) {
        // 设置列头
        Row row = sheet.createRow(rowNum);
        // 指定行高
        row.setHeight((short) 700);
        CellStyle cellStyle = setCellStyle(workbook);
        Cell cell;
        for (int i = 0; i < strings.length; i++) {
            cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(new XSSFRichTextString(strings[i]));
        }
    }

    /**
     * 写一行数据的方法
     */
    public static void writeEmptyRow(Workbook workbook, Sheet sheet, Integer rowNum, String[] strings, Integer height) {
        // 设置列头
        Row row = sheet.createRow(rowNum);
        // 指定行高
        row.setHeight((short) 400);
        CellStyle cellStyle = setCellStyle(workbook);
        Cell cell;
        for (int i = 0; i < strings.length; i++) {
            cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new XSSFRichTextString(strings[i]));
        }
    }

    /**
     * 写一列数据的方法
     */
    public static void writeColumnStrings(Workbook workbook, Sheet sheet, Integer columnNum, String[] strings) {
        Row row;
        CellStyle cellStyle = setCellStyle(workbook);
        for (int i = 0; i < strings.length; i++) {
            // 设置列头
            row = sheet.createRow(i);
            // 指定行高
            row.setHeight((short) 700);
            Cell cell = row.createCell(columnNum);
            cell.setCellStyle(cellStyle);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(new XSSFRichTextString(strings[i]));
        }
    }

    private static CellStyle setCellStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        // 指定单元格居中对齐
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 指定单元格垂直居中对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 指定单元格自动换行
        cellStyle.setWrapText(true);

        // 设置单元格的边框为粗体
        cellStyle.setBorderBottom(BorderStyle.THIN);
        // 设置单元格的边框颜色
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        // 单元格字体
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontName("宋体");
        font.setFontHeight((short) 200);
        cellStyle.setFont(font);
        return cellStyle;
    }

}
