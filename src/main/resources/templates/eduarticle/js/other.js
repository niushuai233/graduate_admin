
var ed;
$(function () {

    ed = initEditor('/upload/eImageUpload', $("#md").val(), "95%", "65%");
});


function syncHtml(){
    alert(123);
    var _val = $("#markdown").val();
    console.log(_val);

}
