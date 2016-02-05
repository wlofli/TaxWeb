<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/common.jsp" %>
<%@ include file="../commons/valid.jsp" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no"> 
<title>税务报表查询软件</title>
</head>

<body>
<div class="main">
<img src="${ctx }/images/banner.jpg" class="banner" alt="诚信纳税，贷款无忧" />
<div class="form">
<div class="bt"> 国税网税用户登录 </div>
<form action="${ctx }/tax" id="form" method="post">
<div class="t_d1"><input type="text" class="txt1 required" name="taxUser"  value="330100788297427" placeholder="请输入国税网税用户名" /></div>
<div class="t_d1"><input type="password" class="txt1 required" name="taxPwd" value="788297" placeholder="请输入国税网税密码" /></div>
<div class="b_d1"><a href="javascript:void(0)" onclick="submitForm()" class="next_btn">下一步</a></div>
</form>
</div>
<script type="text/javascript">
	function submitForm(){
		if($("#form").valid()){
			$("#form").submit();
		}
	}
</script>
<jsp:include page="foot.jsp"></jsp:include>
</div> 
</body>
</html>
