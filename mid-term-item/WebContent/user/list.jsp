<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${sessionScope.path }">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公寓管理系统-房屋信息管理</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>房屋信息管理</h3>
	${requestScope.message }
	<c:remove var="message" scope="request"/>
	<div class="actions">
		<div>
			<a class="btn btn-primary" href="user/add.jsp">添加房屋信息</a>
		</div>
	</div>
	<table class="list">
		<tr>
			<th>序号</th>
			<th>所属地区</th>
			<th>所属小区</th>
			<th>单元号</th>
			<th>所属楼层</th>
			<th>房间号</th>
			<th>面积</th>
			<th>朝向</th>
			<th>限住人数</th>
			<th>出租价格(元)</th>
			<th>出租状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.houseList }" var="house" varStatus="sub">
			<tr>
				<td>${sub.index+1 }</td>
				<td>${house.h_area }</td>
				<td>${house.h_estate }</td>
				<td>${house.h_unitNumber }</td>
				<td>${house.h_floor }</td>
				<td>${house.h_roomNo }</td>
				<td>${house.h_acreage }</td>
				<td>${house.h_direction }</td>
				<td>${house.h_limit }</td>
				<td>${house.h_price }</td>
				<td>${house.h_status }</td>
				<%-- <td>
					<c:choose>
						<c:when test="${house.h_status==1 }">${'已出租' }</c:when>
						<c:when test="${house.h_status==2 }">${'未出租' }</c:when>
						<c:otherwise>${'停止出租' }</c:otherwise>
					</c:choose>
				</td> --%>
				<td>
					<a class="fa fa-info" title="详情" href="user/showHouseDetailServlet?h_id=${house.h_id }"></a>
					&nbsp;&nbsp;
					<a class="fa fa-pencil" title="编辑" href="user/queryHouseInformationByIdServlet?h_id=${house.h_id }&pageNum=${requestScope.page.pageNum }"></a>
					&nbsp;&nbsp;
					<a class="fa fa-remove" title="删除" href="user/deleteHouseByIdServlet?h_id=${house.h_id }&pageNum=${requestScope.page.pageNum }" onclick="confirmDelete(1)"></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="pager-info">
		<div>共有${requestScope.page.count }条记录，第 ${requestScope.page.pageNum }/${requestScope.page.pageCount } 页 </div>
		<div>
			<ul class="pagination">
				<li class="paginate_button previous disabled }">
				<a href="user/queryHouseInformationServlet?pageNum=${requestScope.page.pageNum-1 }">上一页</a>
				</li>
				<li class="paginate_button active">
					<a href="user/queryHouseInformationServlet?pageNum=${requestScope.page.pageNum }">${requestScope.page.pageNum }</a>
				</li>
				<li class="paginate_button next disabled">
				<a href="user/queryHouseInformationServlet?pageNum=${requestScope.page.pageNum+1 }">下一页</a>
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