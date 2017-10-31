<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="hot_sale">
	<h2>热卖推荐</h2>
	<ul>
		<c:if test="">
			<c:forEach items="" var="p" end="4">
				<li>
					<dl>
						<dt>
							<a href="pview" target="_self"><img
								src="" /></a>
						</dt>
						<dd class="p_name">
							<a href="pview" target="_self"></a>
						</dd>
						<dd class="price">￥</dd>
					</dl>
				</li>
			</c:forEach>
		</c:if>
	</ul>
</div>
