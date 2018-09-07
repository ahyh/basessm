(function ($) {
    $.extend({
        importFile: function (options) {
            var that = this;
            var defaultOpt = {fileName: null, data: null, successFun: null, url: null};
            var opts = $.extend(defaultOpt, options);
            this.init = function () {

                var uploadDialogHtml = "\
                <style type='text/css'>\
                 .upload-dialog {\
              width: 600px;\
              margin: 0 auto;\
              border: 1px solid #fff;\
             top: 32%;\
             left: 40%;\
             position: fixed;\
             overflow: auto;\
             width: 600px;\
             z-index:1031;\
             background-color:#fff;\
             }.btns{background: #eff3f8;padding: 13px;text-align: center;}.btns .confirm-btn{padding: 6px 12px;background: #428bca!important;border-color: #428bca;color: #fff;margin-left: 10px;}\
             .del{float: right; margin-top: -41px;  font-size: 26px; opacity: 0.2;  border: 0px none;}\
             .dialog-header{border-bottom: 1px solid #e5e5e5;padding-left: 5px;}.file-input{display: inline-block!important;}\
             .removeBtn{background: #428bca!important;border-color: #428bca;margin-left: 20px;display: inline-block;color: #fff;}\
              button{border: 5px solid #FFF}.multi-file,.first-file{margin: 5px 0;}\
              .file-item,.first-file{padding-left: 5px;margin: 3px 0;}\
              .cancle-btn{padding: 6px 12px;background: #abbac3!important;border-color: #abbac3;color: #fff;}.add-file{background: #428bca!important;border-color: #428bca;color: #fff;}</style>\
                <div  id='upload-dialog' class='upload-dialog'>\
                <div class='dialog-header'><h4>文件上传</h4><button class='del cl' type='button'>X</button></div>\
                 <form enctype='multipart/form-data' class='upload-form'>\
             <div class='upload-file first-file'><input type='file'  class='file-input' name='" + opts.fileName + "' /></div>\
             <div class='multi-file'>\
             </div>\
             </form>\
             <div class='btns'>\
             <button type='button' class='cancle-btn cl' value='取消'>取&nbsp;消</button>\
             <button type='button' class='confirm-btn' value='确定'>确&nbsp;定</button>\
             </div>\
             </div>";
                $("body").append(uploadDialogHtml);
                that.register();
                $(".upload-form")[0].reset();
                $("#upload-dialog").modal({backdrop: 'static'});
            };
            this.register = function () {

                $(".cl").on("click", function () {
                    $("#upload-dialog").modal('hide');
                    $("#upload-dialog").remove();
                });

                $(".confirm-btn").on("click", function () {
                    if (!that.valid()) {
                        return;
                    }
                    $(".upload-form").ajaxSubmit({
                        url: opts.url,
                        type: "post",
                        data: opts.data,
                        cache:false,
                        beforeSend: function () {
                            $(".confirm-btn").attr("disabled", "disabled").text("执行中...");
                        },
                        success: function (result) {
                            if (options.successFun) {
                                options.successFun(result);
                            } else {
                                if (result.code == 1) {
                                    bootbox.alert("上传成功", function () {
                                        $("#upload-dialog").modal('hide');
                                    });
                                } else {
                                    bootbox.alert("上传失败")
                                }
                            }
                        },
                        complete: function () {
                            $(".confirm-btn").attr("disabled", false).text("确定");
                        }
                    });
                })
            };
            this.valid = function () {
                var rs = true;
                var fileNameArray = [];
                $(".upload-dialog input[name='" + options.fileName + "']").each(function () {
                    if (!$(this).val()) {
                        rs = false;
                        return true;
                    } else fileNameArray.push($(this).val());
                });
                if (rs) {
                    //是否重复上传
                    if ($.hasRepeat(fileNameArray)) {
                        bootbox.alert("文件不能重复上传！");
                        rs = false;
                    } else {
                        rs = true;
                    }
                } else {
                    bootbox.alert("请选择上传文件！");
                }
                return rs;
            };

            this.init();
        },
        closeDialog: function () {
            $("#upload-dialog").modal('hide');
            $("#upload-dialog").remove();
        }
    })

})(jQuery);
