package com.yanhuan.yhssm.controller;

import com.alibaba.fastjson.JSON;
import com.yanhuan.yhssm.annotations.MethodAnnotation;
import com.yanhuan.yhssm.annotations.PropAnnotation;
import com.yanhuan.yhssm.common.consts.ExcelCellMapping;
import com.yanhuan.yhssm.domain.condition.OrderMainCondition;
import com.yanhuan.yhssm.domain.condition.SalaryCondition;
import com.yanhuan.yhssm.domain.pojo.OrderMain;
import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.service.OrderMainService;
import com.yanhuan.yhssm.service.SalaryService;
import com.yanhuan.yhssm.utils.ExcelExportUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    @Resource
    private OrderMainService orderMainService;

    @RequestMapping(value = "gotoSalary")
    @MethodAnnotation
    public String gotoSalary(Model model, @PropAnnotation SalaryCondition condition) {
        logger.error(JSON.toJSON(condition));
        Salary salary = salaryService.getSalaryByCondition(condition);
        if (null != salary) {
            model.addAttribute("salary", salary);
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<OrderMain> orderMainCallable = () -> {
            System.out.println("Enter callable");
            List<OrderMain> orderMainList = orderMainService.findOrderMainList(new OrderMainCondition());
            for (OrderMain orderMain : orderMainList) {
                orderMain.setPayStatus((byte) 2);
                Thread.sleep(10000);
                orderMainService.update(orderMain);
            }
            System.out.println("Execute callable");
            return orderMainList.get(orderMainList.size() - 1);
        };
        Future<OrderMain> submit = executorService.submit(orderMainCallable);
        System.out.println("after submit");
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

    @ResponseBody
    @RequestMapping(value = "get/{id}")
    public Salary getSalaryById(@PathVariable Long id, HttpServletRequest request) {
        String routeRule = request.getHeader("routeRule");
        if (!"6,6,80".equals(routeRule)) {
            return null;
        }
        String source = request.getHeader("source");
        if (!"yanhuan".equals(source)) {
            return null;
        }
        SalaryCondition condition = new SalaryCondition();
        condition.setId(id);
        Salary salary = salaryService.getSalaryByCondition(condition);
        return salary;
    }

}
