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
			<h3  style="font-size: 20px;">宿舍调配</h3>
			<form class="ssk" id="ssk" action="showstaffdorm">
				<input type="text" placeholder="请输入员工编号" name="staffCode"/>
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
						<c:forEach items="${staffs}" var="s">
						<tr>
						
							<td>
							${s.empCode}
							</td>
							<td>${s.empName}</td>
							<td>${s.gender}</td>
							<td>
							${s.dept.dictName}
							</td>
							<td>
							 ${s.duty.dictName}
							</td>
							<td>
							${s.buildingName}
							</td>
							<td>
							${s.roomCode}
							</td>
							<td>
							  ${s.bedNum}
							</td>
							<td>
								${s.wardrobeNum}
							</td>
							<td>
                               ${s.deskNum}
							</td>
							<td>
								${s.shopboxNum}
							</td>
							<td>
								${s.livingDate}
							</td>
							<td>
							
							<a href="checkout.action?staffCode=${s.empCode}" id="acheckout">退宿</a>
							<a href="showexchange.action?staffCode=${s.empCode}" class="tss">调宿</a></td>

						</tr>
						</c:forEach>
					</table>
					<br /> 
					<br /> 
					<center>
					<!-- 首页 -->
					<a href="showpagingdorm?pageNum=0">首页</a>
					<c:if test="${pageNum>0}">
						<a href="showpagingdorm?pageNum=${pageNum-1}">上一页</a>
					</c:if>
					
					<c:if test="${pageNum<pageCount-1}">
						<a href="showpagingdorm?pageNum=${pageNum+1}">下一页</a>
					</c:if>
					
					<!-- 最后一页 -->
					<a href="showpagingdorm?pageNum=${pageCount-1}">末页</a> &nbsp;&nbsp;&nbsp;

					<span style="font-size:16px;color: black">第${pageNum+1}页/共${pageCount}页&nbsp;&nbsp;&nbsp;${recordCount}条记录</span>
					
					</center>
				</div>
		</div>
	</div>
</body>
</html>
