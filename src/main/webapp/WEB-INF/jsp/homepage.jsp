<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/sty.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		$("#tjty").click(function(){
		
		var staffcode = $("#staffcode").val();
		var staffname = $("#staffname").val();
		var objectname = $("#objectname").val();
		var datetimeEnd = $("#datetimeEnd").val();
		
		if(staffcode==""){
			alert("请输入员工编号");
			return false;
		}
		
		if(objectname==""){
			alert("请输入物品名称");
			return false;
		}
		
		
		$.post("saveborrow",{staffCode:staffcode,staffName:staffname,objectName:objectname,beginDate:datetimeEnd},
				function(data){
					alert(data.text);
					window.location.reload();
				}
		);
		
		});
		
		
		$("#tjtb").click(function(){
			var code = $("#code").val();
			var type = $("#type").val();
			var time = $("#datetimeBegin").val();
			var reason = $("#reason").val();
			var money = $("#money").val();
			
		if(code==""){
			alert("请输入员工编号");
			return false;
		}
		
			
		if(type==""){
			alert("请输入通报类型");
			return false;
		}
		
		if(reason==""){
			alert("请输入通报原因");
			return false;
		}
		
			
		if(code==""){
			alert("请输入员工编号");
			return false;
		}
		
		$.post("savenotification",{staffCode:code,type:type,time:time,reason:reason,money:money},
				function(data){
							
							alert(data.text);
							window.location.reload();
				});
				
				
				
				/* alert(data.text); */
				
		});
		
		
	});

</script>
<title>RSBDPMS</title>
</head>
<body>

	<!--员工借用的添加借用-->
	<div id="jy" class="tc">
		<div class="ksn">
			<div class="tit">
				<h2 style="line-height: 40px;">添加借用</h2>
			</div>
			<form action="" method="post">
				<div class="kstext">
					<div class="inp">
						<div>
							<span>员工编号：</span> <input type="text" name="staffCode" id="staffcode">
						</div>
						<div>
							<span>借用物品：</span> <input type="text" name="objectName" id="objectname">
						</div>
						<div>
							<span>借用时间：</span> <input size="16" type="text" name="beginDate"
								id="datetimeEnd" readonly class="form_datetime">
							<script type="text/javascript">
								$("#datetimeEnd").datetimepicker({
									format : 'yyyy/mm/dd',
									minView : 'month',
									language : 'zh-CN',
									autoclose : true,
									startDate : new Date(2015,01,01)
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
				</div>
				<div class="cz" align="center">
					<input type="button" id="tjty" class="qr" value="提交" /> <input
						type="button" id="qxty" class="qx" value="取消" />
				</div>
			</form>
		</div>
	</div>
	<!--用户管理的修改密码-->
	<div id="xgmm" class="tc">
		<div class="ksn">
			<div class="tit">
				<h2>修改密码</h2>
			</div>
			<form action="editpass" method="post" id="changepass">
				<div class="kstext" align="center">

					原&nbsp;密&nbsp;码&nbsp;&nbsp;：<input type="password"
						value="${user.password}" /><br /> 新&nbsp;密&nbsp;码&nbsp;&nbsp;：<input
						type="password" name="newPassword" placeholder="请输入密码" /><br />

					确认密码：<input type="password" name="confirmPassword"
						placeholder="确认您的密码" />

				</div>
				<div class="cz">
					<button type="submit" id="xg" class="qr">修改</button>
					<button type="reset" class="sx">重置</button>
					<button type="button" id="qxmm" class="qx">取消</button>
				</div>
			</form>
		</div>
	</div>
	<!--员工通报的添加通报-->
	<div id="jt" class="tc">
		<div class="ksn">
			<div class="tit">
				<h2 style="line-height: 40px;">添加通报</h2>
			</div>
			<form action="" method="post">
				<div class="kstext">
					<div class="inp">
						<div>
							<span>员工编号：</span> <input type="text" name="staffCode" id="code">
						</div>

						<div>
							<span>通报类型：</span> <input type="text" name="type" id="type">
						</div>
						<div>
							<span>通报时间：</span> <input size="16" type="text" name="time"
								id="datetimeBegin" readonly class="form_datetime">
							<script type="text/javascript">
								$("#datetimeBegin").datetimepicker({
									format : 'yyyy/mm/dd',
									minView : 'month',
									language : 'zh-CN',
									autoclose : true,
									startDate : new Date(2015,01,01)
								}).on(
										"click",
										function() {
											$("#datetimeBegin").datetimepicker(
													"setStartDate",
													$("#datetimeStart".val()));
										});
							</script>

						</div>
						<div>
							<span>通报原因：</span> <input type="text" name="reason" id="reason">
						</div>
						<div>
							<span>处罚金额：</span> <input type="text" name="money" id="money">
						</div>
					</div>
				</div>
				<div class="cz" align="center">
					<input type="button" id="tjtb" class="qr" value="提交" /> <input
						type="button" id="qxtb" class="qx" value="取消" />
				</div>
			</form>
		</div>
	</div>
	<div class="wrapper">
		<div class="header">
			<div class="box">
				<div class="title">宿舍人员入住管理系统</div>
				<div class="uname">
					<span id="gly" title="点击修改密码"><span class="img"><img
							src="img/tx.png" />
					</span><a>${user.userName}</a>
					</span> <span id="zx"><a href="logout">注销</a>
					</span>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="left">
				<div class="menu">
					<img src="img/meun.png"><span>菜单列表</span>
				</div>
				<div class="listo" id="x"></div>
			</div>
			<div class="right">
				<iframe id="ifr" src="showWelcome"></iframe>
			</div>
		</div>
	</div>
</body>
</html>
