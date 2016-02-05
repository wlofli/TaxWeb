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
	<div class="tab">
	<c:choose>
	<c:when test="${empty org}">
		正在为您准备信息,请耐心等待
	</c:when>
	<c:otherwise>
	<table>
		<thead>
			<tr>
				<td colspan="3">纳税人基本信息</td>
			</tr>
		</thead>
			<tbody>
			<tr>
				<td colspan="1" class="td_left">纳税人识别号:</td>
				<td colspan="2">${org.taxCode }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">纳税人名称:</td>
				<td colspan="2">${org.name }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">生产经营地址:</td>
				<td colspan="2">${org.address }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">税务主管机关:</td>
				<td colspan="2">${org.taxOrg }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">登记注册类型:</td>
				<td colspan="2">${org.regtype }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">所属行业:</td>
				<td colspan="2">${org.industry }</td>
			</tr><tr>
				<td colspan="1" class="td_left">联系电话:</td>
				<td colspan="2">${org.tel }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">法人代表:</td>
				<td colspan="2">${org.legalPerson }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">税务人税务机关:</td>
				<td colspan="2">${org.mOrg }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">征收机关:</td>
				<td colspan="2">${org.cOrg }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">扣款授权号:</td>
				<td colspan="2">${org.chargeCode }</td>
			</tr>
			<tr>
				<td colspan="1" class="td_left">手机联系号码:</td>
				<td colspan="2">${org.mobile }</td>
			</tr>
		</tbody>
	</table>
	</c:otherwise>
	</c:choose>
	</div>
</div> 
</body>
</html>