<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

		<link rel="stylesheet" href="css/single.css" />
		<script type="text/javascript" src="js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="js/ygtb.js" ></script>
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
						<c:forEach items="${notifices}" var="n">
							<tr>
								<td>${n.staff.empCode}</td>
								<td>${n.staff.empName}</td>
								<td>${n.staff.dept.dictName}</td>
								<td>${n.staff.buildingName}</td>
								<td>${n.staff.roomCode}</td>
								<td>${n.notificeType}</td>
								<td>${n.notificeTime}</td>
								<td>${n.notificeReason}</td>
								<td>${n.notificeMoney}</td>
							</tr>
							</c:forEach>
						</table>
						<br /> <br />
				<center>
					<c:if test="${recordCount>15}">
					<!-- 首页 -->
					<a href="shownotifice?pageNum=0">首页</a>
					<c:if test="${pageNum>0}">
						<a href="shownotifice?pageNum=${pageNum-1}">上一页</a>
					</c:if>

					<c:if test="${pageNum<pageCount-1}">
						<a href="shownotifice?pageNum=${pageNum+1}">下一页</a>
					</c:if>

					<!-- 最后一页 -->
					<a href="shownotifice?pageNum=${pageCount-1}">末页</a>
					&nbsp;&nbsp;&nbsp; 第${pageNum+1}页/共${pageCount}页&nbsp;&nbsp;&nbsp;${recordCount}条记录
					</c:if>
				</center>
</div>