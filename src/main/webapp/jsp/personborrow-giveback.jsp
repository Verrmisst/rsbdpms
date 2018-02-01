<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link rel="stylesheet" href="css/single.css" /> 
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/ygjy.js"></script>

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
			<c:forEach items="${giveBacks}" var="g">
				<tr>
					<td>${g.staff.empCode}</td>
					<td>${g.staff.empName}</td>
					<td>${g.staff.dept.dictName}</td>
					<td>${g.staff.buildingName}</td>
					<td>${g.staff.roomCode}</td>
					<td>${g.objectName}</td>
					<td>${g.beginDate}</td>
					<td>${g.endDate}</td>
					<td>${g.content}</td>
				</tr>
			</c:forEach>
		</table>
	<br/>
	<center>
		<c:if test="${recordCountg>5}">
			<!-- 首页 -->
			<a href="showborrow?pageNumg=0">首页</a>
			<c:if test="${pageNumg>0}">
				<a href="showborrow?pageNumg=${pageNumg-1}">上一页</a>
			</c:if>

			<c:if test="${pageNumg<pageCountg-1}">
				<a href="showborrow?pageNumg=${pageNumg+1}">下一页</a>
			</c:if>

			<!-- 最后一页 -->
			<a href="showborrow?pageNumg=${pageCountg-1}">末页</a> &nbsp;&nbsp;&nbsp;
					<span style="font-size:16px;color: black">第${pageNumg+1}页/共${pageCountg}页&nbsp;&nbsp;&nbsp;${recordCountg}条记录</span>
		</c:if>
	</center>
	</div>
</div>