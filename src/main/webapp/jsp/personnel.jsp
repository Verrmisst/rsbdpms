<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/single.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/rstp.js"></script>
<title>人事调配</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3>人事调配</h3>
			<form class="ssk" id="ssk" action="showstaff" method="post">
				<input type="text" placeholder="请输入员工编号" name="empCode" />
				<button id="ss" type="submit">搜索</button>
			</form>
		</div>
		<iframe id="iframe"
			style="width: 1036px; height: 446px; border: none; " src=""></iframe>
	</div>
</body>
</html>
