<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/single.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/ygjy.js"></script>
<script type="text/javascript">
	//ajax局部刷新
	$(function() {

		var nogbpn = $("#nogbhidpn").val();
		var nogbpc = $("#nogbhidpc").val();
		var gbpn = $("#gbhidpn").val();
		var gbpc = $("#gbhidpc").val();

		$.get("nogiveback", {
			pageNum : nogbpn,
			pageCount : nogbpc
		}, function(data) {
			$("#nogb").html(data);
		});

		$.get("giveback", {
			pageNumg : gbpn,
			pageCountg : gbpc
		}, function(data) {
			$("#gb").html(data);
		});
	});
</script>

<title>员工借用</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3>员工借用</h3>
			<input id="tjjy" type="button" value="添加借用" style="margin-top: 10px"/>
			<form class="ssk" id="ssk" action="searchborrow" method="post" >
				<input type="text" placeholder="请输入员工编号" name="staffCode"/>
				<button id="ss" type="submit" >搜索</button>
			</form>
		</div>
		<input type="hidden" id="nogbhidpn" value="${pageNum}" /> <input
			type="hidden" id="nogbhidpc" value="${pageCount}" /> <input
			type="hidden" id="gbhidpn" value="${pageNumg}" /> <input
			type="hidden" id="gbhidpc" value="${pageCountg}" />
		<div class="bottom">
			<div id="nogb" style="position: absolute;left: 0;right: 0;top: 50px;bottom: 0;margin: auto;width: 1005px;height: ;"></div>
			<div style="position: absolute;left: 0;right: 0;top: 90px;bottom: 0;margin: auto;width: 1000px;height: 35px;">
				<hr />
			</div>
			<div id="gb" style="position: absolute;left: 0;right: 0;top: 100px;bottom: 0;margin: auto;width: 1005px;height: 35px;"></div>
		</div>
	</div>
</body>
</html>
