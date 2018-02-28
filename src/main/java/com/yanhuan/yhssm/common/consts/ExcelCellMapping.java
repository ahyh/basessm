package com.yanhuan.yhssm.common.consts;

/**
 * 导出Excel时的列名和属性名的映射
 * Created by yanhuan1 on 2018/1/27.
 */
public interface ExcelCellMapping {

    interface Salary {
        String FILENAME = "薪水表";
        String[] PROPERTIES = {"name", "age", "sex", "company", "salary", "createTime", "createUser", "updateTime", "updateUser"};
        String[] TITLES = {"姓名", "年龄", "性别", "公司", "薪水", "创建日期", "创建人", "更新日期", "更新人"};
    }

}
