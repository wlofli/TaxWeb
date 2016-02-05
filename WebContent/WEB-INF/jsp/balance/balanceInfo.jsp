<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../commons/common.jsp"%>
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
				<span>${fn:substring(content.repost_date,0,4)}年${fn:substring(content.repost_date,4,6)}月资产负债表详情</span>
				<a href="${ctx}/balance/detail/download?date=${content.repost_date}" class="down" target="_self">下载</a>
			</p>
			<p class="nr">
				纳税人名称：${sessionScope.company}</p>
			<p class="nr">
				纳税人识别号：${sessionScope.tax_code}</p>
		</div>

		<div class="table_div">
			<table cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<td colspan="4">资产</td>
						<td colspan="1">序号</td>
						<td colspan="3">期末余额</td>
						<td colspan="3">年初余额</td>
						<td colspan="4">负债</td>
						<td colspan="1">序号</td>
						<td colspan="3">期末余额</td>
						<td colspan="3" class="b_r_n">年初余额</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="data" items="${content.list}">
						<tr>
							<c:choose>
								<c:when test="${empty data.index1}">
									<td class="f_title" colspan="4">${data.asset}</td>
								</c:when>
								<c:otherwise>
									<td colspan="4">${data.asset}</td>
								</c:otherwise>
							</c:choose>
							<td colspan="1">${data.index1}</td>
							<td colspan="3">${data.balance_end1}</td>
							<td colspan="3">${data.balance_begin1}</td>
							<c:choose>
								<c:when test="${empty data.index2}">
									<td class="f_title" colspan="4">${data.liabilities}</td>
								</c:when>
								<c:otherwise>
									<td colspan="4">${data.liabilities}</td>
								</c:otherwise>
							</c:choose>
							<td colspan="1">${data.index2}</td>
							<td colspan="3">${data.balance_end2}</td>
							<td colspan="3" class="b_r_n">${data.balance_begin2}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>