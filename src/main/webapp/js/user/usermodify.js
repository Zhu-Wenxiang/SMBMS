$(function () {
    var userName = $("#userName");
    var birthDate = $("#birthDate");
    var phone = $("#phone");
    var addBtn = $("#addBtn");
    var userid=$("#userid");

    userName.next().html("*");
    birthDate.next().html("*");
    phone.next().html("*");

    userName.on("blur", function () {
        $.ajax({
            type: "GET",
            url: path + "/usermodifyajax.do",
            data: {ajaxmehtod: "userNameVerify", userName: userName.val(),userId:userid.val()},
            dateType: "json",
            success: function (data) {
                if (data.duplicateResult=='userNameDuplicate') {
                    validateTip(userName.next(),{"color":"red"},imgNo+"对不起，您的用户名已存在",false);
                }else {
                    validateTip(userName.next(), {"color": "green"}, imgYes, true);
                }
            },
            error: function () {
                validateTip(userName.next(), {"color": "red"}, "出现错误啦，快联系帅气的程序员!!!", false);
            }
        })
    }).on("focus",function () {
       validateTip(userName.next(),{"color":"#666666"},"* 您正在修改您的用户名",false);
    })

    birthDate.on("blur",function () {
       var obj=$(this);
        if (obj.val()!=null&&obj.val()!='') {
            validateTip(birthDate.next(),{"color":"red"},imgNo+"对不起，出生日期不能为空",false);
        }else {
            validateTip(birthDate.next(),{"color":"green"},imgYes,true);
        }
    }).on("focus",function () {
        validateTip(birthDate.next(),{"color":"#666666"},"* 请选择出生日期",false);
    })

    phone.on("blur",function () {
        if (phone.val().match(phonePattern)) {
            validateTip(phone.next(),{"color":"red"},imgNo+" 手机号码格式不正确",false)
        }else{
            validateTip(phone.next(),{"color":"green"},imgYes,true);
        }
    }).on("focus",function () {
       validateTip(phone.next(),{"color":"#666666"},"* 请填写您的手机号",false);
    })

    addBtn.on("click",function () {
        if (userName.attr("validateStatus")!="true") {
            userName.blur();
        }else if (birthDate.attr("validateStatus")!="true") {
            birthDate.blur();
        }else if (phone.attr("validateStatus")!="true") {
            phone.blur();
        }else {
            if (confirm("您确定要更改用户信息吗？")) {
                $("#userModifyForm").submit();
            }
        }
    })

})