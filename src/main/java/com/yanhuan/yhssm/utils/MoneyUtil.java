package com.yanhuan.yhssm.utils;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 将数字转换成人民币大写金额字符串工具
 * eg:1110--> 壹仟壹佰壹拾圆整
 * Created by yanhuan1 on 2018/1/20.
 */
public final class MoneyUtil {

    private static final String[] moneyUnitArr = {"圆", "角", "分"};
    private static final String DOT = ".";
    private static final String ZERO = "零";
    private static final String[] chineseNumArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
    private static final String[] unitArr = {"零", "万", "亿", "万"};
    private static final String[] arr = {"仟", "佰", "拾", ""};

    public static BigDecimal chinese2Number(final String chineseMoney) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(chineseMoney),"MoneyUtil chinese2Number cannot null");
        //先处理角和分
        BigDecimal money = BigDecimal.ZERO;
        if(chineseMoney.contains(moneyUnitArr[2])){

        }

        return money;
    }


    /**
     * 数字转换为人民币大写金额
     * @param money
     * @return
     */
    public static String number2Chinese(BigDecimal money) {
        Preconditions.checkNotNull(money);
        money = money.setScale(2, BigDecimal.ROUND_HALF_UP);
        if (money.compareTo(BigDecimal.ZERO) == 0) {
            return ZERO + moneyUnitArr[0] + "整";
        }
        String s = removeZeroBegin(money.toString());
        s = removeZeroEnd(s);
        if (s.contains(DOT)) {
            String[] split = s.split("\\.");
            if (split.length == 2) {
                String left = split[0];
                if (left.length() > 16) {
                    throw new RuntimeException("整数部分超过长度限制");
                }
                while(left.length() % 4 != 0){
                    left = "0"+left;
                }
                String right = split[1];
                s = left2Chinese(left) + moneyUnitArr[0] + right2Chinese(right);
            } else {
                String left = split[0];
                s = left2Chinese(left) + moneyUnitArr[0] + "整";
            }
        } else {
            s = left2Chinese(s) + moneyUnitArr[0] + "整";
        }
        return s;
    }

    private static String left2Chinese(String str) {
        String ch = "";
        List<String> ints = str2intArray(str, true);
        for (int i = 0, len = ints.size(); i < len; i++) {
            String s = minLeft2Chinese(String.valueOf(ints.get(i)));
            if (s.equals(ZERO) && !ch.startsWith(ZERO)) {
                ch = ZERO + ch;
            } else if (!s.equals(ZERO)) {
                ch = s + unitArr[i] + ch;
            }
        }
        while (ch.startsWith(ZERO)) {
            ch = ch.substring(1);
        }
        while (ch.endsWith(ZERO)) {
            ch = ch.substring(0, ch.length() - 1);
        }
        return ch;
    }

    private static String minLeft2Chinese(String str) {
        String ch = "";
        for (int i = 0; i < 4; i++) {
            if (!String.valueOf(str.charAt(i)).equals("0")) {
                ch += chineseNumArr[Integer.parseInt(String.valueOf(str.charAt(i)))] + arr[i];
            } else {
                if (!ch.endsWith(ZERO)) {
                    ch += ZERO;
                }
            }
        }
        while(ch.endsWith(ZERO)){
            ch = ch.substring(0,ch.length() - 1);
        }
        return ch;
    }

    private static String right2Chinese(String str) {
        String ch = "";
        List<String> ints = str2intArray(str, false);
        for (int i = 0, len = ints.size(); i < len; i++) {
            if (!chineseNumArr[Integer.parseInt(ints.get(i))].endsWith(ZERO)) {
                ch = ch + chineseNumArr[Integer.parseInt(ints.get(i))] + moneyUnitArr[i + 1];
            } else {
                if (!ch.startsWith(ZERO)) {
                    ch = chineseNumArr[Integer.parseInt(ints.get(i))] + ch;
                }
            }
        }
        return ch;
    }

    //去掉数字开头的0
    private static String removeZeroBegin(String str) {
        while ("0".equals(str)) {
            str = str.substring(1);
        }
        if (null == str || "".equals(str)) {
            return "0";
        }
        return str;
    }

    //如果有小数点，去掉尾部的0
    private static String removeZeroEnd(String str) {
        if (str.contains(DOT)) {
            while (str.endsWith("0")) {
                str = str.substring(0, str.length() - 1);
            }
            if (null == str || "".equals(str)) {
                return "0";
            }
            return str;
        } else {
            return str;
        }
    }

    private static List<String> str2intArray(String str, boolean isLeft) {
        List<String> list = new ArrayList<>();
        int k = 0;
        int len = str.length();
        if (isLeft) {
            while (k < len) {
                if ((len - k - 4) > 0) {
                    list.add(str.substring(len - k - 4, len - k));
                } else {
                    int strLen = str.substring(0, len - k).length();
                    String tempStr = str.substring(0, len - k);
                    if (strLen < 4) {
                        for (int i = 0; i < 4 - strLen; i++) {
                            tempStr = "0" + tempStr;
                        }
                    }
                    list.add(tempStr);
                }
                k += 4;
            }
        } else {
            for (int i = 0, j = len; i < j; i++) {
                list.add(String.valueOf(str.charAt(i)));
            }
        }
        return list;
    }

}
