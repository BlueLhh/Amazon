<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lhh.amazon.entity.Order"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>


<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 订单页</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript" src="scripts/shopping.js"></script>
<style type="text/css">
#qname {
	height: 36px;
}

#oderview {
	font-size: 14px
}
</style>

</head>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="position" class="wrap">
		您现在的位置：<a href="ProductServlet">亚马逊</a> &gt; 最新订单
	</div>
	<div class="wrap">
		<div id="shopping">
			<form action="doBuy" method="post">
				<table id="oderview">
					<c:set value="" var="view"></c:set>
					<c:set value="${sessionScope.order}" var="order"></c:set>
					<tr>
						<%-- <%
							Order order = (Order) request.getSession().getAttribute("order");
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						%> --%>
						<th>订单时间:${order.createTime}</th>
						<th>订单号:${order.orderID}</th>
						<th>订单总额:${order.cost}</th>
						<th>订单状态</th>
					</tr>
					<!-- 根据用户购物车生成列表 -->
					<c:forEach items="${order.list}" var="orderDetail">
						<c:set value="${orderDetail.product}" var="product"></c:set>
						<tr id="product_id_1">
							<td class="thumb"><img style="width: 100px; height: 100px;"
								src="${product.fileName}" /><a
								href="pview?id=${product.productID}">${product.productName}</a></td>
							<td class="price">￥<span>单价：${(orderDetail.cost)/(orderDetail.quantity)}</span>
							</td>
							<td class="number"><span>X${orderDetail.quantity}</span></td>
							<td class="delete">正在发货</td>
						</tr>
					</c:forEach>
				</table>

			</form>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2016 上海海文 All Rights Reserved.
	</div>
</body>
</html>

