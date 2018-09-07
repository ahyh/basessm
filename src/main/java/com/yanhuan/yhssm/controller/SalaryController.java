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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * Salary控制器
 * Created by yanhuan1 on 2018/1/16.
 *
 * @author yanhuan1
 */
@Controller
@RequestMapping("salary")
public class SalaryController {

    private static Logger logger = LoggerFactory.getLogger(SalaryController.class);

    @Resource
    private SalaryService salaryService;

    @Resource
    private OrderMainService orderMainService;

    @RequestMapping(value = "gotoSalary")
    @MethodAnnotation
    public String gotoSalary(Model model, @PropAnnotation SalaryCondition condition) {
        logger.error("SalaryController gotoSalary condition:{}", JSON.toJSON(condition));
        Salary salary = salaryService.getSalaryByCondition(condition);
        if (null != salary) {
            model.addAttribute("salary", salary);
        }
        ExecutorService executorService = newCachedThreadPool();
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
//        if (!"6,6,80".equals(routeRule)) {
//            return null;
//        }
//        String source = request.getHeader("source");
//        if (!"1".equals(source)) {
//            return null;
//        }
//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
//            String line = null;
//            StringBuilder sb = new StringBuilder();
//            while((line = br.readLine())!=null){
//                sb.append(line);
//            }
//            // 将资料解码
//            String reqBody = sb.toString();
//            String decode = URLDecoder.decode(reqBody, "GBK");
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        SalaryCondition condition = new SalaryCondition();
        condition.setId(id);
        Salary salary = salaryService.getSalaryByCondition(condition);
        logger.info("SalaryController getSalaryById salary:{}", JSON.toJSON(salary));
        Salary salary1 = salaryService.getSalaryByCondition(condition);
        logger.debug("SalaryController getSalaryById salary:{}", JSON.toJSON(salary1));
        System.out.println(salary1);
        return salary;
    }

    @ResponseBody
    @RequestMapping(value = "update/{id}/{name}/{salary}")
    public Salary updateSalaryById(@PathVariable("id") Long id, @PathVariable("name") String name,
                                   @PathVariable("salary") BigDecimal salary) {
        SalaryCondition updateSalary = new SalaryCondition();
        updateSalary.setId(id);
        updateSalary.setName(name);
        updateSalary.setSalary(salary);
        Integer update = salaryService.updateSalaryByCondition(updateSalary);
        Salary salaryGet = salaryService.getSalaryByCondition(updateSalary);
        System.out.println(salary);
        return salaryGet;
    }

    @ResponseBody
    @RequestMapping(value = "uploadExcel", method = {RequestMethod.POST})
    public Object uploadExcel(MultipartHttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap<>(1);
        try {
            //获取上传文件列表
            List<MultipartFile> uploadFileList = request.getFiles("templateFile");
            //检验上传文件
            if (uploadFileList.size() == 0) {
                map.put("erroMsg", "上传文件不能为空!");
                return map;
            }
            //获取到上传的文件
            MultipartFile multipartFile = uploadFileList.get(0);
            //获取文件名
            String fileName = multipartFile.getOriginalFilename();

            if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
                Workbook workbook = null;
                if (multipartFile.getOriginalFilename().endsWith("xls")) {
                    workbook = new HSSFWorkbook(multipartFile.getInputStream());
                } else {//xlsx文件
                    workbook = new XSSFWorkbook(multipartFile.getInputStream());
                }
                Sheet sheet = workbook.getSheetAt(0);
                //获得总行数 = 最后一行的index+1 ，因为从0开始
                int totalRow = sheet.getLastRowNum();
                for (int rowNum = 1; rowNum <= totalRow; rowNum++) {
                    Row row = sheet.getRow(rowNum);
                    System.out.println(row.getCell(0));
                }
            }


        } catch (Exception e) {
            logger.error("SalaryController uploadExcel error:{}", e);
        }


        return map;
    }


}
