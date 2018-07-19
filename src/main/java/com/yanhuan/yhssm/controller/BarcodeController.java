package com.yanhuan.yhssm.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.domain.pojo.Barcode;
import com.yanhuan.yhssm.service.UserService;
import com.yanhuan.yhssm.utils.BarcodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * 条形码控制器
 *
 * @author yanhuan1
 */
@Controller
@RequestMapping("barcode")
public class BarcodeController {

    @Resource
    private UserService userService;

    @RequestMapping("toBarcode")
    public String toBarcode(Model model) {
        return "barcode/barcode";
    }

    @ResponseBody
    @RequestMapping(value = "gen", method = {RequestMethod.GET, RequestMethod.POST})
    public Object gen(Barcode barcode, Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            Preconditions.checkNotNull(barcode);
            Preconditions.checkArgument(StringUtils.isNotBlank(barcode.getContent()), "生成内容不能为空!");
            Preconditions.checkArgument(barcode.getQty() != null && barcode.getQty() != 0, "生成数量不能为空!");
            BufferedImage image = BarcodeUtil.buildBufferedImage(barcode.getContent());
            BufferedImage image1 = BarcodeUtil.mergeImageVertical(image, barcode.getQty());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(image1, "JPEG", out);
            return JSON.toJSONString(out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
