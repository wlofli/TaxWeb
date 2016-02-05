<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no"> 
<title>税务报表查询软件</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
</head>

<body>
<div class="main">
<img src="${ctx}/images/banner.jpg" class="banner" alt="诚信纳税，贷款无忧" />
<ul class="ind_list">
<li><a href="${ctx}/contactinfo?bank=1"><I class="icon"><img src="${ctx}/images/bank1.png" /></I><span>中国工商银行</span></a></li>
<li><a href="${ctx}/contactinfo?bank=2"><I class="icon"><img src="${ctx}/images/bank2.png" /></I><span>中国银行</span></a></li>
<li><a href="${ctx}/contactinfo?bank=3"><I class="icon"><img src="${ctx}/images/bank3.png" /></I><span>中国建设银行</span></a></li>
<li><a href="${ctx}/contactinfo?bank=4"><I class="icon"><img src="${ctx}/images/bank4.png" /></I><span>中国农业银行</span></a></li>
<li><a href="${ctx}/contactinfo?bank=5"><I class="icon"><img src="${ctx}/images/bank5.png" /></I><span>中国交通银行</span></a></li>
<li><a href="${ctx}/contactinfo?bank=6"><I class="icon"><img src="${ctx}/images/bank6.png" /></I><span>其他银行</span></a></li>
<div class="clear"></div>
</ul>
<jsp:include page="foot.jsp"></jsp:include>
</div> 
</body>
</html>
