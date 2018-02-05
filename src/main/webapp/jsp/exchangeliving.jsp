<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/single.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/ts.js"></script>
<title>调宿</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3 style="margin-top:10px;">调宿</h3>
			<form class="ssk" id="ssk">
				<select name="dept" id="dept">
					<option value="">==请选择科室==</option>
					<c:forEach items="${depts}" var="dept">
						<option value="${dept.dictName}">${dept.dictName}</option>
					</c:forEach>
				</select> <select name="duty" id="duty">
					<option value="">======请选择勤务======</option>
					<c:forEach items="${dutys}" var="duty">
						<option value="${duty.dictName}">${duty.dictName}</option>
					</c:forEach>
				</select>
				<button id="ss" type="button">查询</button>
			</form>
		</div>
		<div class="bottom">
			<form action="staffexchange" method="post">
				<div class="inp" id="dl">
					<div>
						<span>员工编号：</span> <input type="text" value="${staff.empCode}"
							readonly="readonly" name="staffCode">
					</div>
					<div>
						<span>姓名：</span> <input type="text" value="${staff.empName}"
							readonly="readonly">
					</div>
					<div>
						<span>宿舍楼：</span> 
							<input type="text"
							name="build" id="build" placeholder="${staff.buildingName}">
					</div>
					<div>
						<span>房间号：</span> <input type="text"
							placeholder="${staff.roomCode}" name="roomCode" id="room">
					</div>
					<div>
						<span>床号：</span> <input type="text" placeholder="${staff.bedNum}"
							name="bedNum" id="bed">
					</div>
					<div>
						<span>衣柜号：</span> <input type="text"
							placeholder="${staff.wardrobeNum}" name="wardrobeNum" id="yi">
					</div>
					<div>
						<span>桌柜号：</span> <input type="text"
							placeholder="${staff.deskNum}" name="deskNum" id="desk">
					</div>
					<div>
						<span>鞋柜号：</span> <input type="text"
							 name="shopboxNum" value="${staff.shopboxNum}">
					</div>
					<div>
						<span>调宿时间：</span> <input size="16" type="text" name="livingDate"
							id="datetimeEnd" readonly class="form_datetime">
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
					</div>
				</div>
				<br />
				<br />
				<div class="btn">
					<button type="submit" class="sub" id="tl">提交</button>
					<button type="reset" class="res">重置</button>
				</div>
			</form>
			<div class="chax" id="chax"></div>
		</div>
	</div>
</body>
</html>
