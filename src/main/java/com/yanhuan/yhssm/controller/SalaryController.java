package com.yanhuan.yhssm.controller;

import com.alibaba.fastjson.JSON;
import com.yanhuan.yhssm.annotations.MethodAnnotation;
import com.yanhuan.yhssm.annotations.PropAnnotation;
import com.yanhuan.yhssm.common.consts.ExcelCellMapping;
import com.yanhuan.yhssm.domain.condition.SalaryCondition;
import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.service.SalaryService;
import com.yanhuan.yhssm.utils.ExcelExportUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @MethodAnnotation
    public String gotoSalary(Model model, @PropAnnotation SalaryCondition condition) {
        logger.error(JSON.toJSON(condition));
        Salary salary = salaryService.getSalaryByCondition(condition);
        if (null != salary) {
            model.addAttribute("salary", salary);
        }
        return "salary/salary";
    }

    /**
     * 导出Excel文件
     *
     * @param response
     * @param condition
     */
    @RequestMapping(value = "exportExcel.do")
    public void exportExcel(HttpServletResponse response, SalaryCondition condition) {
        try {
            List<Salary> salaryList = salaryService.findSalaryList(condition);
            ExcelExportUtil.exportFile(response, ExcelCellMapping.Salary.FILENAME, ExcelCellMapping.Salary.TITLES, ExcelCellMapping.Salary.PROPERTIES, salaryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出Excel文件
     *
     * @param response
     * @param condition
     */
    @RequestMapping(value = "exportExcelThread.do")
    public void exportExcelThread(HttpServletResponse response, SalaryCondition condition) {
        try {
            List<Salary> salaryList = salaryService.findSalaryList(condition);
            ExcelExportUtil.exportFile(response, ExcelCellMapping.Salary.FILENAME, ExcelCellMapping.Salary.TITLES, ExcelCellMapping.Salary.PROPERTIES, salaryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
