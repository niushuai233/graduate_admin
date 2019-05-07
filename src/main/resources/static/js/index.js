$(document).ready(function () {
    //默认显示菜单
    createMenu("sys/menu/user?_" + $.now());

});

//生成菜单
function createMenu(url) {
    $(".sidebar-menu").html("");
    $.getJSON(url, function (r) {
        for (var i = 0; i < r.menuList.length; i++) {
            var _li;
            if (r.menuList[i].type === 0) {
                _li = ['<li ><a href="javascript:;" title="' + r.menuList[i].name + '">',
                    '<i class="' + r.menuList[i].icon + '"></i>',
                    '<span>' + r.menuList[i].name + '</span>',
                    '<i class="fa fa-angle-left pull-right"></i>' +
                    '</a></li>'].join("");
                //是否有下级菜单
                if (r.menuList[i].list) {
                    var $li = $(_li);
                    $li.find("a").after('<ul class="treeview-menu"></ul>');
                    var childNodes = addMenu(r.menuList[i].list);
                    if (childNodes != "") {
                        $li.find(".treeview-menu").append(childNodes);
                        _li = $li.prop("outerHTML");
                    }
                }
            }
            if (r.menuList[i].type === 1) {
                _li = '$(<li><a class="cy-page" href="javascript:;" data-url="' + r.menuList[i].url + '" title="' + r.menuList[i].name + '"><i class="' + r.menuList[i].icon + '"></i> ' + r.menuList[i].name + '</a></li>)';
            }
            $(".sidebar-menu").append(_li);

        }

    });
}

//递归显示菜单 支持多级
function addMenu(list) {
    if (list) {
        var lis = "";
        for (var i = 0; i < list.length; i++) {
            var _li;
            if (list[i].type === 0) {
                _li = ['<li ><a href="javascript:;" title="' + list[i].name + '">',
                    '<i class="' + list[i].icon + '"></i>',
                    '<span>' + list[i].name + '</span>',
                    '<i class="fa fa-angle-left pull-right"></i>' +
                    '</a></li>'].join("");
                //是否有下级菜单
                if (list[i].list) {
                    var $li = $(_li);
                    $li.find("a").after('<ul class="treeview-menu"></ul>');
                    var childNodes = addMenu(list[i].list);
                    if (childNodes != "") {
                        $li.find(".treeview-menu").append(childNodes);
                    }
                }
                _li = $li.prop("outerHTML");
            }
            if (list[i].type === 1) {
                _li = $('<li><a class="cy-page" href="javascript:;" data-url="' + list[i].url + '" title="' + list[i].name + '"><i class="' + list[i].icon + '"></i> ' + list[i].name + '</a></li>');
            }
            lis += $(_li).prop("outerHTML");
        }
        return lis;
    }
}


$(window).on('resize', function () {
    var $content = $('.content');
    $content.height($(this).height() - 120);
    $content.find('iframe').each(function () {
        $(this).height($content.height());
    });
}).resize();

function clearStorage() {
    var index = layer.load(1, {
        shade: [0.1, '#fff'] //0.1透明度的白色背景
    });
    localStorage.clear();
    layer.close(index);
    layer.msg('清除成功 !', {icon: 1});
}

function updatePassword() {
    //Alert.alert("测试账号不提供修改密码,请下载代码体验完整版");
    //修改密码
    layer.open({
        type: 1,
        skin: 'layui-layer-molv',
        title: "修改密码",
        area: ['550px', '270px'],
        shadeClose: false,
        content: jQuery("#passwordLayer"),
        btn: ['修改', '取消'],
        btn1: function (index) {
            var data = "password=" + $("#password").val() + "&newPassword=" + $("#newPassword").val();
            $.ajax({
                type: "POST",
                url: "sys/user/password",
                data: data,
                dataType: "json",
                success: function (result) {
                    if (result.code == 0) {
                        layer.close(index);
                        layer.alert('修改成功', function (index) {
                            location.reload();
                        });
                    } else {
                        Msg.error(result.msg);
                    }
                }
            });
        }
    });
}

$(document).ready(function () {
    $.getJSON("sys/user/info?_" + $.now(), function (r) {
        $(".username").html(r.user.username);
        //notice();
    });
});