package com.yanhuan.yhssm.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Excel相关工具类
 * Created by yanhuan1 on 2018/1/27.
 */
public final class ExcelExportUtil {

    public static Logger logger = LogManager.getLogger(ExcelExportUtil.class);
    public static final String PARAM_TITLE = "文件标题不能为空";
    public static final String PARAM_FIELDNAMES = "列表列名不能为空";
    public static final String PARAM_LIST = "列表不能为空";
    public static final String MAX_NUM_INFO = "数据量太大，不能导出";
    public static final int MAX_NUM_2003 = 65536;
    public static final int MAX_NUM_2007 = 1048576;
    public static final String EXPORT_SUFFIXNAME_2003 = "xls";
    public static final String EXPORT_SUFFIXNAME_2007 = "xlsx";

    /**
     * 导出EXCEL公共方法 导出带标题的空文件
     */
    public static SXSSFWorkbook exportExcel(String fileName, String[] fieldNames) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet(fileName);
        sheet.setDefaultColumnWidth(20);
        // 设置报表标题
        createColumHeader(workbook, sheet, fieldNames);
        return workbook;
    }

    public static <T> void exportFile(HttpServletResponse response, String fileName, String[] titles, String[] properties, List<T> list) throws Exception {
        if (list.size() == 0) {
            setResponseParam(response, fileName, EXPORT_SUFFIXNAME_2003);
            SXSSFWorkbook workbook = exportExcel(fileName, titles);
            workbook.write(response.getOutputStream());
        } else if (list.size() < MAX_NUM_2003) {
            //如果数量小于65536    则按照xls版本导出
            setResponseParam(response, fileName, EXPORT_SUFFIXNAME_2003);
            SXSSFWorkbook workbook = exportSmallFile(fileName, titles, properties, list);
            workbook.write(response.getOutputStream());
        } else {
            //如果数量大于65536   则按照xlsx版本导出
            setResponseParam(response, fileName, EXPORT_SUFFIXNAME_2007);
            SXSSFWorkbook swb = exportBigExcel(fileName, titles, properties, list);
            swb.write(response.getOutputStream());
            swb.dispose();
        }
    }


    /**
     * fileName:文件名
     * fieldNames:
     * 导出EXCEL公共方法 导出带数据的文件
     */
    public static <T> SXSSFWorkbook exportSmallFile(String fileName, String[] fieldNames, String[] fieldPreNames, List<T> list) throws Exception {
        if (StringUtils.isBlank(fileName)) {
            throw new Exception(PARAM_TITLE);
        }
        if (null == fieldNames || fieldNames.length == 0) {
            throw new Exception(PARAM_FIELDNAMES);
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new Exception(PARAM_LIST);
        }
        if (list.size() > MAX_NUM_2003) {
            throw new Exception(MAX_NUM_INFO);
        }
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet(fileName);
        sheet.setDefaultColumnWidth(20);
        // 设置报表标题
        createColumHeader(workbook, sheet, fieldNames);
        try {
            //实体类处理
            Field[] columnFields = createColumnFileds(fieldPreNames, list.get(0).getClass());
            //创建单元格
            int rowCount = 0;
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd HH:mm:ss"));
            Font font = workbook.createFont();
            font.setBold(true);
            cellStyle.setFont(font);
            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setBorderRight(BorderStyle.THIN);
            SXSSFRow row;
            for (T t : list) {
                rowCount++;
                row = sheet.createRow(rowCount);
                createCell(row, cellStyle, columnFields, t);
            }
        } catch (Exception e) {
            logger.error("导出excel创建单元格是出现异常", e);
            throw new RuntimeException("导出excel创建单元格是出现异常", e);
        }
        return workbook;
    }


    /**
     * 导出EXCEL公共方法 导出带数据的文件
     */
    public static <T> SXSSFWorkbook exportBigExcel(String fileName, String[] fieldNames, String[] fieldPreNames, List<T> list) throws Exception {
        // 1.校验传入参数是否正确
        if (StringUtils.isBlank(fileName)) {
            throw new Exception(PARAM_TITLE);
        }
        if (null == fieldNames || fieldNames.length == 0) {
            throw new Exception(PARAM_FIELDNAMES);
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new Exception(PARAM_LIST);
        }
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        int size = (list.size() - 1) / MAX_NUM_2007 + 1;
        for (int i = 0; i < size; i++) {
            List<T> subList = list.subList(MAX_NUM_2007 * i, MAX_NUM_2007 * (i + 1) > list.size() ? list.size() : MAX_NUM_2007 * (i + 1));
            if (i >= 1) {
                fileName = fileName + i;
            }
            SXSSFSheet sheet = workbook.createSheet(fileName);
            sheet.setDefaultColumnWidth(20);
            // 设置报表标题
            createColumHeader(workbook, sheet, fieldNames);
            try {
                //实体类处理
                Field[] columnFields = createColumnFileds(fieldPreNames, subList.get(0).getClass());
                //创建单元格
                int rowCount = 1;
                CellStyle style = workbook.createCellStyle();
                CreationHelper createHelper = workbook.getCreationHelper();
                style.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd HH:mm:ss"));
                Font font = workbook.createFont();
                font.setBold(true);
                style.setFont(font);
                style.setBorderBottom(BorderStyle.THIN);
                style.setBorderTop(BorderStyle.THIN);
                style.setBorderLeft(BorderStyle.THIN);
                style.setBorderRight(BorderStyle.THIN);
                Row row;
                for (T t : subList) {
                    row = sheet.createRow(rowCount);
                    createCell(row, style, columnFields, t);
                    rowCount++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("导出excel创建单元格是出现异常", e);
            }
        }
        return workbook;
    }


    /**
     * 设置列头
     *
     * @param workbook
     * @param sheet
     * @param fieldNames
     */
    private static void createColumHeader(Workbook workbook, Sheet sheet, String[] fieldNames) {
        // 设置列头
        Row row = sheet.createRow(0);
        // 指定行高
        row.setHeight((short) 400);
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
        Cell cell;
        for (int i = 0; i < fieldNames.length; i++) {
            cell = row.createCell(i);
            cell.setCellType(CellType.STRING);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new XSSFRichTextString(fieldNames[i]));
        }
    }

    /**
     * 实体类处理
     *
     * @param fieldNames
     * @param fieldClass
     * @return
     * @throws
     */
    private static Field[] createColumnFileds(String[] fieldNames, Class fieldClass) throws NoSuchFieldException {
        Field[] fields = new Field[fieldNames.length];
        Map<String, Field> fieldMap = FieldUtil.getAllName2FieldMap(fieldClass);
        for (int i = 0; i < fieldNames.length; i++) {
            Field field = fieldMap.get(fieldNames[i]);
            field.setAccessible(true);
            fields[i] = field;
        }
        return fields;
    }

    /**
     * 创建单元格
     *
     * @param <T>
     * @param row
     * @param style
     * @param columnFields
     * @param t
     */
    private static <T> void createCell(Row row, CellStyle style, Field[] columnFields, T t) {
        PropertyDescriptor pd;
        Method getMethod;
        Cell cell;
        Object field;
        for (int i = 0; i < columnFields.length; i++) {
            cell = row.createCell(i);
            try {
                pd = new PropertyDescriptor(columnFields[i].getName(), t.getClass());
                getMethod = pd.getReadMethod();//获得get方法
                field = getMethod.invoke(t);//
                cell.setCellType(CellType.STRING);
                //判断值是否为空
                if (null == field) {
                    cell.setCellValue("");
                } else if (field instanceof Date) {
                    cell.setCellValue((Date) field);
                } else {
                    cell.setCellValue((field + ""));
                }
                cell.setCellStyle(style);
            } catch (Exception e) {
                logger.error("导出excel创建单元格是出现异常", e);
            }
        }
    }

    /**
     * 导出设置参数
     *
     * @param response
     * @param fileName
     */
    public static void setResponseParam(HttpServletResponse response, String fileName, String suffixName) {
        response.setContentType("application/msexcel;charset=GBK");
        fileName = fileName + "." + suffixName;
        try {
            response.setHeader("Content-Disposition", "attachment;filename=".concat(new String(fileName.getBytes("GBK"), "iso8859-1")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Connection", "close");
        response.setHeader("Content-Type", "application/vnd.ms-excel");
    }

}
