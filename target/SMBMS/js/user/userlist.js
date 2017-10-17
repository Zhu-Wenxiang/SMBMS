$(function () {
   //$(".viewUser").addBehavior(path+"/viewuser.do");

   $(".modifyUser").on("click",function () {
       var obj=$(this);
       window.location.href=path+"/modifyuser.do";
   });

   $(".deleteUser").on("click",function () {
       var obj=$(this);
       if (confirm("是否确定删除"+obj.attr("username"))) {
          $.ajax({
              type:"GET",
              url:path+"/userdelete.do",
              data:{userid:obj.attr("userid")},
              dataType:"json",
              success:function (data) {
                  if (data.deleteResult=="notExist") {
                      alert("用户["+obj.attr("username")+"]不存在!")
                  }else if (data.deleteResult=="deleted") {
                      obj.parents("tr").remove();
                      alert("删除用户["+obj.attr("username")+"]成功");
                  }else {
                      obj.alert("出现了未知错误，请火速联系帅气的程序猿!!!");
                  }
              },
              error:function () {
                  alert("删除用户"+obj.attr("username")+"失败");
              }
          })
       }
   });
})