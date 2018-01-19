package com.yanhuan.yhssm.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yanhuan.yhssm.domain.Salary;
import com.yanhuan.yhssm.domain.SalaryCondition;
import com.yanhuan.yhssm.domain.SalaryPageCondition;
import com.yanhuan.yhssm.service.SalaryService;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public class SalaryServiceTest extends BaseTest{

    @Resource
    private SalaryService salaryService;

    /**
     * 测试插入方法，插入后的主键值可以通过salary.getId()方法获取
     */
    @Test
    public void testInsert(){
        Salary salary = new Salary();
        salary.setName("小王");
        salary.setAge(31);
        salary.setSex((byte)1);
        salary.setCompany("tx.com");
        salary.setSalary(new BigDecimal(22222));
        salary.setCreateTime(new Date());
        salary.setUpdateTime(new Date());
        salary.setCreateUser("yanhuan");
        salary.setUpdateUser("yanhuan");
        Integer insert = salaryService.insert(salary);
        System.out.println(insert);
    }

    @Test
    public void testPage(){
        SalaryPageCondition condition = new SalaryPageCondition();
        condition.setPageNum(1);
        condition.setPageSize(3);
        condition.setOrderBy("name desc");
        PageInfo<Salary> salaryPageInfo = salaryService.selectSalaryPage(condition);
        List<Salary> list = salaryPageInfo.getList();
        System.out.println();
    }

    @Test
    public void testFindList(){
        SalaryCondition salaryCondition = new SalaryCondition();
        List<Salary> salaryList = salaryService.findSalaryList(salaryCondition);
        System.out.println();
    }

    @Test
    public void testSelectByCondition(){
        SalaryCondition condition = new SalaryCondition();
        condition.setId(2l);
        Salary salary = salaryService.getSalaryByCondition(condition);
        System.out.println(salary);
    }

}
