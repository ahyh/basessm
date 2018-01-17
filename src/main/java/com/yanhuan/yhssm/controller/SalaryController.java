package com.yanhuan.yhssm.controller;

import com.yanhuan.yhssm.domain.Salary;
import com.yanhuan.yhssm.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
@Controller
@RequestMapping("/salary")
public class SalaryController {

    @Resource
    private SalaryService salaryService;

    @RequestMapping("/insert.do")
    public void insertSalary(Salary salary){
        salaryService.insert(salary);
    }

}
