<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="p_category">
	<h2>商品分类</h2>


	<c:set var="categoryInfo" value=""></c:set>

	<c:forEach items="${requestScope.Category}" var="c">
		<dl>
			<dt>
				<a href="category">${c.categoryName}</a>
			</dt>
			<c:forEach items="${c.list}" var="child">
				<dd>
					<a href="category">${child.categoryName}</a>
				</dd>
			</c:forEach>
		</dl>
	</c:forEach>


</div>

