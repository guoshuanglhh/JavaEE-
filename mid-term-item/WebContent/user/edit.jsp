<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${sessionScope.path }">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公寓管理系统-房屋信息更新</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>修改房屋信息</h3>
	${requestScope.message }
	<c:remove var="message" scope="request"/>
	<form action="user/editHouseInformationServlet?h_id=${requestScope.house.h_id }&pageNum=${requestScope.pageNum }" method="post">
		<table class="form-table">
			<tr>
				<td>地区</td>
				<td colspan="3" class="control">
					<input type="text" name="h_area1" placeholder="填写地区" value="${requestScope.house.h_area } ">
				</td>
			</tr>
			<tr>
				<td>小区名字</td>
				<td colspan="3" class="control">
					<input type="text" name="h_estate1" placeholder="小区名字" value="${requestScope.house.h_estate }">
				</td>
			</tr>
			<tr>
				<td>单元号</td>
				<td colspan="3" class="control">
					<input type="text" name="h_unitNumber1" placeholder="单元号" value="${requestScope.house.h_unitNumber }">
				</td>
			</tr>
			<tr>
				<td>楼层</td>
				<td colspan="3" class="control">
					<input type="text" name="h_floor1" placeholder="楼层" value="${requestScope.house.h_floor }">
				</td>
			</tr>
			<tr>
				<td>房间号</td>
				<td colspan="3" class="control">
					<input type="text" name="h_roomNo1" placeholder="房间号" value="${requestScope.house.h_roomNo }">
				</td>
			</tr>
			<tr>
				<td>面积（平米）</td>
				<td colspan="3" class="control">
					<input type="text" name="h_acreage1" placeholder="面积" value="${requestScope.house.h_acreage }">
				</td>
			</tr>
			<tr>
				<td>朝向</td>
				<td colspan="3" class="control">
					<input type="text" name="h_direction1" placeholder="朝向" value="${requestScope.house.h_direction }">
				</td>
			</tr>
			<tr>
				<td>装修</td>
				<td colspan="3" class="control">
					<input type="text" name="h_fitment1" placeholder="装修" value="${requestScope.house.h_fitment }">
				</td>
			</tr>
			<tr>
				<td>是否双气</td>
				<td colspan="3" class="control">
					<input type="text" name="" placeholder="是否双气" value="${requestScope.house.h_isDoubleAir }">
				</td>
			</tr>
			<tr>
				<td>限住人数</td>
				<td colspan="3" class="control">
					<input type="text" name="h_limit1" placeholder="限住人数" value="${requestScope.house.h_limit }">
				</td>
			</tr>
			<tr>
				<td>配套设施</td>
				<td colspan="3" class="control">
					<input type="text" name="h_facility1" placeholder="配套设施" value="${requestScope.house.h_facility }">
				</td>
			</tr>
			<tr>
				<td>出租价格（元/月）</td>
				<td colspan="3" class="control">
					<input type="text" name="h_price1" placeholder="出租价格" value="${requestScope.house.h_price }">
				</td>
			</tr>
			<tr>
				<td>出租状态</td>
				<td colspan="3" class="control">
					<select name="h_status">
						<option value="已出租" ${'已出租'==requestScope.house.h_status?'select':'' }>已出租</option>
						<option value="未出租" ${'未出租'==requestScope.house.h_status?'select':'' }>未出租</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>房屋图片</td>
				<td colspan="3" class="control">
					<p><img src="image/bg.jpg" width="300px" height="200px"></p>
					<input type="file" name="">
				</td>
			</tr>
			<tr>
				<td>完整地址信息</td>
				<td colspan="3" class="control">
					<input type="text" name="h_address1" placeholder="完整地址信息" value="${requestScope.house.h_address }">
				</td>
			</tr>

			<tr>
				<td>备注说明</td>
				<td colspan="3" class="control">
					<textarea class="p100" name="" placeholder="备注说明信息">房屋备注说明信息</textarea>
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