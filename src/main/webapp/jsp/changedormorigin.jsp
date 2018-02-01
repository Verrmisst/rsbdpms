<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
		
		
		var pg = $("#pagenum").val();
		var pc = $("#pagecount").val();

		$.ajax({

			url : "showpagingdorm",
			async : true,
			type : 'post',
			data : {
				'pageNum' : pg,
				'pageCount' : pc,
			},
			success : function(data) {
				$("#inp").html(data);

			}
		});
		
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
				<input type="hidden" value="${pageNum}" id="pagenum" /> <input
					type="hidden" value="${pageCount}" id="pagecount" /> 
			</form>
		</div>

		<div class="bottom" id="bottom">
			<div class="inp" id="inp"></div>
		</div>
	</div>
</body>
</html>
