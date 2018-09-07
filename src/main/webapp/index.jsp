<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<script type="text/javascript" src="/statics/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/statics/importFile.js"></script>
<script type="text/javascript" src="/statics/ajaxfileupload.js"></script>
<script type="text/javascript" src="/statics/loading.js"></script>
<script type="text/javascript" src="/statics/bootstrap.min.js"></script>
<script type="text/javascript" src="/statics/arrayUtil.js"></script>
<script type="text/javascript" src="/statics/mapUtil.js"></script>
<script type="text/javascript" src="/statics/jquery.form.js"></script>
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

<button id="excelUploadBtn">上传Excel文件</button>


</body>

<script type="text/javascript">

    $(function () {
        $("#button").click(function () {
            alert(1)
            $("#select option:nth-child(2)").attr("disabled", "true")
        })

        importData();
    })

    //导入数据
    var importData = function () {
        $("#excelUploadBtn").on("click", function () {
            $.importFile({
                url: "salary/uploadExcel",
                fileName: "templateFile", data: {}, successFun: function (result) {
                    if (result.code == 1) {
                        bootbox.alert(result.errorMsg, function () {
                            $.closeDialog();
                        });
                    } else if (result.code == 2) {
                        bootbox.alert("以下数据行出错，请修改后重新导入:</br>" + $.getMapStr(result.data), function () {
                            $.closeDialog();
                        });
                    } else {
                        bootbox.alert(result.errorMsg);
                    }
                }
            });
        });
    };

</script>


</html>
