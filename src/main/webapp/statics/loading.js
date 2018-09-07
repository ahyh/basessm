/**正在加载或执行的loading**/
loading = {
    showLoading: function (btnId) {
        // 进入载入状态
        jQuery("#" + btnId).button('loading');
    },
    hideLoading: function (btnId) {
        //恢复按钮状态
        jQuery("#" + btnId).button('reset');
    }
}