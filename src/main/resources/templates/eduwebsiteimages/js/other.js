
/**
 * @ClassName other
 * @Description:
 * @Author niushuai
 * @email niushuai951101@gmail.com
 * @Date 2019/3/20 10:54
 */

$(function () {
   initType();
});

/**
 * 处理数据
 * @param result
 */
function dealOption(result) {
    var tvVal = $("#tv").val();
    console.log('['+$("#tv").val()+']');
    if( result.flag ){
        // 成功 返回的内容
        var arrays = result.val;

        for (var i = 0; i < arrays.length; i++) {
            var tmp = arrays[i];
            if(tmp.typeId != tvVal) {
                $("#typeId").append('<option value="' + tmp.typeId + '">' + tmp.typeName + '</option>');
            }else {
                $("#typeId").append('<option selected value="' + tmp.typeId + '">' + tmp.typeName + '</option>');
            }
        }
    }else {
        // 错误 给予错误提示
        parent.layer.msg(result.val, {icon: 5});
    }

}

/**
 * 初始化图片类型
 */
function initType() {

    commonAjax("/eduwebsiteimagestype/getImageTypeJson", null, null, dealOption,null);
}

// 颜色选择器
$('#paigusu').paigusu({
    color : '#FFFFFF',
},function(event,obj){
    $('#paigusu').val('#' + obj.hex);
});