<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>天小猫 - 注册页</title>
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

</head>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>欢迎注册天小猫</h1>
				<ul class="steps clearfix">
					<li class="current"><em></em>填写注册信息</li>
					<li class="last"><em></em>注册成功</li>
				</ul>
				<form id="regForm" method="post" action="user/UserServlet"
					onsubmit="return checkForm(this)">
					<!-- 使用隐藏域，传递一个键值对到后台，判断是注册、登陆登操作 -->
					<input type="hidden" value="reg" name="op">
					<table>
						<!-- <div id="error">错误信息</div> -->
						<tr>
							<td class="field">用户名：</td>
							<td><input id="userName" class="text" type="text"
								name="userName" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" maxlength="15" /><span id="uName"></span></td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="password" id="passWord"
								name="passWord" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">确认密码：</td>
							<td><input class="text" type="password" name="rePassWord"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">性别：</td>
							<td><input type="radio" name="sex" style="border: 0px;"
								checked="checked" value="0" />男<input type="radio" name="sex"
								style="border: 0px;" value="1" />女<span></span></td>
						</tr>
						<tr>
							<td class="field">出生日期：</td>
							<td><input class="text" type="text" name="birthday"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">身份证：</td>
							<td><input class="text" type="text" name="identity"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">电子邮件：</td>
							<td><input class="text" type="text" name="email"
								onfocus="FocusItem(this)" onblur="CheckItem(this);"
								onmouseout="checkEmail()" /><span id="uemail"></span></td>
						</tr>
						<tr>
							<td class="field">手机：</td>
							<td><input class="text" type="text" name="mobile"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">地址：</td>
							<td><input class="text" type="text" name="address"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">验证码：</td>
							<td><input class="text verycode" type="text" name="veryCode"
								onfocus="FocusItem(this)" onblur="CheckItem(this);"
								maxlength="4" /><img id="veryCode" src="code.jsp" /><span
								id="Code"></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit"
									name="submit" value="提交注册" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2017 天小猫 All Rights Reserved.
		桂ICP证1000001号</div>
</body>
</html>

