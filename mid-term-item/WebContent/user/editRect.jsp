<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${sessionScope.path }">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公寓管理系统-房租信息更新</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>修改租户信息</h3>
	${requestScope.message }
	<c:remove var="message" scope="request"/>
	<form action="user/editRectInformationServlet?r_id=${rects.r_id }&pageNum=${pageNum }&${condition } " method="post">
	
	<c:set var="condition3" value="${condition }" scope="session"/>
	
		<table class="form-table">
			<tr>
			<td>未出租房屋编号</td>
			<td colspan="3" class="control">
				<select name="h_id">
					<option value="${rects.h_id }">${rects.h_id }</option>
					<c:forEach items="${sessionScope.notRentHouseId }" var="availableHouseId">
					<option value="${availableHouseId.h_id }">${availableHouseId.h_id }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>租户编号</td>
			<td colspan="3" class="control">
				<select name="l_id">
					<option value="${rects.l_id }">${rects.l_id }</option>
					<c:forEach items="${sessionScope.notRentHouseId }" var="availableLesseeId">
					<option value="${availableLesseeId.l_id }">${availableLesseeId.l_id }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>缴纳金额</td>
			<td colspan="3" class="control">
				<input type="text" name="r_money" value="${rects.r_money }">
			</td>
		</tr>
		<tr>
			<td>缴纳时间</td>
			<td colspan="3" class="control">
				<input type="date" name="r_time" value="${rects.r_time }">
			</td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="3" class="control">
				<input type="text" name="r_remark" value="${rects.r_remark }">
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