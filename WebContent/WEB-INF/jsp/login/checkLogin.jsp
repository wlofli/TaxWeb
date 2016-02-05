<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../commons/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no"> 
<title>税务报表查询软件</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" type="text/css" rel="stylesheet" />
</head>

<body>
<div class="main">
<img src="${ctx }/images/banner.jpg" class="banner" alt="诚信纳税，贷款无忧" />
<div class="form">
<div class="bt"> 登录用户确认 </div>
<div class="t_d1"><input type="text" class="txt1" value="${taxUser }" disabled="disabled" required="required" placeholder="请输入国税网税用户名" /></div> 
<div class="t_d1"><input type="text" class="txt1" value="${vpdnUser }" disabled="disabled" required="required" placeholder="请输入VPDN用户名" /></div> 
<div class="b_d1"><a href="javascript:tjxx()" class="next_btn">提交</a></div>
<div class="b_d2"><a href="${ctx }/tomodify" class="back_btn">返回修改</a></div>
</div>
<script type="text/javascript">
var times = 0;

function tjxx(){
	if(times == 0){
		times = times + 1;
		$.ajax({
			   url:"${ctx}/login",
			   type:"post",
			   async:true,
			   success:function(data){
			   var json = eval('('+data+')');
			   if(json.result != "true"){
				   $("#msg").html(json.message);
				   show1();
			   }else{
				   window.location.href = "${ctx}/tree";
			   }
			   }
		});
	}else{
		show1();
	}
}
	
	
function show1(){
	$("#ts").show();
	$("#over").show();
}	
	
function hide1(){
	 $("#ts").hide();
     $("#over").hide();
//      window.location.href = "${ctx}/";
	}
</script>
<jsp:include page="foot.jsp"></jsp:include>
</div> 

<div class="ts" id="ts">
<p class="tswz" id="msg"></p>
<p class="tj_btn"><a href="javascript:void(0)" onclick="hide1()" >确定</a></p>
</div>  
<div id="over"></div>
</body>
</html>

