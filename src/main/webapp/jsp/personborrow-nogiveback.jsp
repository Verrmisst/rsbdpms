<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <link rel="stylesheet" href="css/single.css" /> -->
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
				<th>操作</th>
			</tr>
			<c:forEach items="${noGiveBacks}" var="n">
				<tr>
					<td>${n.staff.empCode}</td>
					<td>${n.staff.empName}</td>
					<td>${n.staff.dept.dictName}</td>
					<td>${n.staff.buildingName}</td>
					<td>${n.staff.roomCode}</td>
					<td>${n.objectName}</td>
					<td>${n.beginDate}</td>
					<td><input type="date" class="xx" name="endDate"
						id="returndate" /> <input type="hidden" name="borrowId"
						value="${n.id}" id="returnhid" /></td>
					<td><button id="returnback">归还</button></td>
				</tr>
			</c:forEach>
		</table>
	<br/>

	<center>
		<c:if test="${recordCount>5}">
			<!-- 首页 -->
			<a href="showborrow?pageNum=0">首页</a>
			<c:if test="${pageNum>0}">
				<a href="showborrow?pageNum=${pageNum-1}">上一页</a>
			</c:if>

			<c:if test="${pageNum<pageCount-1}">
				<a href="showborrow?pageNum=${pageNum+1}">下一页</a>
			</c:if>

			<!-- 最后一页 -->
			<a href="showborrow?pageNum=${pageCount-1}">末页</a> &nbsp;&nbsp;&nbsp;

					<span style="font-size:16px;color: black">第${pageNum+1}页/共${pageCount}页&nbsp;&nbsp;&nbsp;${recordCount}条记录</span>
		</c:if>
	</center>

</div>
</div>