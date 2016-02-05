<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../commons/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<title>税务报表查询软件</title>
</head>

<body>
	<div class="main">
		<div class="tab_bt">
			<p class="bt">
				<span>${fn:substring(content.repost_date,0,4)}年${fn:substring(content.repost_date,4,6)}月利润表详情</span><a
					href="${ctx}/profit/detail/download?date=${content.repost_date}" class="down" target="_self">下载</a>
			</p>
			<p class="nr">纳税人名称：${sessionScope.company}</p>
			<p class="nr">纳税人识别号：${sessionScope.tax_code}</p>
		</div>

		<div class="lir_table">
			<table cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<td colspan="4">项目</td>
						<td colspan="1">序号</td>
						<td colspan="2">本月累计</td>
						<td colspan="3" class="b_r_n">本年累计</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="data" items="${content.list}">
					<tr>
						<td colspan="4">${data.item}</td>
						<td colspan="1">${data.index}</td>
						<td colspan="2">${data.month_amount}</td>
						<td colspan="3" class="b_r_n">${data.year_amount}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>