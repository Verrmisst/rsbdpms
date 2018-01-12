<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/single.css" />
<link rel="stylesheet" href="css/reset.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/sstp.js"></script>
<title>宿舍调配</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3 style="font-size: 20px;">宿舍调配</h3>
			<form class="ssk" id="ssk" action="showstaffdorm">
				<input type="text" placeholder="请输入员工编号"  name="staffCode"/>
				<button id="ss" type="submit">搜索</button>
			</form>
		</div>
		<div class="bottom">
				<div class="inp" id="inp">
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
							<th>入住日期</th>
							<th>操作</th>
						</tr>
						<tr>
						</tr>
						
						<tr>
							<td>
							${staff.empCode}
							</td>
							<td>${staff.empName}</td>
							<td>${staff.gender}</td>
							<td>
							${staff.dept.dictName}
							</td>
							<td>
							${staff.duty.dictName}
							</td>
							<td>
							${staff.buildingName}
							</td>
							<td>
							${staff.roomCode}
							</td>
							<td>
							  ${staff.bedNum}
							</td>
							<td>
								${staff.wardrobeNum}
							</td>
							<td>
                                ${staff.deskNum}
							</td>
							<td>
								${staff.shopboxNum}
							</td>
							<td>
								${staff.livingDate}
							</td>
							<td>
								<a href="checkout.action?staffCode=${staff.empCode}" id="acheckout">退宿</a>
								<a href="showexchange.action?staffCode=${staff.empCode}" class="tss">调宿</a></td>
						</tr>
					</table>
					<br /> 
					<br /> 
				</div>
			</div>
	</div>
</body>
</html>
