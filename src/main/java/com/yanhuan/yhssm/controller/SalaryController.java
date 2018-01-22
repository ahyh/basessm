package com.yanhuan.yhssm.controller;

import com.alibaba.fastjson.JSON;
import com.yanhuan.yhssm.domain.condition.SalaryCondition;
import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.service.SalaryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Salary控制器
 * Created by yanhuan1 on 2018/1/16.
 */
@Controller
@RequestMapping("salary")
public class SalaryController {

    private static Logger logger = LogManager.getLogger(SalaryController.class);

    @Resource
    private SalaryService salaryService;

    @RequestMapping(value = "gotoSalary")
    public String gotoSalary(Model model,SalaryCondition condition) {
        logger.error(JSON.toJSON(condition));
        Salary salary = salaryService.getSalaryByCondition(condition);
        if (null != salary) {
            model.addAttribute("salary", salary);
        }
        return "salary/salary";
    }

}
