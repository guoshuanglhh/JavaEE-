<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${sessionScope.path }">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公寓管理系统-房租信息管理</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>房租信息管理</h3>
	<span style="color: red;">${requestScope.message }</span>
	<%-- <c:remove var="message" scope="request"/> --%>
	<div class="actions">
		<div>
			<a class="btn btn-primary" href="user/queryAvailableInformationServlet">添加房租信息</a>
		</div>
		<form action="user/queryRectInformationByConditionServlet" method="post">
			姓名:<input type="text" name="l_name">
			手机号码:<input type="text" name="l_tel">
			缴纳时间:<input type="date" name="r_time">
			<input class="btn btn-primary va-bottom" type="submit" value="搜索">
		</form>
	</div>
	<table class="list">
		<tr>
			<th>序号</th>
			<th>小区</th>
			<th>姓名</th>
			<th>手机号码</th>
			<th>缴纳金额</th>
			<th>缴纳时间</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${rectList }" var="rect" varStatus="sub">
			<tr>
				<td>${sub.index+1 }</td>
				<td>${rect.h_estate }</td>
				<td>${rect.l_name }</td>
				<td>${rect.l_tel }</td>
				<td>${rect.r_money }</td>
				<td>${rect.r_time }</td>
				<td>${rect.r_remark }</td>
				<td>
					<a class="fa fa-pencil" title="编辑" href="user/queryRectInformationByIdServlet?r_id=${rect.r_id }&pageNum=${page.pageNum }"></a>
					&nbsp;&nbsp;
					<a class="fa fa-remove" title="删除" href="user/deleteRectByIdServlet?r_id=${rect.r_id }&pageNum=${page.pageNum } " onclick="confirmDelete(1)"></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:set var="condition2" scope="session" value="${condition }"/>
	<div class="pager-info">
		<div>共有${page.count }条记录，第 ${page.pageNum }/${page.pageCount } 页 </div>
		<div>
			<ul class="pagination">
				<li class="paginate_button previous disabled }">
				<a href="user/queryRectInformationByConditionServlet?pageNum=${page.pageNum-1 }&${condition } ">上一页</a>
				</li>
				<li class="paginate_button active">
					<a href="user/queryRectInformationByConditionServlet?pageNum=${page.pageNum }&${condition } ">${page.pageNum }</a>
				</li>
				<li class="paginate_button next disabled">
				<a href="user/queryRectInformationByConditionServlet?pageNum=${page.pageNum+1 }&${condition } ">下一页</a>
				</li>
			</ul>
		</div>
	</div>
</div>
<script src="lib/jquery/jquery.js"></script>
<script>
function confirmDelete(id){
	if (confirm("确定要删除码？")) {
		alert('发送删除请求，刷新页面（不要异步）');
	}
	return false;
}
</script>
</body>
</html>