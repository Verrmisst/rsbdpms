<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/single.css" />
		<script type="text/javascript" src="js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="js/ygjy.js" ></script>
		<title>员工借用</title>
	</head>
	<body>
		<div class="single">
			<div class="top">
				<h3>员工借用</h3>
				<input id="tjjy" type="button" value="添加借用"/>
				<form class="ssk" id="ssk">
					<input type="text" placeholder="请输入员工编号！！！"/>
					<button id="ss" type="button">搜索</button>
				</form>
			</div>
			<div class="bottom">
				<form>
					<div class="inp">
						<table id="tab">
							<tr class="tr">
								<th>员工编号</th>
								<th>姓名</th>
								<th>科室</th>
								<th>宿舍楼</th>
								<th>房间号</th>
								<th>借用物品</th>
								<th>借用时间</th>
								<th>归还日期</th>
								<th>操作</th>
							</tr>
							<tr>
								<td>12345</td>
								<td>张三</td>
								<td>卫报公司</td>
								<td>闻博轩</td>
								<td>205</td>
								<td>xxxxxx</td>
								<td>2017/12/23</td>
								<td><input type="date" class="xx" /></td>
								<td><button type="submit">归还</button></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
