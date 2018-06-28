package com.yanhuan.yhssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.annotations.ClassInvokeCount;
import com.yanhuan.yhssm.annotations.MethodInvokeCount;
import com.yanhuan.yhssm.dao.SalaryDao;
import com.yanhuan.yhssm.domain.condition.SalaryCondition;
import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.service.SalaryService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SalaryService服务：基本的增删改查方法
 * Created by yanhuan1 on 2018/1/16.
 */
@Service
@ClassInvokeCount
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

    @MethodInvokeCount
    @Override
    public Salary getSalaryByCondition(SalaryCondition condition) {
        Preconditions.checkArgument(condition != null, "condition cannot null!");
        return salaryDao.getSalaryByCondition(condition);
    }

    @Override
    public List<Salary> findSalaryList(SalaryCondition condition) {
        return salaryDao.findSalaryList(condition);
    }

    @Override
    public PageInfo<Salary> selectSalaryPage(SalaryCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize(), condition.getOrderBy());
        List<Salary> salaries = salaryDao.findSalaryPage(condition);
        PageInfo<Salary> pageInfo = new PageInfo<>(salaries);
        return pageInfo;
    }

    @Override
    public Integer batchInsert(List<Salary> salaryList) {
        if(CollectionUtils.isNotEmpty(salaryList)){
            return salaryDao.batchInsert(salaryList);
        }
        return 0;
    }

    @Override
    public Integer batchDelete(List<Long> idList) {
        if(CollectionUtils.isNotEmpty(idList)){
            return salaryDao.batchDelete(idList);
        }
        return 0;
    }

    @Override
    public Integer batchInsertOrUpdate(List<Salary> salaryList) {
        if(CollectionUtils.isNotEmpty(salaryList)){
            return salaryDao.batchInsertOrUpdate(salaryList);
        }
        return 0;
    }

    @Override
    public Integer deletePhysics(Long id) {
        return salaryDao.deletePhysics(id);
    }

    @Override
    public List<Salary> findByDateSub(Integer days) {
        return salaryDao.findByDateSub(days);
    }

    @Override
    public List<Salary> findSalaryListBySalaryList(List<Salary> salaryList) {
        return salaryDao.findSalaryListBySalaryList(salaryList);
    }


}
