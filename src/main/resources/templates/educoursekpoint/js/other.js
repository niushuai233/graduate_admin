var cyProps = $("#name").attr("cyProps");
// url:'/educourse/findAllCourseSelectTool',multiple:'false', filter:'courseIdTool'

layui.use(['form'], function () {
    var form = layui.form();
    //监听下拉
    form.on('select(courseIdTool)', function (data) {
        //console.log(data.elem); //得到checkbox原始DOM对象
        console.log(data.value); //复选框value值，也可以通过data.elem.value得到
        //console.log(data.othis); //得到美化后的DOM对象
        var replaceCyProps = cyProps.replace("000", data.value);
        console.log($("#name").attr("cyProps"));
        $("#name").attr("cyProps", replaceCyProps);
    });
    //监听多选
    form.on('checkbox(searchChecked)', function (data) {
        Msg.info("value: " + data.elem.title + "  checked: " + data.elem.checked);
        return false;
    });
});