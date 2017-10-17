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
            data:{ajaxmethod:"userCodeVerify",userCode:userCode.val()},//请求Servlet时所携带的数据
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
            data:{ajaxmethod:"userNameVerify",userName:userName.val()},
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

    //给userPassword绑定验证方法
    userPassword.on("blur",function () {
        if (userPassword.val()!=null && userPassword.val().length>5 && userPassword.val().length<20) {
            validateTip(userPassword.next(),{"color":"green"},imgYes,true);
        }else{
            validateTip(userPassword.next(),{"color":"red"},imgNo+" 密码不符合要求",false);
        }
    }).on("focus",function () {
       validateTip(userPassword.next(),{"color":"#666666"},"* 密码长度必须大于等于6小于20",false);
    })

    //给rpassword绑定验证方法
    rpassword.on("blur",function () {
        if (rpassword.val()!=null&&rpassword.val()==userPassword.val()) {
            validateTip(rpassword.next(),{"color":"green"},imgYes,true);
        }else {
            validateTip(rpassword.next(),{"color":"red"},imgNo+" 您的重复密码输入的不正确",false);
        }
    }).on("focus",function () {
       validateTip(rpassword.next(),{"color":"#666666"},"* 请再次输入密码",false);
    })

    //给birthDate绑定非空验证
    birthDate.on("blur",function () {
        if (birthDate.val()!=null&&birthDate.val()!="") {
            validateTip(birthDate.next(),{"color":"green"},imgYes,true);
        }else {
            validateTip(birthDate.next(),{"color":"red"},imgNo+"出生日期不能为空",false);
        }
    }).on("focus",function () {
        validateTip(birthDate.next(),{"color":"#666666"},"请选择您的出生日期",false);
    })

    //使用正则验证电话号码是否符合要求
    phone.on("blur",function () {
        var phonePattern=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
        if (phone.val().match(phonePattern)) {
            validateTip(phone.next(),{"color":"green"},imgYes,true);
        }else {
            validateTip(phone.next(),{"color":"red"},imgNo+" 手机号码的形式不正确",false);
        }
    }).on("focus",function () {
       validateTip(phone.next(),{"color":"#666666"},"请填写您的手机号",false);
    })

    //验证各必填行是否全部填写完毕,并提交数据
    addBtn.on("click",function () {
        //这里validateStatus属性对应的值是字符串形式
        if (userCode.attr("validateStatus")!="true"&&userCode.attr("validateStatus")==null) {
            alert("请填写用户名及其他必填项");
            userCode.blur();
        }else if(userName.attr("validateStatus")!="true"&&userName.attr("validateStatus")==null){
            userName.blur();
        }else if(userPassword.attr("validateStatus")!="true"&&userPassword.attr("validateStatus")==null){
            userPassword.blur();
        }else if(rpassword.attr("validateStatus")!="true"&&rpassword.attr("validateStatus")==null){
            rpassword.blur();
        }else if (birthDate.attr("validateStatus")!="true"&&birthDate.attr("validateStatus")==null) {
            birthDate.blur();
        }else if(phone.attr("validateStatus")!="true"&&birthDate.attr("validateStatus")==null){
            alert("请填写手机号码");
            phone.blur();
        }else{
            if (confirm("您确定要提交吗？")) {
                $("#userAddForm").submit();
            }
        }
    })
})

