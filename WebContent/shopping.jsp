<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>天小猫- 购物车</title>
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
</style>
</head>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">天小猫</a> &gt; 购物车
	</div>
	<div class="wrap">
		<div id="shopping">
			<form action="doBuy" method="post">
				<table>
					<tr>
						<th><input type="checkbox" name="qx" id="ischeck" />全选</th>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>购买数量</th>
						<th>操作</th>
					</tr>

					<!-- 根据用户购物车生成列表 -->
					<c:forEach items="${requestScope.cart}" var="shopping">
						<tr id="product_id_1">
							<!-- 根据购物车的ID来做复选框的ID -->
							<td><input type="checkbox" name='cb' id="cb" value="${shopping.cartID}"
								onclick="setSelectAll()" style="margin-left: 55px;" /></td>
							<c:set var="product" value="${shopping.product}"></c:set>
							<td class="thumb"><img style="width: 100px; height: 100px;"
								src="${product.fileName}" /><a
								href="pview?id=${product.productID}">${product.productName}</a></td>
							<td class="price" id="price_id_1">￥${product.price}<span
								id="span_1"></span> <input type="hidden" id="subPrice"
								value="${product.price }" name="sumPrice" /> <input
								type="hidden" value="${product.productID}" name="pId" /> <input
								type="hidden" value="${product.stock}" name="hpStock"
								id="hpStock${shopping.cartID}" />

							</td>
							<td class="number"><c:set var="hcid"
									value="${shopping.cartID }"></c:set> <input type="button"
								id="minus" value=" - " width="3px" onclick=" reduce(${hcid})"
								name="minusButton"> <input id="${hcid }" type="text"
								name="number" value="${shopping.quantity}" maxlength="5"
								size="1" style="text-align: center; vertical-align: middle"
								onblur="checkStock(${hcid})" /> <input type="button" id="add"
								value=" + " width="2px" onclick=" increase(${hcid})"
								name="addButton"></td>
							<td class="delete"><a
								href="deleteCart?cid=${shopping.cartID}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="button">
					<input type="submit" value="" />
				</div>
			</form>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2017 天小猫 All Rights Reserved.桂ICP证1000001号
	</div>
</body>
</html>

