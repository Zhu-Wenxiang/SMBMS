var userName=null;
var userCode=null;
var userPassword=null;
var rpassword=null;
var birthDate=null;
var phone=null;
var addBtn=null;

$(function () {
    userName=$("#userName");
    userCode=$("#userCode");
    userPassword=$("#userPassword");
    rpassword=$("#rpassword");
    birthDate=$("#birthDate");
    phone=$("#phone");
    addBtn=$("#addBtn");
    //在每个必填项后面加上红*
    userName.next().html("*");
    userCode.next().html("*");
    userPassword.next().html("*");
    rpassword.next().html("*");
    birthDate.next().html("*");
    phone.next().html("*");
    //给userCode绑定操作
    userCode.bind("blur",function () {
        //进行ajax异步验证，并根据结果显示提示
        $.ajax({
            type:"GET",//请求类型
            url:path+"/useradd.do",//请求的Servlet
            data:{method:"userCodeVerify",userCode:userCode.val()},//请求Servlet时所携带的数据
            dataType:"json",//返回数据的类型
            success:function (data) {//data是方法调用成功所返回的数据
                //如果账号已存在，则提示已存在
                if (data.userCode=='exist') {
                    validateTip(userCode.next(),{"color":"red"},imgNo+" 该账号已存在，请重新输入",false);
                }else{//账号不存在，则提示可以注册
                    validateTip(userCode.next(),{"color":"green"},imgYes+"该账号可以使用",true);
                }
            },
            error:function () {//当访问时出现404,500等状态码时
                validateTip(userCode.next(),{"color":"red"},"您所访问的页面不存在",false);
            }
        });
    }).bind("focus",function () {
        //鼠标聚焦时提示信息
        validateTip(userCode.next(),{"color":"#666666"},"* 用户账号是您的登陆账号",false);
    });
    userCode.focus();
});


