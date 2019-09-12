<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${sessionScope.path }">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公寓管理系统-租户信息更新</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>修改租户信息</h3>
	${requestScope.message }
	<c:remove var="message" scope="request"/>
	<form action="user/editLesseeInformationServlet?l_id=${lessee.l_id }&pageNum=${pageNum }&${condition } " method="post">
	<c:set var="condition2" value="${condition }" scope="session"/>
		<table class="form-table">
			<tr>
				<td>姓名</td>
				<td colspan="3" class="control">
					<input type="text" name="l_name" value="${lessee.l_name } ">
				</td>
			</tr>
			<tr>
				<td>手机号码</td>
				<td colspan="3" class="control">
					<input type="text" name="l_tel" value="${lessee.l_tel }">
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td colspan="3" class="control">
					<input type="text" name="l_sex" value="${lessee.l_sex }">
				</td>
			</tr>
			<tr>
				<td>籍贯</td>
				<td colspan="3" class="control">
					<input type="text" name="l_native_place" value="${lessee.l_native_place }">
				</td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td colspan="3" class="control">
					<input type="text" name="l_id_card" value="${lessee.l_id_card }">
				</td>
			</tr>
			<tr>
				<td>添加时间</td>
				<td colspan="3" class="control">
					${lessee.l_create_time }
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