<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/single.css" />
<link rel="stylesheet" href="css/reset.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/sstp.js"></script>
<script type="text/javascript">
	$(function() {

		
		$("#ssk").submit(function(){
			
			var staffcode = $("#ssk input")[0].value;
					var staffname = $("#ssk input")[1].value;
					var roomcode = $("#ssk input")[2].value;
					var buildname = $("#ssk select")[0].value;
					var dept = $("#ssk select")[1].value;
					var duty = $("#ssk select")[2].value;
					var bd = $("#datetimeBegin").val();
					var ed = $("#datetimeEnd").val();

					if (staffcode == "" && staffname == "" && roomcode == ""
							&& buildname == "" && dept == "" && duty == ""
							&& bd == "" && ed == "") {
						alert("请至少填写一个搜索项");
						return false;
					}
					
					
			
		});
		
		
		$("#checkout").click(function() {

			var flag = confirm("确认退宿吗?");

			if (flag == true) {

				alert("办理成功");
				window.location.reload();
			}

			window.location.reload();
		});
		
	

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
			var pagenum = $("#pgNum").val();
			
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
			var pagenum = $("#pgNum").val();
			
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
			var pagecount = $("#pgCount").val();
			$.ajax({
				url : "pageblurstaff",
				async : true,
				type : 'post',
				data : {
					'pageNumg' : ++pagecount
				},
				success : function(data) {
					$("#inp").empty();
					$("#inp").append(data);
				}

			});
		});

	});
</script>
<title>宿舍调配</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3 style="font-size: 20px;">宿舍调配</h3>
			<form class="ssk" id="ssk" action="showblurstaff" method="post"> 
				<font size="2.5px">员工编号：</font>
				<input type="text" placeholder="" name="staffCode"
					id="staffcode" style="height:20px"/> 
					&nbsp;&nbsp;
					<font size="2.5px">员工姓名：</font>
					<input type="text" placeholder=""
					name="staffName" id="staffname" style="height:20px"/> 
					&nbsp;&nbsp;
					<font size="2.5px">房间号：</font>
					<input type="text"
					placeholder="" name="roomCode" id="roomcode" style="height:20px"/> 
					<br /> 
				<font size="2.5px">入住时间段：</font> <input type="text"
					style="height:20px;" name="beginDate" size="16" id="datetimeBegin"
					class="form_datetime" />
				
				<script type="text/javascript">
					$("#datetimeBegin").datetimepicker({
						format : 'yyyy/mm/dd',
						minView : 'month',
						language : 'zh-CN',
						autoclose : true,
						startDate : new Date(2008, 01, 01)
					}).on(
							"click",
							function() {
								$("#datetimeBegin").datetimepicker(
										"setStartDate",
										$("#datetimeStart".val()));
							});
				</script>
				~ <input type="text" name="endDate" style="height:20px;" size="16"
					id="datetimeEnd" class="form_datetime" />
					
				<script type="text/javascript">
					$("#datetimeEnd").datetimepicker({
						format : 'yyyy/mm/dd',
						minView : 'month',
						language : 'zh-CN',
						autoclose : true,
						startDate : new Date(2008, 01, 01)
					}).on(
							"click",
							function() {
								$("#datetimeEnd").datetimepicker(
										"setStartDate",
										$("#datetimeStart".val()));
							});
				</script>
					
					<br/>
					<select
					name="buildName" id="buildname">
					<option value="">==请选择宿舍楼==</option>
					<option value="闻博轩">闻博轩</option>
					<option value="静雅苑">静雅苑</option>
				</select> <select name="department" id="dept">
					<option value="">==请选择科室==</option>
					<c:forEach items="${depts}" var="dept">
						<option>${dept.dictName}</option>
					</c:forEach>
				</select> <select name="duty" id="duty">
					<option value="">====请选择勤务====</option>
					<c:forEach items="${dutys}" var="duty">
						<option>${duty.dictName}</option>
					</c:forEach>
				</select> 
				<button id="ss" type="submit">搜索</button>
				
			</form>
		</div>

		<div class="bottom" id="bottom">
			<div class="inp" id="inp">
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
						<a id="firstpage">首页</a>
						<c:if test="${pageNum>0}">
							<a id="previouspage">上一页</a>
						</c:if>

						<c:if test="${pageNum<pageCount-1}">
							<a  id="nextpage">下一页</a>
						</c:if>

						<!-- 最后一页 -->
						<a id="lastpage">末页</a> &nbsp;&nbsp;&nbsp;

					<span style="font-size:16px;color: black">第${pageNum+1}页/共${pageCount}页&nbsp;&nbsp;&nbsp;${recordCount}条记录</span>
					</c:if>
				</center>
			</div>
		</div>
		</div>
</body>
</html>
