<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script charset="utf-8" src="${ctx }/js/jquery.validate.js"></script>
<script charset="utf-8" src="${ctx }/js/jquery.metadata.js"></script>
<script charset="utf-8" src="${ctx }/js/messages_zh.min.js"></script>
<script type="text/javascript">
jQuery.validator.addMethod("char", function(value, element) { 
	var chrnum = /^([a-zA-Z]+)$/; 
	return this.optional(element) || (chrnum.test(value)); 
	}, "<span style='color:#f00;display:block;margin-left:10px;text-align:left;'>只能输入字母</span>"); 
</script>
    