<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/single.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/ddlr2.js"></script>
<script type="text/javascript">
	$(function(){
	$("#tl").click(function() {

		var empcode = $("#empcode").val();
		var empname = $("#empname").val();
		var datetimeEnd = $("#datetimeEnd").val();
		var dept = $("#dept").val();
		var duty = $("#duty").val();

		if (empcode == "") {

			alert("请输入员工编号");
			return false;

		}
		if (empname == "") {

			alert("请输入员工姓名");
			return false;
		}
		
		alert("提交成功！");
	});
	});

</script>
<title>已入职录入</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3 style="margin-top:10px;">已入职录入</h3>
			<div style="text-align: right;margin-right:25px">
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
			</div>
		</div>
		<div class="bottom">
			<form action="singletypeinold" method="post">
				<div class="inp" id="dl">
					<div>
						<span>宿舍楼：</span> <input type="text"
							name="buildingName" id="build">
					</div>
					<div>
						<span>房间号：</span> <input type="text" name="roomCode" id="room">
					</div>
					<div>
						<span>员工编号：</span> <input type="text" name="empCode" id="empcode">
					</div>
					<div>
						<span>员工性别：</span> <select name="empGender" id="gender">
							<option value="0">男</option>
							<option value="1">女</option>
						</select>
					</div>
					<div>
						<span>姓名：</span> <input type="text" name="empName" id="empname">
					</div>
					<div>
						<span>入住日期：</span>  
						<input size="16" type="text" name="livingDate" id="datetimeEnd" readonly class="form_datetime"> 
						<script type="text/javascript">
		   $("#datetimeEnd").datetimepicker({
			    format: 'yyyy/mm/dd',
			    minView:'month',
			    language: 'zh-CN',
			    autoclose:true,
			    startDate:new Date(2008,01,01)
			}).on("click",function(){
			    $("#datetimeEnd").datetimepicker("setStartDate",$("#datetimeStart".val()));
			  });
		</script>
					</div>
					<div>
						<span>科室：</span> <select name="dept" id="dept">
							<option value="">==请选择科室==</option>
							<c:forEach items="${depts}" var="dept">
								<option value="${dept.dictName}">${dept.dictName}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<span>勤务：</span> <select name="duty" id="duty">
							<option value="">=======请选择勤务======</option>
							<c:forEach items="${dutys}" var="duty">
								<option value="${duty.dictName}">${duty.dictName}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<span>床号：</span> <input type="text" name="bedNum" id="bed">
					</div>
					<div>
						<span>衣柜号：</span> <input type="text" name="wardrobeNum" id="yi">

					</div>
					<div>
						<span>桌柜号：</span> <input type="text" name="deskNum" id="desk">
					</div>
					<div>
						<span>鞋柜号：</span> <input type="text" name="shoeboxNum">

					</div>
					<div>
						<span>领取床垫：</span> <select name="mattressNum">
							<option value="0">是</option>
							<option value="1">否</option>
						</select>
					</div>
				</div>

				
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
