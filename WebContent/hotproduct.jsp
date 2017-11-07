<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="hot_sale">
	<h2>热卖推荐</h2>
	<ul>
		<c:if test="${sessionScope.hotSale.size() > 0 }">
			<c:forEach items="${sessionScope.hotSale}" var="p" end="4">
				<c:forEach items="${p.list }" var="product">
					<li>
						<dl>
							<dt>
								<a href="pview?id=${product.productID }" target="_self"><img
									src="${product.fileName }" /></a>
							</dt>
							<dd class="p_name">
								<a href="pview?id=${product.productID }" target="_self">${product.productName }</a>
							</dd>
							<dd class="price">￥${product.price }</dd>
						</dl>
					</li>
				</c:forEach>
			</c:forEach>
		</c:if>
	</ul>
</div>
