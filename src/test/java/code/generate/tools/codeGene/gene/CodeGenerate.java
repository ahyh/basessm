package code.generate.tools.codeGene.gene;

import code.generate.tools.codeGene.vo.ColumnInfoVo;
import code.generate.tools.codeGene.vo.TableInfoVo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器
 */
public class CodeGenerate {

    public static void main(String[] args) throws Exception {
        List<TableInfoVo> tableInfoVoListFromExcel = getTableInfoVoListFromExcel("D://excel//template.xlsx");
        CodeGeneUtils.geneMapperFile("D://excel", tableInfoVoListFromExcel.get(0));
    }

    /**
     * 从Excel中读取表信息
     */
    private static List<TableInfoVo> getTableInfoVoListFromExcel(String fileName) throws Exception {
        Workbook workbook = getWorkbookFromExcelFile(fileName);
        int sheetNum = workbook.getNumberOfSheets();
        Sheet sheet;
        List<TableInfoVo> voList = new ArrayList<>();
        TableInfoVo tableInfoVo;
        for (int i = 0; i < sheetNum; i++) {
            sheet = workbook.getSheetAt(i);
            tableInfoVo = getTableInfoVoFromSheet(sheet);
            voList.add(tableInfoVo);
        }
        return voList;
    }

    /**
     * 读取一个TableInfoVo
     *
     * @param sheet
     * @return
     */
    private static TableInfoVo getTableInfoVoFromSheet(Sheet sheet) {
        Integer lastRowNum = sheet.getLastRowNum();
        TableInfoVo tableInfoVo = new TableInfoVo();
        Row row = sheet.getRow(1);
        tableInfoVo.setTableName(getCellValue(row.getCell(0)));
        tableInfoVo.setClassName(getCellValue(row.getCell(1)));
        tableInfoVo.setPackageName(getCellValue(row.getCell(2)));
        tableInfoVo.setTableComment(getCellValue(row.getCell(3)));
        tableInfoVo.setTimeOrderQuery(!getCellValue(row.getCell(4)).equals("No"));
        tableInfoVo.setDefaultColumnNeed(!getCellValue(row.getCell(5)).equals("No"));
        List<ColumnInfoVo> columnInfoVoList = new ArrayList<>();
        ColumnInfoVo columnInfoVo;
        for (int j = 3; j < lastRowNum; j++) {
            row = sheet.getRow(j);
            columnInfoVo = new ColumnInfoVo();
            if (null != row) {
                columnInfoVo.setColumnName(getCellValue(row.getCell(0)));
                columnInfoVo.setSqlType(getCellValue(row.getCell(1)));
                if (StringUtils.isNotBlank(getCellValue(row.getCell(2)))) {
                    columnInfoVo.setLength(Integer.parseInt(getCellValue(row.getCell(2)).substring(0, getCellValue(row.getCell(2)).indexOf("."))));
                }
                columnInfoVo.setJavaFliedName(getCellValue(row.getCell(3)));
                columnInfoVo.setJavaType(getCellValue(row.getCell(4)));
                columnInfoVo.setColumnComment(getCellValue(row.getCell(5)));
                columnInfoVo.setPrimary("Yes".equals(getCellValue(row.getCell(6))) || "YES".equals(getCellValue(row.getCell(6))));
                columnInfoVo.setAutoIncrement("Yes".equals(getCellValue(row.getCell(7))) || "YES".equals(getCellValue(row.getCell(7))));
                columnInfoVo.setNullable("No".equals(getCellValue(row.getCell(8))) || "NO".equals(getCellValue(row.getCell(8))));
                if (!columnInfoVo.getPrimary()) {
                    columnInfoVo.setUnique("Yes".equals(getCellValue(row.getCell(9))) || "YES".equals(getCellValue(row.getCell(9))));
                } else {
                    columnInfoVo.setUnique(false);
                }
                columnInfoVo.setDefaultValue(getCellValue(row.getCell(10)));
                columnInfoVoList.add(columnInfoVo);
            }
        }
        if (tableInfoVo.getDefaultColumnNeed()) {
            addDefaultColumns(columnInfoVoList);
        }
        tableInfoVo.setColumnInfoVoList(columnInfoVoList);
        return tableInfoVo;
    }

    private static void addDefaultColumns(List<ColumnInfoVo> columnInfoVoList) {
        ColumnInfoVo createTimeColumn = new ColumnInfoVo("create_time", "datetime", null, "createTime", "Date", "创建时间", false, false, false, true, "");
        ColumnInfoVo createUserColumn = new ColumnInfoVo("create_user", "varchar", 50, "createUser", "String", "创建人", false, false, false, false, "");
        ColumnInfoVo updateTimeColumn = new ColumnInfoVo("update_time", "datetime", null, "updateTime", "Date", "更新时间", false, false, false, false, "");
        ColumnInfoVo updateUserColumn = new ColumnInfoVo("update_user", "varchar", 50, "updateUser", "String", "更新人", false, false, false, false, "");
        ColumnInfoVo isDeleteColumn = new ColumnInfoVo("is_delete", "tinyint", 2, "isDelete", "Byte", "删除标识", false, false, false, false, "");
        ColumnInfoVo tsColumn = new ColumnInfoVo("ts", "timestamp", null, "ts", "Date", "时间戳", false, false, false, false, "");
        columnInfoVoList.addAll(Lists.newArrayList(createTimeColumn, createUserColumn, updateTimeColumn, updateUserColumn, isDeleteColumn, tsColumn));
    }

    private static Workbook getWorkbookFromExcelFile(String fileName) throws Exception {
        if (StringUtils.isEmpty(fileName))
            throw new RuntimeException("没有指定Excel文件目录");
        Workbook wb;
        if (fileName.endsWith(".xlsx")) {
            wb = new XSSFWorkbook(new FileInputStream(fileName));
        } else if (fileName.endsWith(".xls")) {
            wb = new HSSFWorkbook(new FileInputStream(fileName));
        } else {
            throw new RuntimeException("文件不是Excel文件，无法处理");
        }
        return wb;
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
