<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript">

	$("#firstpage").click(function() {
			$.ajax({
				url : "pageblurstaff",
				async : true,
				type : 'post',
				data : {
					'pageNumg' : 0
				},
				success : function(data) {
					$("#inp").empty();
					$("#inp").append(data);
				}

			});

		});

		$("#previouspage").click(function() {
			var pagenum = $("#pgNumg").val();
			
			$.ajax({
				url : "pageblurstaff",
				async : true,
				type : 'post',
				data : {
					'pageNumg' : --pagenum
				},
				success : function(data) {
					
					$("#inp").empty();
					$("#inp").append(data);
				}

			});

		});

		$("#nextpage").click(function() {
			var pagenum = $("#pgNumg").val();
			$.ajax({
				url : "pageblurstaff",
				async : true,
				type : 'post',
				data : {
					'pageNumg' : ++pagenum 
				},
				success : function(data) {
					
					$("#inp").empty();
					$("#inp").append(data);
				}

			});
			
		});

		$("#lastpage").click(function() {
			var pagecount = $("#pgCountg").val();
			$.ajax({
				url : "pageblurstaff",
				async : true,
				type : 'post',
				data : {
					'pageNumg' : --pagecount
				},
				success : function(data) {
					$("#inp").empty();
					$("#inp").append(data);
				}

			});
		});
</script>
<input type="hidden" id="pgNumg" value="${pageNumg}" />
<input type="hidden" id="pgCountg" value="${pageCountg}" />
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
					<c:forEach items="${uploadStaffs}" var="us" varStatus="v">
						<tr>
							<td>${us.empCode}</td>
							<td>${us.empName}</td>
							<td>${us.gender}</td>
							<td>${us.dept.dictName}</td>
							<td>${us.duty.dictName}</td>
							<td>${us.buildingName}</td>
							<td>${us.roomCode}</td>
							<td>${us.bedNum}</td>
							<td>${us.wardrobeNum}</td>
							<td>${us.deskNum}</td>
							<td>${us.shopboxNum}</td>
							<td>${us.livingDate}</td>
							<td>${us.exchangeDate}</td>
							<td><a
								href="checkout.action?staffCode=${us.empCode}&roomCode=${us.roomCode}&buildName=${us.buildingName}"
								id="checkout">退宿</a> <a
								href="showexchange.action?staffCode=${us.empCode}" class="tss">调宿</a>
							</td>
				
						</tr>
					</c:forEach>
				</table>
					<br/><br/>
					<center>
					<c:if test="${recordCountg>13}">
						<!-- 首页 -->
						<a id="firstpage">首页</a>
						<c:if test="${pageNumg>0}">
							<a id="previouspage">上一页</a>
						</c:if>

						<c:if test="${pageNumg<pageCountg-1}">
							<a id="nextpage">下一页</a>
						</c:if>

						<!-- 最后一页 -->
						<a id="lastpage">末页</a> &nbsp;&nbsp;&nbsp;

					<span style="font-size:16px;color: black">第${pageNumg+1}页/共${pageCountg}页&nbsp;&nbsp;&nbsp;${recordCountg}条记录</span>
					</c:if>
				</center>