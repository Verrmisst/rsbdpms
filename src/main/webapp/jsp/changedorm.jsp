<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript">

$("#checkout").click(function() {

			var flag = confirm("确认退宿吗?");

			if (flag == true) {

				alert("办理成功");
				window.location.reload();
			}

			window.location.reload();
		});

</script>
<table id="tab">
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
						<th>操作</th>
					</tr>
					<tr>
					</tr>
					<c:forEach items="${staffs}" var="s" varStatus="v">
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
							<td><a
								href="checkout.action?staffCode=${s.empCode}&roomCode=${s.roomCode}&buildName=${s.buildingName}"
								id="checkout">退宿</a> <a
								href="showexchange.action?staffCode=${s.empCode}" class="tss">调宿</a>
							</td>

						</tr>
					</c:forEach>
				</table>
				<br /> <br /> <input type="hidden" id="pgNum" value="${pageNum}" />
				<input type="hidden" id="pgCount" value="${pageCount}" />
				<center>
					<c:if test="${recordCount>13}">
						<!-- 首页 -->
						<a href="showorigindorm?pageNum=0" id="firstpage">首页</a>
						<c:if test="${pageNum>0}">
							<a href="showorigindorm?pageNum=${pageNum-1}" id="previouspage">上一页</a>
						</c:if>

						<c:if test="${pageNum<pageCount-1}">
							<a href="showorigindorm?pageNum=${pageNum+1}" id="nextpage">下一页</a>
						</c:if>

						<!-- 最后一页 -->
						<a href="showorigindorm?pageNum=${pageCount-1}" id="lastpage">末页</a> &nbsp;&nbsp;&nbsp;

					<span style="font-size:16px;color: black">第${pageNum+1}页/共${pageCount}页&nbsp;&nbsp;&nbsp;${recordCount}条记录</span>
					</c:if>
				</center>