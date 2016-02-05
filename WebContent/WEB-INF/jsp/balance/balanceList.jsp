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
<script type="text/javascript">
	$(function() {
		var li = "${type}";
		$("#li_" + li).addClass("hit");
	});
</script>
</head>

<body>
	<div class="main">
		<div class="tab_bt">
			<p class="bt">
				<span>资产负债表</span><a href="${ctx}/balance/all/download?type=${type}" class="down">下载</a>
			</p>
			<p class="nr">
				纳税人名称：${sessionScope.company}</p>
			<p class="nr">
				纳税人识别号：${sessionScope.tax_code}</p>
		</div>
		<ul class="tab_xxk">
			<li id="li_1"><a href="${ctx }/balance/list" target="_self">近3个月</a></li>
			<li id="li_2"><a href="${ctx }/balance/list?year=${nowYear-1}"
				target="_self">${nowYear-1}年</a></li>
			<li id="li_3"><a href="${ctx }/balance/list?year=${nowYear-2}"
				target="_self" class="b_n">${nowYear-2}年</a></li>
		</ul>
		<div class="tab_item">
			<c:if test="${type eq 1}">
				<c:if test="${fn:length(nowYearData) gt 0}">
					<ul class="zc_list">
						<li class="bt"><span>${nowYear}年</span></li>
						<c:forEach var="data" items="${nowYearData}">
							<li class="nr">
								<a href="${ctx}/balance/info?date=${data.reportDate}">
									<p>
										报表日期： <span>${fn:substring(data.reportDate,0,4)}年${fn:substring(data.reportDate,4,6)}月</span>
									</p> <img src="${ctx}/images/right_tb.png" />
									<div class="clear"></div>
							</a></li>
						</c:forEach>
					</ul>
				</c:if>
				<c:if test="${fn:length(lastYearData) gt 0}">
					<ul class="zc_list">
						<li class="bt"><span>${nowYear-1}年</span></li>
						<c:forEach var="data" items="${lastYearData}">
							<li class="nr">
								<a href="${ctx}/balance/info?date=${data.reportDate}">
									<p>
										报表日期： <span>${fn:substring(data.reportDate,0,4)}年${fn:substring(data.reportDate,4,6)}月</span>
									</p> <img src="${ctx}/images/right_tb.png" />
									<div class="clear"></div>
								</a>
							</li>
						</c:forEach>
					</ul>
				</c:if>
			</c:if>
			<c:if test="${type eq 2}">
				<ul class="zc_list">
					<li class="bt"><span>${nowYear-1}年</span></li>
					<c:forEach var="data" items="${lastYearData}">
						<li class="nr"><a href="${ctx}/balance/info?date=${data.reportDate}">
								<p>
									报表日期： <span>${fn:substring(data.reportDate,0,4)}年${fn:substring(data.reportDate,4,6)}月</span>
								</p> <img src="${ctx}/images/right_tb.png" />
								<div class="clear"></div>
						</a></li>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${type eq 3}">
				<ul class="zc_list">
					<li class="bt"><span>${nowYear-2}年</span></li>
					<c:forEach var="data" items="${previousYearData}">
						<li class="nr"><a href="${ctx}/balance/info?date=${data.reportDate}">
								<p>
									报表日期： <span>${fn:substring(data.reportDate,0,4)}年${fn:substring(data.reportDate,4,6)}月</span>
								</p> <img src="${ctx}/images/right_tb.png" />
								<div class="clear"></div>
						</a></li>
					</c:forEach> 
				</ul>
			</c:if>
		</div>
	</div>
</body>
</html>