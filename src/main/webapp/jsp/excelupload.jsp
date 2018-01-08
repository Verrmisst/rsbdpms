<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/single.css" />
		<script type="text/javascript" src="js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="js/excel.js" ></script>
		<title>Excel导入</title>
	</head>
	<body>
		<div class="single">
			<div class="top">
				<h3>Excel导入</h3>
			</div>
			<div class="bottom">
				<form>
					<div class="inp">
						<div>
							<input id="wj" type="file" style="background: white; margin-left: 20px;"/>
						</div>
					</div>
					<div class="btn">
						<button type="submit" id="sub" class="sub">提交</button>
						<button type="reset" class="res">重置</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
