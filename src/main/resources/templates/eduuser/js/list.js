/**
 * 学生信息表
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-13 20:58:42
 */

/**数据渲染对象*/
var Render = {
    /**
     * 渲染状态列
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @param index
     * @param value      当前对象值
     */
    mmmState: function (rowdata,renderData, index, value) {
        if(value == "启用"){
            return '<span style="color:green">启用</span>';
        }
        if(value == "禁用"){
            return '<span style="color:red">禁用</span>';
        }
        return value;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      详情按钮渲染
     */
    info:function(rowdata,renderData){
        var btn=' <button  onclick="detailOne(\''+"/eduuser/info"+'\',\''+rowdata.userId+'\')" class="layui-btn layui-btn-mini">详情</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      修改按钮渲染
     */
    edit:function(rowdata,renderData){
        var btn=' <button  onclick="editOne(\''+"/eduuser/edit"+'\',\''+rowdata.userId+'\')" class="layui-btn layui-btn-mini">修改</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      删除按钮渲染
     */
    delete:function(rowdata,renderData){
        var btn=' <button  onclick="deleteOne(\''+"删除"+'\',\''+"/eduuser/delete"+'\',\''+rowdata.userId+'\')" class="layui-btn layui-btn-mini layui-btn-delete">删除</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      启用禁用按钮渲染
     */
    state:function(rowdata,renderData){
        if(rowdata.state=='0'){
            return' <button onclick="updateStateOne(\''+"启用"+'\',\''+"/eduuser/enable"+'\',\''+rowdata.userId+'\')"' +
                '  class="layui-btn layui-btn-mini layui-btn-green">启用</button>';
        }
        if(rowdata.state=='1'){
            return' <button  onclick="updateStateOne(\''+"禁用"+'\',\''+"/eduuser/disable"+'\',\''+rowdata.userId+'\')" ' +
                'class="layui-btn layui-btn-mini layui-btn-danger">禁用</button>';
        }
        return "";
    },
    picImg: function (rowdata,renderData, index, value) {
        return '<img src="'+value+'"/>';
    },
    sex :function(rowdata, renderData, index, value){
        if (value == '1'){
            return '男'
        }else if (value == '2'){
            return '女';
        }else {
            return '';
        }
    }
};


layui.use(['form'], function () {
    var form = layui.form();
    //监听下拉
    form.on('select(sex)', function (data) {
        console.log(data.value); //复选框value值，也可以通过data.elem.value得到
        $("#sexInput").val(data.value);
    });

    form.on('select(isAvalible)', function (data) {
        console.log(data.value); //复选框value值，也可以通过data.elem.value得到
        $("#isAvalibleInput").val(data.value);
    });



});
