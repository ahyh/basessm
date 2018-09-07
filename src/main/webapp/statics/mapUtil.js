/**
 * Created by hanjinkui on 2016/6/23.
 */
(function ($) {
    $.extend({
        getMapStr: function (jsonMap) {
            var keyValArray = [];
            if (jsonMap) {
                for (var i in jsonMap) {
                    keyValArray.push(i + ":" + jsonMap[i] + "<br/>")
                }
                if (keyValArray.length > 0) {
                    return keyValArray.join("");
                }
            }
            return "";
        }
    })

})(jQuery);
