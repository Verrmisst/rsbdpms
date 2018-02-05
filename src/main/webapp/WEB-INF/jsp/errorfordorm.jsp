<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
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
<style type="text/css">
body {
	background: -webkit-radial-gradient(#fff, #f2f9fd);
	/* Safari 5.1 - 6.0 */
	background: -o-radial-gradient(#fff, #f2f9fd); /* Opera 11.6 - 12.0 */
	background: -moz-radial-gradient(#fff, #f2f9fd); /* Firefox 3.6 - 15 */
	background: radial-gradient(#fff, #f2f9fd); /* 标准的语法 */;
}

.box {
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	width: 560px;
	height: 68px;
	text-align: center;
	margin: auto;
	color: #908e8e;
}
</style>

<title>ERROR-PAGE</title>
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
</div>


	<div class="box" style="position:absolute; width:560px; margin:auto;">
		<h2 style="font-size: 22px;">${text}</h2>
	</div>
</body>
</html>
