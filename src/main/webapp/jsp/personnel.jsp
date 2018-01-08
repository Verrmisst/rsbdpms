<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../css/single.css" />
		<script type="text/javascript" src="../js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="../js/rstp.js" ></script>
		<title>人事调配</title>
	</head>
	<body>
		<div class="single">
			<div class="top">
				<h3>人事调配</h3>
				<input id="plcz" type="button" value="批量操作"/>
				<form class="ssk" id="ssk">
					<input type="text" placeholder="请输入员工编号"/>
					<button id="ss" type="button">搜索</button>
				</form>
			</div>
			<div class="bottom">
				<form>
					<div class="inp">
						<table>
							<tr class="tr">
								<th><input id="checkboxs" type="checkbox"></th>
								<th>员工编号</th>
								<th>姓名</th>
								<th>科室</th>
								<th>勤务</th>
							</tr>
							<tr>
								<td><input class="checkbox" type="checkbox"></td>
								<td>xxxxxx1</td>
								<td>xxx</td>
								<td class="td">
									<input type="text" class="xx ks"/>
								</td>
								<td>
									<input type="text" class="xx qw" />
								</td>
							</tr>
						</table>
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
