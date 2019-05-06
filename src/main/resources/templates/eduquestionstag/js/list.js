/**
 * 问答标签
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 13:48:05
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
    customState: function (rowdata,renderData, index, value) {
        if(value == "启用"){
            return '<span style="color:green">'+value+'</span>';
        }
        if(value == "禁用"){
            return '<span style="color:red">'+value+'</span>';
        }
        return value;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      详情按钮渲染
     */
    info:function(rowdata,renderData){
        var btn=' <button  onclick="detailOne(\''+"/eduquestionstag/info"+'\',\''+rowdata.questionsTagId+'\')" class="layui-btn layui-btn-mini">详情</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      修改按钮渲染
     */
    edit:function(rowdata,renderData){
        var btn=' <button  onclick="editOne(\''+"/eduquestionstag/edit"+'\',\''+rowdata.questionsTagId+'\')" class="layui-btn layui-btn-mini">修改</button>';
        return btn;
    },
    img: function (rowdata,renderData, index, value) {
        return '<img src="'+value+'"/>';
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      删除按钮渲染
     */
    delete:function(rowdata,renderData){
        var btn=' <button  onclick="deleteOne(\''+"删除"+'\',\''+"/eduquestionstag/delete"+'\',\''+rowdata.questionsTagId+'\')" class="layui-btn layui-btn-mini layui-btn-delete">删除</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      启用禁用按钮渲染
     */
    state:function(rowdata,renderData){
        // 表明已禁用 按钮需要变为启用
        if(rowdata.status=='0'){
            return' <button onclick="updateStateOne(\''+"启用"+'\',\''+"/eduquestionstag/enable"+'\',\''+rowdata.questionsTagId+'\')"' +
                '  class="layui-btn layui-btn-mini layui-btn-green">启用</button>';
        }

        // 表明已启用 按钮需要变为禁用
        if(rowdata.status=='1'){
            return' <button  onclick="updateStateOne(\''+"禁用"+'\',\''+"/eduquestionstag/disable"+'\',\''+rowdata.questionsTagId+'\')" ' +
                'class="layui-btn layui-btn-mini layui-btn-danger">禁用</button>';
        }
        return "";
    }
};
