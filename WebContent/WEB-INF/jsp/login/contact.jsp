<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../commons/common.jsp" %>
<%@ include file="../commons/valid.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no"> 
<title>税务报表查询软件</title>
</head>
<body>
<div class="main">
<img src="${ctx}/images/banner.jpg" class="banner" alt="诚信纳税，贷款无忧" />
<div class="form">
<div class="bt"> 添加联系人及手机 </div>
<form action="${ctx }/addcontackinfo" id="form" method="post">
<div class="t_d1"><input type="text" class="txt1 required" name="company"  placeholder="请输入公司名称" /></div>
<div class="t_d1"><input type="text" class="txt1 required" name="name"  placeholder="请输入联系人姓名" /></div>
<div class="t_d1"><input type="text" class="txt1 required" name="phone" id="phone"  placeholder="请输入手机号码" /></div>
<div class="t_d1"><input type="text" class="txt2 required" id="validCode" name="validCode"  placeholder="请输入验证码" />
	<input type="button" onclick="getCheckCode()" class="yzm_btn" id="check_button" value="获取验证码" /><div class="clear"></div></div>
<div class="b_d1"><a href="javascript:void(0)" onclick="add()" class="next_btn">下一步</a></div>
</form>

<script type="text/javascript">
function add(){
	if($("#form").valid()){
		$.ajax({
			   url:"${ctx}/common/check/code",
			   type:"post",
			   data:{"code":$("#validCode").val()},
			   async:true,
			   success:function(data){
				    if(data == true){
					   $("#form").submit();
				   	}else{
				   		alert("手机验证码不正确");
				   	}
			   }
		});
// 		$("#form").submit();
	}
}
	var times = 61;
	function getCheckCode(){
		var tel = $("#phone").val();
		
		if (tel == "") {
			alert("请填写手机号！");
			return;
		}
		var re = /^([0-9]{11})$/;
		if(!re.test(tel)){
			alert("请填写正确手机号");
			return;
		}
		$.ajax({
			url:"${ctx}/send/tel/code?phone="+tel,
			type:"post",
			success:function(data){
				if (data=="true") {
					timers();
				} else {
					alert("验证码发送失败！");
				}
			}
		});
		
	}

	function timers(){
		if (times == 1) {
			$("#check_button").val("获取验证码");
			$("#check_button").removeClass("yzm_btn1");
			$("#check_button").addClass("yzm_btn");
			$("#check_button").removeAttr("disabled");
			times = 61;
		} else {
			$("#check_button").removeClass("yzm_btn");
			$("#check_button").addClass("yzm_btn1");
			$("#check_button").attr("disabled","disabled");
			times = times - 1;
			$("#check_button").val(times+"秒后重置");
			setTimeout(function(){timers()},1000);
		}
	}

</script>



</div>

<jsp:include page="foot.jsp"></jsp:include>
</div> 
</body>
</html>