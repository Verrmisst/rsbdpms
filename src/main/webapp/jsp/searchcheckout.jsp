<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				<table>
					<tr class="tr">
						<th>员工编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>科室</th>
						<th>勤务</th>
						<th>宿舍楼</th>
						<th>房间号</th>
						<th>床号</th>
						<th>衣柜号</th>
						<th>桌柜号</th>
						<th>鞋柜号</th>
						<th>入住时间</th>
						<th>调宿时间</th>
						<th>退宿时间</th>
					</tr>
					<tr>
					</tr>
					<c:forEach items="${staffs}" var="s">
						<tr>
							<td>${s.empCode}</td>
							<td>${s.empName}</td>
							<td>${s.gender}</td>
							<td>${s.dept.dictName}</td>
							<td>${s.duty.dictName}</td>
							<td>${s.buildingName}</td>
							<td>${s.roomCode}</td>
							<td>${s.bedNum}</td>
							<td>${s.wardrobeNum}</td>
							<td>${s.deskNum}</td>
							<td>${s.shopboxNum}</td>
							<td>${s.livingDate}</td>
							<td>${s.exchangeDate}</td>
							<td>${s.checkOutDate}</td>
						</tr>
					</c:forEach>
				</table>
		<div>
			<a href="download.action">退宿人员信息下载（筛选后）</a>
		</div>