/**
 * 邮件发送记录
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-03 12:16:04
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
    customState: function (rowdata, renderData, index, value) {
        if (value == "启用") {
            return '<span style="color:green">发送成功</span>';
        }
        if (value == "禁用") {
            return '<span style="color:red">发送失败</span>';
        }
        return '<span style="color:orange">待发送</span>';
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      详情按钮渲染
     */
    info: function (rowdata, renderData) {
        var btn = ' <button  onclick="detailOne(\'' + "/eduemailsendhistory/info" + '\',\'' + rowdata.id + '\')" class="layui-btn layui-btn-mini">详情</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      修改按钮渲染
     */
    edit: function (rowdata, renderData) {
        var btn = ' <button  onclick="editOne(\'' + "/eduemailsendhistory/edit" + '\',\'' + rowdata.id + '\')" class="layui-btn layui-btn-mini">修改</button>';
        return btn;
    },
    img: function (rowdata, renderData, index, value) {
        return '<img src="' + value + '"/>';
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      删除按钮渲染
     */
    delete: function (rowdata, renderData) {
        var btn = ' <button  onclick="deleteOne(\'' + "删除" + '\',\'' + "/eduemailsendhistory/delete" + '\',\'' + rowdata.id + '\')" class="layui-btn layui-btn-mini layui-btn-delete">删除</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      启用禁用按钮渲染
     */
    state: function (rowdata, renderData) {
        // 表明已禁用 按钮需要变为启用
        if (rowdata.status == '0') {
            return ' <button onclick="updateStateOne(\'' + "重发" + '\',\'' + "/eduemailsendhistory/enable" + '\',\'' + rowdata.id + '\')"' +
                '  class="layui-btn layui-btn-mini layui-btn-green">重发</button>';
        }

        if (rowdata.status == '2') {
            return ' <button onclick="updateStateOne(\'' + "立即发送" + '\',\'' + "/eduemailsendhistory/enable" + '\',\'' + rowdata.id + '\')"' +
                '  class="layui-btn layui-btn-mini layui-btn-green">立即发送</button>';
        }

        return "";
    }
};
