package com.yanhuan.yhssm.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yanhuan.yhssm.domain.Salary;
import com.yanhuan.yhssm.domain.SalaryCondition;
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

    @Test
    public void testInsert(){
        Salary salary = new Salary();
        salary.setName("hhh");
        salary.setAge(19);
        salary.setSex((byte)2);
        salary.setCompany("JD.com");
        salary.setSalary(new BigDecimal(22222));
        salary.setCreateTime(new Date());
        salary.setUpdateTime(new Date());
        salary.setCreateUser("yanhuan");
        salary.setUpdateUser("yanhuan");
        salaryService.insert(salary);
    }

    @Test
    public void testPage(){
        Page page = new Page(1,3);
        SalaryCondition salaryCondition = new SalaryCondition();
        PageInfo<Salary> salaryPageInfo = salaryService.selectSalaryPage(page, salaryCondition);
        List<Salary> list = salaryPageInfo.getList();
        System.out.println();
    }

    @Test
    public void testFindList(){
        SalaryCondition salaryCondition = new SalaryCondition();
        List<Salary> salaryList = salaryService.findSalaryList(salaryCondition);
        System.out.println();
    }
}
