<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<html>
<head>
<script type="text/javascript">
$(function(){
$("[name=brand]").blur(function(){
	$.post("Car_findByName",{"brand":$("[name=brand]").val()},function(){
	});
})
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆入库页面</title>
</head>
<body>

<s:form action="" method="post">
品牌<input type="text" name="brand">
价格<input type="text" name="price">
<button>submit</button>
</s:form>
</body>
</html>