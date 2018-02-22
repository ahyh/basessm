package code.generate.tools.templateGene;

import com.yanhuan.yhssm.utils.ExcelWriteUtil;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;

/**
 * 代码生成工具生成的Excel模板
 * 功能：生成一个Excel文件，开发人员只需要将表名、列名、描述信息等填入
 * Excel即可生成代码
 */
public class TemplateGenerate {

    public static void main(String[] args) throws Exception {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet("数据库设计模板");
        sheet.setDefaultColumnWidth(20);
        String[] strings = {"表名", "类名", "包名", "描述", "是否为创建时间按范围查询(默认为NO)", "是否生成默认的字段(默认为YES)", "", "", "", "", ""};
        ExcelWriteUtil.writeRowStrings(workbook, sheet, 0, strings);
        String[] emptyStrs = {"", "", "", "", "", "", "", "", "", "", ""};
        ExcelWriteUtil.writeEmptyRow(workbook, sheet, 1, emptyStrs, 400);
        String[] newStrs = {"列名", "sql类型", "字段长度", "java属性名", "java类型", "字段描述", "是否是主键（默认NO）", "是否自增（默认NO）", "允许为空（默认为YES，允许）", "是否唯一索引（默认NO）", "默认值"};
        ExcelWriteUtil.writeRowStrings(workbook, sheet, 2, newStrs);
        for (int i = 3; i < 11; i++) {
            ExcelWriteUtil.writeEmptyRow(workbook, sheet, i, emptyStrs, 400);
        }
        FileOutputStream outputStream = new FileOutputStream("D://excel//template.xlsx");
        workbook.write(outputStream);
        outputStream.close();
    }

}
