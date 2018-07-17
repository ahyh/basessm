<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div>

    <h4 style="color: red">下拉框</h4>
    <select id="select" name="select">
        <option value="0">请选择</option>
        <option value="1">一年级</option>
        <option value="2">二年级</option>
        <option value="3">三年级</option>
    </select>
    <h1>${salary.name}</h1>

    <a id="a" href="salary/gotoSalary?id=11">去Salary</a>
    <br>
    <a id="b" href="salary/exportExcel.do">导出Excel文件</a>
    <br>
    <a id="c" href="salary/exportExcelThread.do">导出Excel文件</a>
    <br>
    <a id="d" href="testIn/gotoTestIn">测试批量更新插入是否死锁问题</a>

</div>