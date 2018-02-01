<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/single.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/ygjy.js"></script>
<script type="text/javascript">
	$(function() {

		$("#returnback").click(function() {

			var borrowId = $("#returnhid").val();

			var endDate = $("#returndate").val();

			$.get("objectreturn", {
				borrowId : borrowId,
				endDate : endDate
			},

			function(data) {

				alert(data.text);

				window.location.reload();
			});
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
			<form class="ssk" id="ssk" action="searchborrow" method="post">
				<input type="text" placeholder="请输入员工编号" name="staffCode" />
				<button id="ss" type="submit" >搜索</button>
			</form>
		</div>
		<div class="bottom">
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
						<th>说明</th>
					</tr>
					<c:forEach items="${borrows}" var="b">
						<tr>
							<td>${b.staff.empCode}</td>
							<td>${b.staff.empName}</td>
							<td>${b.staff.dept.dictName}</td>
							<td>${b.staff.buildingName}</td>
							<td>${b.staff.roomCode}</td>
							<td>${b.objectName}</td>
							<td>${b.beginDate}</td>

							<c:choose>
								<c:when test="${b.flag eq 0}">
									<td><input type="date" class="xx" name="endDate"
										id="returndate" /> <input type="hidden" name="borrowId"
										value="${b.id}" id="returnhid" /></td>
									<td><button id="returnback">归还</button></td>
								</c:when>
								
								<c:otherwise>
										<td>${b.endDate}</td>
										<td>${b.content}</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br />
			<center>
				<c:if test="${recordCount>10}">
					<!-- 首页 -->
					<a href="searchborrow?pageNum=0">首页</a>
					<c:if test="${pageNum>0}">
						<a href="searchborrow?pageNum=${pageNum-1}">上一页</a>
					</c:if>

					<c:if test="${pageNum<pageCount-1}">
						<a href="searchborrow?pageNum=${pageNum+1}">下一页</a>
					</c:if>

					<!-- 最后一页 -->
					<a href="searchborrow?pageNum=${pageCount-1}">末页</a> &nbsp;&nbsp;&nbsp;

					<span style="font-size:16px;color: black">第${pageNum+1}页/共${pageCount}页&nbsp;&nbsp;&nbsp;${recordCount}条记录</span>
				</c:if>
			</center>

		</div>
	</div>
</body>
</html>
