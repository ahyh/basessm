package excel.exportTest;

import com.yanhuan.yhssm.common.consts.ExcelCellMapping;
import com.yanhuan.yhssm.domain.condition.SalaryCondition;
import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.service.SalaryService;
import com.yanhuan.yhssm.test.BaseTest;
import com.yanhuan.yhssm.utils.ExcelExportUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/27.
 */
public class ExcelExportTest extends BaseTest{

    @Resource
    private SalaryService salaryService;

    @Test
    public void testExcelExport() throws Exception{
        int i=0;
        List<Salary> salaryList = salaryService.findSalaryList(new SalaryCondition());
        SXSSFWorkbook workbook = ExcelExportUtil.exportSmallFile(ExcelCellMapping.Salary.FILENAME, ExcelCellMapping.Salary.TITLES, ExcelCellMapping.Salary.PROPERTIES, salaryList);
        //只能在一级目录下创建出来
//        FileOutputStream outputStream = new FileOutputStream("D://excelTest.xls");
        File file = new File("D://excel");
        file.mkdirs();
        FileOutputStream outputStream = new FileOutputStream("D://excel//excelTest.xlsx");
        workbook.write(outputStream);
        outputStream.close();
    }

}
