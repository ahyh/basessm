package excel.exportTest;

import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.utils.ExcelReadUtil;
import org.junit.Test;

import java.util.List;

/**
 * Excel读取文件测试
 * Created by yanhuan1 on 2018/1/28.
 */
public class ExcelReadTest {

    @Test
    public void testExcelRead() throws Exception {
        String fileName = "D://excel//excelTest.xlsx";
        String[] fieldNameArray = {"name", "age", "sex", "company", "salary", "createTime", "createUser", "updateTime", "updateUser"};
        List<Salary> salaries = ExcelReadUtil.readExcelData(fileName, fieldNameArray, Salary.class);
        salaries.stream().forEach(System.out::println);
    }

}
