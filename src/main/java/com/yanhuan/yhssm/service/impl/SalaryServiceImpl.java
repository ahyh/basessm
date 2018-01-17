package com.yanhuan.yhssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.SalaryDao;
import com.yanhuan.yhssm.domain.Salary;
import com.yanhuan.yhssm.domain.SalaryCondition;
import com.yanhuan.yhssm.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
@Service
public class SalaryServiceImpl implements SalaryService {

    @Resource
    private SalaryDao salaryDao;

    @Override
    public Integer insert(Salary salary) {
        Preconditions.checkNotNull(salary);
        return salaryDao.insert(salary);
    }

    @Override
    public Integer update(Salary salary) {
        Preconditions.checkNotNull(salary);
        return salaryDao.update(salary);
    }

    @Override
    public Integer delete(Long id) {
        return salaryDao.delete(id);
    }

    @Override
    public List<Salary> findSalaryList(SalaryCondition condition) {
        return salaryDao.findSalaryList(condition);
    }

    @Override
    public PageInfo<Salary> selectSalaryPage(Page page, SalaryCondition salaryCondition) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Salary> salaries = salaryDao.findSalaryPage(salaryCondition);
        PageInfo<Salary> pageInfo = new PageInfo<>(salaries);
        return pageInfo;
    }



}
