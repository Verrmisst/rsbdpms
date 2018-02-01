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
<title>静雅苑</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3>静雅苑</h3>
			<input id="tjss" type="button" value="添加宿舍" style="margin-top: 10px"/>
			<form class="ssk" id="ssk" action="singleroom.action?buildId=2">
				<input type="text" placeholder="请输入房间编号" name="roomCode" />
				<input type="hidden" name="buildId" value="2"/>
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
						<th>分类</th>
						<th>备注1</th>
						<th>备注2</th>
						<th>备注3</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${rooms}" var="r">
						<form action="changeroomset.action" method="post">
							<tr>
								<td>静雅苑</td>
								<td>${r.roomCode}</td>
								<td><input type="text" class="xx" value="${r.size}"
									style="text-align: center;" name="size" readonly="readonly"/></td>
								<td>${r.occupy}</td>
								<td><input type="text" class="xx" placeholder="${r.classify}"
									style="text-align: center;" name="classify"/></td>
								<td><input type="text" class="xx" placeholder="${r.content1}"
									style="text-align: center;" name="content1"/></td>
								<td><input type="text" class="xx" placeholder="${r.content2}"
									style="text-align: center;" name="content2"/>
								</td>
								<td><input type="text" class="xx" placeholder="${r.content3}"
									style="text-align: center;" name="content3"/>
									<input type="hidden" name="buildId" value="1"/>
									<input type="hidden" name="roomCode" value="${r.roomCode}"/>
								</td>
								<td><button type="submit">修改</button></td>

							</tr>
						</form>
					</c:forEach>
				</table>
				<br /> <br />
				<center>
					<c:if test="${recordCount>10}">
					<!-- 首页 -->
					<a href="builddorm?pageNum=0&buildId=2">首页</a>
					<c:if test="${pageNum>0}">
						<a href="builddorm?pageNum=${pageNum-1}&buildId=2">上一页</a>
					</c:if>

					<c:if test="${pageNum<pageCount-1}">
						<a href="builddorm?pageNum=${pageNum+1}&buildId=2">下一页</a>
					</c:if>

					<!-- 最后一页 -->
					<a href="builddorm?pageNum=${pageCount-1}&buildId=2">末页</a>
					&nbsp;&nbsp;&nbsp; 第${pageNum+1}页/共${pageCount}页&nbsp;&nbsp;&nbsp;${recordCount}条记录
					</c:if>
				</center>

			</div>
		</div>
	</div>
</body>
</html>
