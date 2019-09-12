<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${sessionScope.path }">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公寓管理系统-合同信息修改</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>修改合同信息</h3>
	${requestScope.message }
	<c:remove var="message" scope="request"/>
	<form action="user/editLeaseContractInformationServlet?lc_id=${contract.lc_id }&pageNum=${pageNum }&${condition } " method="post">
	
	<c:set var="condition4" value="${condition }" scope="session"/>
	
		<table class="form-table">
			<tr>
			<td>租赁合同号</td>
			<td colspan="3" class="control">
				<input type="text" name="lc_contract_number" value="${contract.lc_contract_number }">
			</td>
		</tr>
		<tr>
			<td>房屋编号</td>
			<td colspan="3" class="control">
				<input type="text" name="h_id" value="${contract.h_id }">
			</td>
		</tr>
		<tr>
			<td>租户编号</td>
			<td colspan="3" class="control">
				<input type="text" name="l_id" value="${contract.l_id }">
			</td>
		</tr>
		<tr>
			<td>合同日期</td>
			<td colspan="3" class="control">
				<input type="date" name="lc_contract_date" value="${contract.lc_contract_date }">
			</td>
		</tr>
		<tr>
		<td>租赁开始时间</td>
		<td colspan="3" class="control">
			<input type="date" name="lc_contract_start_date" value="${contract.lc_contract_start_date }">
		</td>
		</tr>
		<tr>
			<td>租赁结束时间</td>
			<td colspan="3" class="control">
				<input type="date" name="lc_contract_end_date" value="${contract.lc_contract_end_date }">
			</td>
		</tr>
		<tr>
			<td>房租总额</td>
			<td colspan="3" class="control">
				<input type="text" name="lc_total_rent" value="${contract.lc_total_rent }">
			</td>
		</tr>
		<tr>
			<td>付款方式</td>
			<td colspan="3" class="control">
				<select name="lc_pay_way">
					<option value="0" ${'0'==contract.lc_contract_state?'selected':'' }>月付</option>
					<option value="1" ${'1'==contract.lc_contract_state?'selected':'' }>半年付</option>
					<option value="2" ${'2'==contract.lc_contract_state?'selected':'' }>年付</option>
					<option value="3" ${'3'==contract.lc_contract_state?'selected':'' }>季付</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>押金</td>
			<td colspan="3" class="control">
				<input type="text" name="lc_deposit" value="${contract.lc_deposit }">
			</td>
		</tr>
		<tr>
			<td>付款期数</td>
			<td colspan="3" class="control">
				<input type="text" name="lc_period_payment" value="${contract.lc_period_payment }">
			</td>
		</tr>
		<tr>
			<td>合同签署人</td>
			<td colspan="3" class="control">
				<input type="text" name="lc_contract_signer" value="${contract.lc_contract_signer }">
			</td>
		</tr>
		<tr>
			<td>合同状态</td>
			<td colspan="3" class="control">
				<select name="lc_contract_state">
					<option value="1" ${'1'==contract.lc_contract_state?'selected':'' }>生效</option>
					<option value="0" ${'0'==contract.lc_contract_state?'selected':'' }>失效</option>
				</select>
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