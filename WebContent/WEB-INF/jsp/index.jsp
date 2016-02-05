<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="commons/common.jsp" %>
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
<ul class="res_list">
<li class="res1"><a href="${ctx }/org/getinfo?taxCode=<%=session.getAttribute("tax_code") %>"><span>企业基本信息</span><img src="${ctx}/images/right_tb.png" /><span class="clear"></span></a></li>  
<li class="res2"><a href="${ctx }/balance/list"><span>资产负债表</span><img src="${ctx}/images/right_tb.png" /><span class="clear"></span></a></li>  
<li class="res3"><a href="${ctx }/profit/list"><span>利润表</span><img src="${ctx}/images/right_tb.png" /><span class="clear"></span></a></li>  
<li class="res4"><a href="${ctx }/VAT/list"><span>增值税表</span><img src="${ctx}/images/right_tb.png" /><span class="clear"></span></a></li>  
</ul>
<div class="footer"><p>杭州摩科商用设备有限公司技术支持</p></div>
</div> 
</body>
</html>