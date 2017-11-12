<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>天小猫 - 产品显示</title>
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
<script type="text/javascript" src="scripts/product_view.js"></script>


</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">
		<c:set value="${requestScope.product}" var="s"></c:set>
		您现在的位置：<a href="index.jsp">天小猫</a> &gt; <a
			href="category?cate=max&hpc_parent_id=${s.categoryID.categoryID}">${s.categoryID.categoryName }</a>
		&gt; <a href="category?cate=min&hpc_id=${s.childID.childID}">${s.childID.categoryName }</a>&gt;${s.productName}
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
		</div>
		<div id="product" class="main">
			<c:set var="p" value="${requestScope.product}"></c:set>
			<h1>商品名称:${p.productName}</h1>
			<div class="infos">
				<div class="thumb">
					<img style="width: 100px; height: 100px;" src="${p.fileName}" />
				</div>


				<div class="buy">
					<p>
						商城价：<span class="price">￥${p.price}</span>
					</p>
					<c:choose>
						<c:when test="${p.stock > 0}">
							<p>
								库 存：<span id="stock">${p.stock}</span>(有货)
							</p>
						</c:when>
						<c:otherwise>
							<p>库 存：无货
						</c:otherwise>
					</c:choose>
					<input type="button" id="minus" value=" - " width="3px"
						onclick="minus();"> <input type="text" id="count"
						name="count" onblur="checkStock()" value="1" maxlength="5"
						size="1" style="text-align: center; vertical-align: middle">
					<input type="button" id="add" value=" + " width="2px"
						onclick="add();">
					<c:choose>
						<c:when test="${sessionScope.user.username == null }">
							<div class="button">
								<input type="button" name="button" value="" onclick="remaind();"
									style="background: url(images/buyNow.png)" /> <input
									type="image" name="imageField" src="images/cartbutton.png"
									onclick="remaind()" />
							</div>

						</c:when>
						<c:otherwise>
							<div class="button">
								<input type="button" name="button" value=""
									onclick="goingToBuy(${p.productID });"
									style="background: url(images/buyNow.png)" /> <input
									type="image" name="imageField" src="images/cartbutton.png"
									onclick="addToCart(${p.productID });" />
							</div>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="collect">
					<c:choose>
						<c:when test="${p.status == 0 }">
							<img src="images/shoucang2.png">
							<a href="collect?op=ok&id=${p.productID}">收藏</a>
						</c:when>
						<c:otherwise>
							<img src="images/shoucang1.png">
							<a href="collect?op=no&id=${p.productID}">取消收藏</a>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
					商品名字：${p.productName}<br /> 商品描述：${p.description}<br />
					商品价格：￥${p.price}<br /> 商品库存：${p.stock}<br />
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2017 天小猫 All Rights Reserved.桂ICP证1000001号
	</div>
</body>
</html>

