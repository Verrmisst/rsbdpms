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
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/sstp.js"></script>
<script type="text/javascript">
	
	$(function(){
	
		$("#ss").click(function(){
		
			var rd = $("#roomCode").val();
			var bn = $("#buildName").val();
			var bd = $("#datetimeBegin").val(); 
			var ed = $("#datetimeEnd").val();
			var lbd = $("#livingbegin").val();
			var led = $("#livingend").val();
			var ebd = $("#exchangebegin").val();
			var eed = $("#exchangeend").val();
			
			
			//alert(rd+"  "+bn+"  "+bd+"  "+ed);
			
			$.get("blursearchcheckout",{roomCode:rd,buildName:bn,beginDate:bd,endDate:ed,livingbegin:lbd,livingend:led,exchangebegin:ebd,exchangeend:eed},
				function(data){
					
					$("#inp").empty();;
					
					$("#inp").html(data);
				
				}
			);
		});
		
		
	});
	
</script>
<title>已退宿人员</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3 style="font-size: 20px;margin-top: 10px	">已退宿人员</h3>
			<form class="ssk" id="ssk" action="" method="post">
				<font size="2.5px" >退宿时间段：</font>
				<input type="text"  style="height:20px;" name="beginDate" size="16"   id="datetimeBegin"  class="form_datetime"/>
				<script type="text/javascript">
		   $("#datetimeBegin").datetimepicker({
			    format: 'yyyy/mm/dd',
			    minView:'month',
			    language: 'zh-CN',
			    autoclose:true,
			    startDate:new Date(2008,01,01)
			}).on("click",function(){
			    $("#datetimeBegin").datetimepicker("setStartDate",$("#datetimeStart".val()));
			  });
		</script>
				~
				<input type="text" name="endDate" style="height:20px;" size="16"   id="datetimeEnd"  class="form_datetime"/>
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
		&nbsp;&nbsp;&nbsp;
				<font size="2.5px" >入住时间段：</font>
				<input type="text"  style="height:20px;" name="livingbegin" size="16"   id="livingbegin"  class="form_datetime"/>
				<script type="text/javascript">
		   $("#livingbegin").datetimepicker({
			    format: 'yyyy/mm/dd',
			    minView:'month',
			    language: 'zh-CN',
			    autoclose:true,
			    startDate:new Date(2008,01,01)
			}).on("click",function(){
			    $("#livingbegin").datetimepicker("setStartDate",$("#datetimeStart".val()));
			  });
		</script>
				~
				<input type="text" name="livingend" style="height:20px;" size="16"   id="livingend"  class="form_datetime"/>
				<script type="text/javascript">
		   $("#livingend").datetimepicker({
			    format: 'yyyy/mm/dd',
			    minView:'month',
			    language: 'zh-CN',
			    autoclose:true,
			    startDate:new Date(2008,01,01)
			}).on("click",function(){
			    $("#livingend").datetimepicker("setStartDate",$("#datetimeStart".val()));
			  });
		</script>
		<br/>
				<font size="2.5px" >调宿时间段：</font>
				<input type="text"  style="height:20px;" name="exchangebegin" size="16"   id="exchangebegin"  class="form_datetime"/>
				<script type="text/javascript">
		   $("#exchangebegin").datetimepicker({
			    format: 'yyyy/mm/dd',
			    minView:'month',
			    language: 'zh-CN',
			    autoclose:true,
			    startDate:new Date(2008,01,01)
			}).on("click",function(){
			    $("#exchangebegin").datetimepicker("setStartDate",$("#datetimeStart".val()));
			  });
		</script>
				~
				<input type="text" name="exchangeend" style="height:20px;" size="16"   id="exchangeend"  class="form_datetime"/>
				<script type="text/javascript">
		   $("#exchangeend").datetimepicker({
			    format: 'yyyy/mm/dd',
			    minView:'month',
			    language: 'zh-CN',
			    autoclose:true,
			    startDate:new Date(2008,01,01)
			}).on("click",function(){
			    $("#exchangeend").datetimepicker("setStartDate",$("#datetimeStart".val()));
			  });
		</script>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<font size="2.5px">房间号：</font>
		<input type="text" style="height:20px;" placeholder="" name="roomCode" id="roomCode"/>
				<select name="buildName" id="buildName" style="height:20px;">
					<option value="">=请选择宿舍楼=</option>
					<option value="1">闻博轩</option>
					<option value="2">静雅苑</option>
				</select>
				<button id="ss" type="button">搜索</button>
			</form>
		</div>
		<div class="bottom" id="bottom">
			<div class="inp" id="inp">
				<table>
					<tr class="tr" >
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
					<a href="download.action">退宿人员信息导出（全部）</a>
				</div>
				<br /> <br />
				<center>
					<c:if test="${recordCount>10}">
						<!-- 首页 -->
						<a href="checkoutpage?pageNum=0">首页</a>
						<c:if test="${pageNum>0}">
							<a href="checkoutpage?pageNum=${pageNum-1}">上一页</a>
						</c:if>

						<c:if test="${pageNum<pageCount-1}">
							<a href="checkoutpage?pageNum=${pageNum+1}">下一页</a>
						</c:if>
						<!-- 最后一页 -->
						<a href="checkoutpage?pageNum=${pageCount-1}">末页</a> &nbsp;&nbsp;&nbsp;
					<span style="font-size:16px;color: black">第${pageNum+1}页/共${pageCount}页&nbsp;&nbsp;&nbsp;${recordCount}条记录</span>
					</c:if>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
