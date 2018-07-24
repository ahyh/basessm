<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<body>
<h1 style="color: red">Hello World!</h1>

<a id="gotoLogin" href="login/toLogin">去登录</a>
<br>
<a id="gotoRegister" href="login/toRegister">去注册</a>
<br>
<a id="gotoBarcode" href="barcode/toBarcode">去条码生成页面</a>

<h4 style="color: red">下拉框</h4>
<select id="select" name="select">
    <option value="0">请选择</option>
    <option value="1">一年级</option>
    <option value="2">二年级</option>
    <option value="3">三年级</option>
</select>

<button id="button">点我</button>

<script type="text/javascript" src="/statics/jquery-1.7.2.js"></script>
<script type="text/javascript">

$(function () {
    $("#button").click(function(){
        alert(1)
        $("#select option:nth-child(2)").attr("disabled","true")
    })
})

</script>
</body>
</html>
