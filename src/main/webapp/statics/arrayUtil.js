/**
 * Created by hanjinkui on 2016/6/23.
 */
(function ($) {
    $.extend({
        hasRepeat: function (arr) {
            if (arr && arr.length > 0) {
                return /(\x0f[^\x0f]+)\x0f[\s\S]*\1/.test("\x0f" + arr.join("\x0f\x0f") + "\x0f");
            } else alert("数组为空");

        }
    })

})(jQuery);
