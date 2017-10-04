var path=$("#path").val();
var imgYes="<image width='15px' src='"+path+"/images/y.png'>";
var imgNo="<image width='15px' src='"+path+"/images/n.png'>";
//定义一个函数，用来显示提示信息
function validateTip(element,css,tipString,status) {
   element.css(css);
   element.html(tipString);
   //把当前是否通过校验的状态储存在status里,true/false
   element.prev().attr("validateStatus",status);
}