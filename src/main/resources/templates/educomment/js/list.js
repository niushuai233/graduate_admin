/**
 * 课程评论
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 01:59:37
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
     * 渲染状态列
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @param index
     * @param value      当前对象值
     */
    type: function (rowdata, renderData, index, value) {
        if (value == "1") {
            return '<span style="color:green">文章</span>';
        }
        if (value == "2") {
            return '<span style="color:darkblue">课程</span>';
        }
        return value;
    },
    content: function (rowdata, renderData, index, value) {
        if (!isEmpty(value) && value.length > 30) {
            return value.substring(0, 30) + "...";
        }
        return value;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      详情按钮渲染
     */
    info: function (rowdata, renderData) {
        var btn = ' <button  onclick="detailOne(\'' + "/educomment/info" + '\',\'' + rowdata.commentId+ '\')" class="layui-btn layui-btn-mini">详情</button>';
        return btn;
    },
    pCommentId: function (rowdata, renderData, index, value) {
      return value + " ";
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      修改按钮渲染
     */
    edit: function (rowdata, renderData) {
        var btn = ' <button  onclick="editOne(\'' + "/educomment/edit" + '\',\'' + rowdata.commentId+ '\')" class="layui-btn layui-btn-mini">修改</button>';
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
        var btn = ' <button  onclick="deleteOne(\'' + "删除" + '\',\'' + "/educomment/delete" + '\',\'' + rowdata.commentId+ '\')" class="layui-btn layui-btn-mini layui-btn-delete">删除</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      启用禁用按钮渲染
     */
    state: function (rowdata, renderData) {
        // 表明已禁用 按钮需要变为启用
        if (rowdata.state == '0') {
            return ' <button onclick="updateStateOne(\'' + "启用" + '\',\'' + "/educomment/enable" + '\',\'' + rowdata.commentId+ '\')"' +
                '  class="layui-btn layui-btn-mini layui-btn-green">启用</button>';
        }

        // 表明已启用 按钮需要变为禁用
        if (rowdata.state == '1') {
            return ' <button  onclick="updateStateOne(\'' + "禁用" + '\',\'' + "/educomment/disable" + '\',\'' + rowdata.commentId+ '\')" ' +
                'class="layui-btn layui-btn-mini layui-btn-danger">禁用</button>';
        }
        return "";
    }
};
