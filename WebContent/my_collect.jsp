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
		您现在的位置：<a href="ProductServlet">亚马逊</a> &gt; 我的收藏
	</div>
	<div class="wraporder">
		<div id="shopping">
			<form action="" method="post">

				<table id="oderview">
					<tr>
						<th>商品名称</th>
						<th>商品单价</th>
						<th>商品库存</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${sessionScope.list}" var="product">
						<tr id="product_id_1">
							<td class="thumb"><img style="width: 100px; height: 100px;"
								src="${product.fileName }" /><a href="pview?id=${product.productID}">${product.productName}</a></td>
							<td class="price">￥<span>${product.price}</span>
							</td>
							<td class="number"><span>${product.stock}</span></td>
							<td class="delete"><a href="cancel?id=${product.productID}"><b>取消收藏</b></a></td>
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
