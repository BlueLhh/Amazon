<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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

	<div id="position" class="wraporder">
		您现在的位置：<a href="ProductServlet">亚马逊</a> &gt; 我的订单
	</div>
	<div class="wraporder">
		<div id="shopping">
			<form action="doBuy" method="post">

				<table id="oderview">
					<c:set value="" var="view"></c:set>
					<c:forEach items="${sessionScope.list}" var="order">
						<tr>
							<th>订单时间:${order.createTime}</th>
							<th>订单号:${order.orderID}</th>
							<th>订单总额:${order.cost}</th>
							<th>订单状态</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${order.list }" var="od" varStatus="stat">
							<tr id="product_id_1">
								<td class="thumb"><img style="width: 100px; height: 100px;"
									src="${od.product.fileName}" /><a
									href="pview?id=${od.product.productID}">${od.product.productName}</a></td>
								<td class="price">￥<span>单价：${(od.cost)/(od.quantity)}</span>
								</td>
								<td class="number"><span>X${od.quantity}</span></td>
								<c:if test="${ stat.index == 0}">
									<td rowspan="${fn:length(order.list)}" class="delete"><c:choose>
											<c:when test="${order.status == 0 }">
												宝贝在路上
											</c:when>
											<c:otherwise>
												已收货
											</c:otherwise>
										</c:choose></td>
									<td rowspan="${fn:length(order.list)}" class="delete"><c:choose>
											<c:when test="${order.type == 0 }">
												<a href="orderOperation?op=rec&orderid=${order.orderID}"><b>确认收货</b></a>
											</c:when>
											<c:otherwise>
												<a href="orderOperation?op=del&orderid=${order.orderID}"><b>删除订单</b></a>
											</c:otherwise>
										</c:choose></td>
								</c:if>
							</tr>
						</c:forEach>
					</c:forEach>
				</table>

			</form>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2016 上海海文 All Rights Reserved.
	</div>
</body>
</html>
