<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${sessionScope.path }">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公寓管理系统-租赁合同管理</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>合同信息管理</h3>
	${requestScope.message }
	<c:remove var="message" scope="request"/>
	<div class="actions">
		<div>
			<a class="btn btn-primary" href="user/queryUserableInformationServlet">添加合同信息</a>
		</div>
		<form action="user/queryLeaseContractInformationByConditionServlet" method="post">
			合同号:<input type="text" name="lc_contract_number">
			合同日期:<input type="date" name="lc_contract_date">
			合同状态:<select name="lc_contract_state">
				<option value="">----请选择----</option>
				<option value="1">有效</option>
				<option value="0">已失效</option>
			</select>
			<input class="btn btn-primary va-bottom" type="submit" value="搜索">
		</form>
	</div>
	<table class="list">
		<tr>
			<th>序号</th>
			<th>合同号</th>
			<th>房屋所属小区</th>
			<th>租户姓名</th>
			<th>租赁开始时间</th>
			<th>租赁结束时间</th>
			<th>房租总额</th>
			<th>付款方式</th>
			<th>押金</th>
			<th>付款期数</th>
			<th>合同签署人</th>
			<th>合同状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${contractList }" var="contract" varStatus="sub">
			<tr>
				<td>${sub.index+1 }</td>
				<td>${contract.lc_contract_number }</td>
				<td>${contract.h_estate }</td>
				<td>${contract.l_name }</td>
				<td>${contract.lc_contract_start_date }</td>
				<td>${contract.lc_contract_end_date }</td>
				<td>${contract.lc_total_rent }</td>
				<td>${contract.lc_pay_way }</td>
				<td>${contract.lc_deposit }</td>
				<td>${contract.lc_period_payment }</td>
				<td>${contract.lc_contract_signer }</td>
				<td>
				<c:choose>
					<c:when test="${contract.lc_contract_state==1 }">${'有效' }</c:when>
					<c:otherwise>${'已失效' }</c:otherwise>
				</c:choose>
				</td>
				<td>
					<a class="fa fa-pencil" title="编辑" href="user/queryLeaseContractInformationByIdServlet?lc_id=${contract.lc_id }&pageNum=${page.pageNum }"></a>
					&nbsp;&nbsp;
					<a class="fa fa-remove" title="删除" href="user/deleteLeaseContractByIdServlet?lc_id=${contract.lc_id }&pageNum=${page.pageNum } " onclick="confirmDelete(1)"></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:set var="contractCondition" scope="session" value="${condition }"/>
	<div class="pager-info">
		<div>共有${page.count }条记录，第 ${page.pageNum }/${page.pageCount } 页 </div>
		<div>
			<ul class="pagination">
				<li class="paginate_button previous disabled }">
				<a href="user/queryLeaseContractInformationByConditionServlet?pageNum=${page.pageNum-1 }&${condition }">上一页</a>
				</li>
				<li class="paginate_button active">
					<a href="user/queryLeaseContractInformationByConditionServlet?pageNum=${page.pageNum }&${condition }">${page.pageNum }</a>
				</li>
				<li class="paginate_button next disabled">
				<a href="user/queryLeaseContractInformationByConditionServlet?pageNum=${page.pageNum+1 }&${condition }">下一页</a>
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