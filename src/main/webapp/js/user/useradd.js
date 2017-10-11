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
    //给userCode绑定操作,使用Ajax异步验证user Code是否已经存在
    userCode.bind("blur",function () {
        //进行ajax异步验证，并根据结果显示提示
        $.ajax({
            type:"GET",//请求类型
            url:path+"/useradd.do",//请求的Servlet
            data:{method:"userCodeVerify",userCode:userCode.val()},//请求Servlet时所携带的数据
            dataType:"json",//返回数据的类型
            success:function (data) {//data是方法调用成功所返回的数据
                //如果账号已存在，则提示已存在
                if (data.userCode=='userCodeNull'){
                    validateTip(userCode.next(),{"color":"red"},imgNo+" 用户账号不能为空",false);
                }else if (data.userCode=='exist'){
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

    //给userName绑定Ajax异步验证方法，验证userCode是否已经存在
    userName.on("blur",function () {
        $.ajax({
            type:"GET",
            url:path+"/useradd.do",
            data:{method:"userNameVerify",userName:userName.val()},
            dataType:"json",
            success:function (data) {//通过后台传过来的键值对，进行相应提示
                if (data.result=="userNameNull") {
                   validateTip(userName.next(),{"color":"red"},imgNo+"用户名为空了",false);
                }else if (data.result=="userNameUsable") {
                    validateTip(userName.next(),{"color":"green"},imgYes+"用户名可以使用",true);
                }else if (data.result=="userNameExist") {
                    validateTip(userName.next(),{"color":"green"},imgNo+"用户名已存在",false);
                }
            },
            error:function () {//出现错误，则提示页面不存在
               validateTip(userName.next(),{"color":"red"},imgNo+"出现错误,页面不存在",false);
            }
        })
    }).on("focus",function () {
       validateTip(userName.next(),{"color":"#666666"},"* 用户名是您的昵称");
    });
})

