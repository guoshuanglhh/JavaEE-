<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${sessionScope.path }">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公寓管理系统-租户信息管理</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>添加租户信息</h3>
	${requestScope.message }
	<form action="user/addLesseeInformationServlet" method="post">
	<table class="form-table">
		<tr>
			<td>姓名</td>
			<td colspan="3" class="control">
				<input type="text" name="l_name" placeholder="租户姓名">
			</td>
		</tr>
		<tr>
			<td>手机号</td>
			<td colspan="3" class="control">
				<input type="text" name="l_tel" placeholder="联系方式">
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td colspan="3" class="control">
				<input type="text" name="l_sex" placeholder="租户性别">
			</td>
		</tr>
		<tr>
			<td>籍贯</td>
			<td colspan="3" class="control">
				<input type="text" name="l_native_place" placeholder="租户籍贯">
			</td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td colspan="3" class="control">
				<input type="text" name="l_id_card" placeholder="身份证号">
			</td>
		</tr>
	</table>
	<div class="buttons">
		<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
		<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
	</div>
	</form>
</div>
</body>
</html>