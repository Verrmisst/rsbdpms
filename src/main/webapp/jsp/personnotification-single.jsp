<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

		<link rel="stylesheet" href="css/single.css" />
		<script type="text/javascript" src="js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="js/ygtb.js" ></script>
		<title>员工通报</title>

		<div class="single">
			<div class="top">
				<h3>员工通报</h3>
				<input id="tjtb" type="button" value="添加通报" style="margin-top: 10px"/>
				<form class="ssk" id="ssk" action="searchnotifice" method="post">
					<input type="text" placeholder="请输入员工编号" name="staffCode"/>
					<button id="ss" type="submit">搜索</button>
				</form>
			</div>
			<div class="bottom">
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
					</div>
			</div>
		</div>

