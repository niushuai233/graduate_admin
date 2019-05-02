/**
 * 导航表
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-02 17:16:49
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
            return '<span style="color:green">' + value + '</span>';
        }
        if (value == "禁用") {
            return '<span style="color:red">' + value + '</span>';
        }
        return value;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      详情按钮渲染
     */
    info: function (rowdata, renderData) {
        var btn = ' <button  onclick="detailOne(\'' + "/eduwebsitenavigate/info" + '\',\'' + rowdata.id + '\')" class="layui-btn layui-btn-mini">详情</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      修改按钮渲染
     */
    edit: function (rowdata, renderData) {
        var btn = ' <button  onclick="editOne(\'' + "/eduwebsitenavigate/edit" + '\',\'' + rowdata.id + '\')" class="layui-btn layui-btn-mini">修改</button>';
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
        var btn = ' <button  onclick="deleteOne(\'' + "删除" + '\',\'' + "/eduwebsitenavigate/delete" + '\',\'' + rowdata.id + '\')" class="layui-btn layui-btn-mini layui-btn-delete">删除</button>';
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
            return ' <button onclick="updateStateOne(\'' + "启用" + '\',\'' + "/eduwebsitenavigate/enable" + '\',\'' + rowdata.id + '\')"' +
                '  class="layui-btn layui-btn-mini layui-btn-green">启用</button>';
        }

        // 表明已启用 按钮需要变为禁用
        if (rowdata.status == '1') {
            return ' <button  onclick="updateStateOne(\'' + "禁用" + '\',\'' + "/eduwebsitenavigate/disable" + '\',\'' + rowdata.id + '\')" ' +
                'class="layui-btn layui-btn-mini layui-btn-danger">禁用</button>';
        }
        return "";
    },
    /**
     * 是否需要在新页面展示
     * @param rowdata
     * @param renderData
     * @param index
     * @param value
     * @returns {string}
     */
    customerNewPage: function (rowdata, renderData, index, value) {
        // 是
        if (value == "0") {
            return '是';
        }
        // 否
        if (value == "1") {
            return '否';
        }

    },
    /**
     * 类型
     * @param rowdata
     * @param renderData
     * @param index
     * @param value
     * @returns {string}
     */
    customerType: function (rowdata, renderData, index, value) {
        if (value == "INDEX") {
            return '首页';
        }
        if (value == "USER") {
            return '个人中心';
        }
        if (value == "TAB") {
            return '尾部标签';
        }
        if (value == "FRIENDLINK") {
            return '尾部友链';
        }

    }
};
