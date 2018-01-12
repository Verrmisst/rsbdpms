<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="css/login.css" />
<title>RSB-Login</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	//前台校验，控制表单提交，若用户名和密码为空则不能提交表单

	var unmReq = false;//用户名必填
	var pwdReq = false;//密码必填

	$(function() {

		//控制表单提交
		$("form").submit(function() {

			var unm = $("#unm").val();
			var pwd = $("#pwd").val();

			if (unm.length != 0 && unm != "") {
				unmReq = true;
			}

			if (pwd.length != 0 && pwd != "") {
				pwdReq = true;
			}

			if (unmReq && pwdReq) {

			} else {
				alert("请输入用户名或者密码");
			}

			return unmReq && pwdReq;
		});

	});
</script>
<body>

	<div class="warp">
		<div class="header"></div>
		<div class="headert"></div>
		<div class="dl">
			<div class="top">
				<h3>宿舍管理系统登录</h3>
			</div>
			<div class="bottom">
				<span style="font-size: 15px;color:red;">${message}</span> 
				<span style="font-size: 15px;color:red;">${requestScope.info}</span> 
				<span style="font-size: 15px;color:red;"><s:property value="#errormessage"/></span>
				<span style="font-size: 15px;color:red;"><s:property value="#information"/></span>
				<span style="font-size: 15px;color:red;">${infomation}</span>
				<form action="loginvalidate" method="post">
					账号：<input type="text" name="username" id="unm" /><br /> 密码：<input
						type="password" name="password" id="pwd" /><br /> <input
						type="submit" value="登录" id="sub" /> <input type="reset"
						value="重置" id="rst"/>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
