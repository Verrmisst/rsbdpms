<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../css/single.css" />
		<script type="text/javascript" src="../js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="../js/ygtb.js" ></script>
		<title>员工通报</title>
	</head>
	<body>
		<div class="single">
			<div class="top">
				<h3>员工通报</h3>
				<input id="tjtb" type="button" value="添加通报"/>
				<form class="ssk" id="ssk">
					<input type="text" placeholder="请输入员工编号！！！"/>
					<button id="ss" type="button">搜索</button>
				</form>
			</div>
			<div class="bottom">
				<form>
					<div class="inp">
						<table>
							<tr class="tr">
								<th>员工编号</th>
								<th>姓名</th>
								<th>科室</th>
								<th>宿舍楼</th>
								<th>房间号</th>
								<th>通报类型</th>
								<th>通报时间</th>
								<th>通报原因</th>
								<th>处罚金额</th>
							</tr>
							<tr>
								<td>xxxxx</td>
								<td>xxx</td>
								<td>微博公司</td>
								<td>静雅苑</td>
								<td>406</td>
								<td>卫生</td>
								<td>2017/12/24</td>
								<td>卫生及格</td>
								<td>50元</td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
