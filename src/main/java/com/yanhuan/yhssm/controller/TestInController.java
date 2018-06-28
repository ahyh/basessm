package com.yanhuan.yhssm.controller;

import com.yanhuan.yhssm.domain.condition.TestInCondition;
import com.yanhuan.yhssm.service.TestInService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * testIn控制器
 */
@Controller
public class TestInController {

    @Resource
    private TestInService testInService;

    @RequestMapping("testIn/gotoTestIn")
    public String gotoTestIn(Model model) {
        TestInCondition testInCondition = new TestInCondition();
        testInCondition.setAge(22);
        Boolean aBoolean = testInService.updateAndInsertBatch(testInCondition);
        model.addAttribute("flag", aBoolean);
        return "testIn/testIn";
    }


}
