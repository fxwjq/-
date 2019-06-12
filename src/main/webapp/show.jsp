<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.bootcss.com/animate.css/3.7.1/animate.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<title>用户主页</title>
</head>
<body>
<table  class="table">
<tr>
<td>序号</td>
<td>品牌</td>
<td>价格</td>
<td>添加</td>
<td>删除</td>
<td>修改</td>
</tr>
<c:forEach var="car" items="${page.list}">
<tr>
<td>${car.id}</td>
<td>${car.brand}</td>
<td>${car.price}</td>
<td><a href="add.jsp">添加</a></td>
<td><a href="Car_delete?id=${car.id}">删除</a></td>
<td><a href="Car_findOne?id=${car.id}">修改</a></td>
</tr>
</c:forEach>
<tr>
<td colspan="6">
<a href="Car_show?p=1">首页</a>
<a href="Car_show?p=${page.prev}">上一页</a>
<a href="Car_show?p=${page.next}">下一页</a>
<a href="Car_show?p=${page.maxPage}">末页</a>
</td>
</tr>
</table>
</body>
</html>