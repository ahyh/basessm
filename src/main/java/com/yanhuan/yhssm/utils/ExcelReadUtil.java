package com.yanhuan.yhssm.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 读取Excel的工具类
 * Created by yanhuan1 on 2018/1/28.
 */
public class ExcelReadUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static <T> List<T> readExcelData(String fileName, String[] fieldNameArray, Class<T> clazz) throws Exception {
        //1-获取WorkBook对象
        Workbook workBook = getWorkBookByFile(fileName);

        //2-获取属性集合
        List<Field> fieldList = getFieldListFromArray(fieldNameArray, clazz);

        List<T> ts = parseExcelData2List(workBook, fieldList, clazz);

        return ts;
    }

    /**
     * 判断输入的Excel文件是否存在,存在则返回Workbook对象
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    private static Workbook getWorkBookByFile(String fileName) throws Exception {
        if (StringUtils.isEmpty(fileName))
            throw new RuntimeException("没有指定Excel文件目录");
        Workbook wb;
        if (fileName.endsWith(".xls")) {
            wb = new HSSFWorkbook(new FileInputStream(fileName));
        } else if (fileName.endsWith(".xlsx")) {
            wb = new XSSFWorkbook(new FileInputStream(fileName));
        } else {
            throw new RuntimeException("文件不是Excel文件，无法处理");
        }
        return wb;
    }

    /**
     * 校验clazz是否有fieldNameArray中所有的属性
     *
     * @param fieldNameArray
     * @param clazz
     * @return
     */
    private static List<Field> getFieldListFromArray(String[] fieldNameArray, Class clazz) {
        Map<String, Field> fieldName2FieldMap = FieldUtil.getAllName2FieldMap(clazz);
        List<Field> fieldList = new ArrayList<>();
        for (String fieldName : fieldNameArray) {
            if (!fieldName2FieldMap.containsKey(fieldName)) {
                throw new RuntimeException("属性名" + fieldName + "在" + clazz.getName() + "类型中不存在");
            }
            fieldList.add(fieldName2FieldMap.get(fieldName));
        }
        return fieldList;
    }

    private static <T> List<T> parseExcelData2List(Workbook workbook, List<Field> fieldList, Class<T> clazz) throws Exception {
        List<T> list = new ArrayList<>();
        int sheetNum = workbook.getNumberOfSheets();
        Sheet sheet;
        Row row;
        int lastRowNum;
        T t;
        Field field;
        for (int i = 0; i < sheetNum; i++) {
            sheet = workbook.getSheetAt(i);
            lastRowNum = sheet.getLastRowNum();
            for (int j = 1; j < lastRowNum; j++) {
                row = sheet.getRow(j);
                if (null != row) {
                    t = (T) clazz.newInstance();
                    for (int c = 0; c < fieldList.size(); c++) {
                        field = fieldList.get(c);
                        if (field.getType().equals(Integer.class)) {
                            fieldList.get(c).set(t, Integer.parseInt(getCellValue(row.getCell(c))));
                        } else if (field.getType().equals(Byte.class)) {
                            fieldList.get(c).set(t, Byte.parseByte(getCellValue(row.getCell(c))));
                        } else if (field.getType().equals(Boolean.class)) {
                            fieldList.get(c).set(t, Boolean.parseBoolean(getCellValue(row.getCell(c))));
                        } else if (field.getType().equals(Double.class)) {
                            fieldList.get(c).set(t, Double.parseDouble(getCellValue(row.getCell(c))));
                        } else if (field.getType().equals(Date.class)) {
                            fieldList.get(c).set(t, sdf.parse(getCellValue(row.getCell(c))));
                        } else if (field.getType().equals(BigDecimal.class)) {
                            fieldList.get(c).set(t, new BigDecimal(getCellValue(row.getCell(c))));
                        } else {
                            fieldList.get(c).set(t, getCellValue(row.getCell(c)));
                        }
                    }
                    list.add(t);
                }
            }
        }
        return list;
    }

    private static String getCellValue(Cell cell) {
        Object result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    result = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    result = cell.getNumericCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    result = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    result = cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_ERROR:
                    result = cell.getErrorCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }

}
