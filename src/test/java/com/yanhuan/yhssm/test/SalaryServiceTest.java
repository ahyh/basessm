package com.yanhuan.yhssm.test;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.domain.condition.SalaryCondition;
import com.yanhuan.yhssm.service.SalaryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import utils.test.GenerateUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public class SalaryServiceTest extends BaseTest {

    private static Logger logger = LogManager.getLogger(SalaryServiceTest.class);

    @Resource
    protected SalaryService salaryService;

    @Test
    public void testInsertBatch() {
        long start = System.currentTimeMillis();
        List<Salary> salaryList = new ArrayList<>(100);
        Salary salary;
        Date date = new Date();
        for (int k = 0; k < 100; k++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    salary = new Salary();
                    salary.setName(GenerateUtils.getNameRandom());
                    salary.setAge(k + i + j);
                    salary.setSex((byte) i);
                    salary.setCompany(k + "jd.com" + i);
                    salary.setSalary(new BigDecimal(i * 100 + j * 10 + i * j));
                    salary.setCreateTime(date);
                    salary.setUpdateTime(date);
                    salary.setCreateUser("yanhuan");
                    salary.setUpdateUser("yanhuan");
                    salary.setIsDelete((byte) 0);
                    salaryList.add(salary);
                }
            }
            salaryService.batchInsert(salaryList);
        }
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
    }


    /**
     * 测试插入方法，插入后的主键值可以通过salary.getId()方法获取
     */
    @Test
    public void testInsert() {
        Salary salary = new Salary();
        salary.setName("$$$${name}$$$");
        salary.setAge(31);
        salary.setSex((byte) 1);
        salary.setCompany("jd.com");
        salary.setSalary(new BigDecimal(22222));
        salary.setCreateTime(new Date());
        salary.setUpdateTime(new Date());
        salary.setCreateUser("yanhuan");
        salary.setUpdateUser("yanhuan");
        Integer insert = salaryService.insert(salary);
        System.out.println(insert);
    }

    @Test
    public void testGet() {
        List<Salary> byDateSub = salaryService.findByDateSub(20);
        System.out.println();
    }

    @Test
    public void testPage() {
        SalaryCondition condition = new SalaryCondition();
        condition.setPageNum(1);
        condition.setPageSize(3);
        condition.setOrderBy("name desc");
        PageInfo<Salary> salaryPageInfo = salaryService.selectSalaryPage(condition);
        List<Salary> list = salaryPageInfo.getList();
        System.out.println();
    }

    @Test
    public void testFindList() {
        logger.error("SalaryServiceTest findlist");
        SalaryCondition salaryCondition = new SalaryCondition();
        List<Salary> salaryList = salaryService.findSalaryList(salaryCondition);
        Assert.assertTrue(salaryList.size() > 0);
    }

    @Test
    public void testSelectByCondition() {
        SalaryCondition condition = new SalaryCondition();
        condition.setName("${name}$");
        Salary salary = salaryService.getSalaryByCondition(condition);
        Assert.assertTrue(salary != null);
    }

    @Test
    public void testUpdate() {
        Salary salary = new Salary();
        salary.setName("${name}$");
        salaryService.update(salary);
    }

    @Test
    public void testDeletePhysics() {
        Long id = 1l;
        Integer integer = salaryService.deletePhysics(id);
        Assert.assertTrue(integer == 1);
    }

    @Test
    public void testBatchInsert() {
        Salary s1;
        List<Salary> salaryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            s1 = new Salary();
            s1.setName("小张" + i);
            s1.setAge(1);
            s1.setSex((byte) 1);
            s1.setCompany("tx.com");
            s1.setSalary(new BigDecimal(Math.random() * 2000));
            s1.setCreateTime(new Date());
            s1.setUpdateTime(new Date());
            s1.setCreateUser("yanhuan");
            s1.setUpdateUser("yanhuan");
            salaryList.add(s1);
        }
        Integer integer = salaryService.batchInsert(salaryList);
        Assert.assertTrue(integer == 10);
    }

    @Test
    public void testBatchDelete() {
        List<Long> idList = Lists.newArrayList(8l, 9l);
        Integer integer = salaryService.batchDelete(idList);
        Assert.assertTrue(integer == 2);
    }

    @Test
    public void testbatchSaveOrUpdate() {
        Salary salary;
        List<Salary> salaryList = new ArrayList<>();
        for (int i = 0; i < 10; i += 2) {
            salary = new Salary();
            salary.setName("小张" + i);
            salary.setAge(1);
            salary.setSex((byte) 1);
            salary.setCompany("jd.com");
            salary.setCreateTime(new Date());
            salary.setUpdateTime(new Date());
            salary.setCreateUser("yanhuan");
            salary.setUpdateUser("yanhuan");
            salaryList.add(salary);
        }
        Integer integer = salaryService.batchInsertOrUpdate(salaryList);
        Assert.assertTrue(integer == 5);
    }

    @Test
    public void testFindSalaryListBySalaryList() {
        Salary s1 = new Salary();
        s1.setId(12l);
        s1.setCompany("jd");
        Salary s2 = new Salary();
        s2.setId(13l);
        s2.setCompany("0.jd");
        Salary s3 = new Salary();
        s3.setId(14l);
        s3.setCompany("jd");
        List<Salary> salaryList = salaryService.findSalaryListBySalaryList(Lists.newArrayList(s1, s2, s3));
        salaryList.stream().forEach(System.out::println);
    }

}
