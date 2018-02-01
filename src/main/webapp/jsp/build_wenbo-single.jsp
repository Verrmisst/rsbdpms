<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/single.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/wbjy.js"></script>
<title>闻博轩</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3>闻博轩</h3>
			<input id="tjss" type="button" value="添加宿舍" style="margin-top: 10px"/>
			<form class="ssk" id="ssk" action="singleroom.action?buildId=1">
				<input type="text" placeholder="请输入房间编号" name="roomCode" />
				<input type="hidden" name="buildId" value="1"/>
				<button id="ss" type="submit">搜索</button>
			</form>
			
		</div>
			<div class="bottom">
				<div class="inp" id="div">
					<table>
						<tr class="tr">
							<th>宿舍楼</th>
							<th>房间号</th>
							<th>房间人数</th>
							<th>实际人数</th>
							<th>剩余空床号</th>
							<th>分类</th>
							<th>备注1</th>
							<th>备注2</th>
							<th>备注3</th>
							<th>操作</th>
						</tr>
						<form action="changeroomset.action" method="post" >
							<tr>
								<td>闻博轩</td>
								<td>${room.roomCode}</td>
								<td><input type="text" class="xx" value="${room.size}"
									style="text-align: center;" name="size" readonly="readonly"/></td>
								<td>${room.occupy}</td>
								<td>${surplusGoods}</td>
								<td><input type="text" class="xx" placeholder="${room.classify}"
									style="text-align: center;" name="classify"/></td>
								<td><input type="text" class="xx" placeholder="${room.content1}"
									style="text-align: center;" name="content1"/></td>
								<td><input type="text" class="xx" placeholder="${room.content2}"
									style="text-align: center;" name="content2"/>
								</td>
								<td><input type="text" class="xx" placeholder="${room.content3}"
									style="text-align: center;" name="content3"/>
									<input type="hidden" name="buildId" value="1"/>
									<input type="hidden" name="roomCode" value="${room.roomCode}"/>
								</td>
								<td><button type="submit">修改</button></td>

							</tr>
						</form>
					</table>
				</div>

			</div>
	</div>
</body>
</html>
