function hideSendTime() {
    var $input = $("input[name='sendTime']");
    $input.val("");
    $input.parent().parent().hide();
}

function showSendTime() {
    $("input[name='sendTime']").parent().parent().show();
}

function getCurrDate(){

    var date = new Date();
    //alert(dateFtt("yyyy-MM-dd HH:mm:ss", date));
    return dateFtt("yyyy-MM-dd HH:mm:ss", date);
}

function dateFtt(fmt,date) {
    var o = {
        "M+" : date.getMonth()+1,                 //月份
        "d+" : date.getDate(),                    //日
        "H+" : date.getHours(),                   //小时
        "m+" : date.getMinutes(),                 //分
        "s+" : date.getSeconds(),                 //秒
        "q+" : Math.floor((date.getMonth()+3)/3), //季度
        "S"  : date.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

$(function () {
    var typeValue = $("input[name='type']").val();
    if (typeValue == 2) {
        showSendTime();
    } else {
        hideSendTime();
    }

    var ed = initEditor('/upload/eImageUpload', "", "95%", "65%");
    console.log(ed);
})

layui.use(['form'], function () {
    var form = layui.form();

    //下拉框监听事件
    form.on('select(mailSendTypeFilter)', function (data) {
        if (data.value == '2') {
            showSendTime()
        } else {
            hideSendTime()
        }

        return false;
    });

});

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

