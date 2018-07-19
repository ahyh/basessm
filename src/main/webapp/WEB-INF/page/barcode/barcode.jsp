<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>生成条码</title>
    <!--结算页面样式-->
    <script type="text/javascript" src="/statics/jquery-1.7.2.js"></script>
    <script type="text/javascript">
$(function(){
    $("#gensubmit").click(function () {
        alert(1);
        //执行程序   提交表单
        var content = $("#content").val();
        var qty = $("#qty").val();
        $.ajax({
            type: 'post',
            data: {"content": content, "qty": qty},
            dataType: 'json',
            url: "/barcode/gen",
            success: function (data) {
                //将图片的Base64编码设置给src
                $("#ImagePic").attr("style", "visibility: visible");
                $("#ImagePic").attr("src", "data:image/png;base64," + data);
            },
            error: function (data) {
                alert('响应失败！');
            }
        });
    });
})



    </script>
</head>
<body>
<div>

    <h2 style="color: red">生成条形码</h2>
    条码内容：<input id="content" class="content" name="content"/>
    生成数量：<input id="qty" class="qty" name="qty"/>
    <input id="gensubmit" type="submit" value="生成">


</div>
<div>
    <!--HTML标签-->
    <img id="ImagePic" alt="Base64 encoded image" width="200" height="200" style="visibility: hidden"/>
</div>
</body>
