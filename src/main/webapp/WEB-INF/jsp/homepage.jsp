<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="css/reset.css" />
		<link rel="stylesheet" href="css/sty.css" />
		<script type="text/javascript" src="js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="js/index.js" ></script>
		<title>RSBDPMS</title>
	</head>
	<body>
		<!--人事调配的批量操作-->
		<div id="tc" class="tc">
			<div class="ksn">
				<div class="tit">
					<h2>批量操作</h2>
				</div>
				<div class="kstext">
					科室输入：<input id="text" type="text" value=""/><br />
					勤务输入：<input id="text1" type="text" value=""/>
				</div>
				<div class="cz">
						<button type="submit" id="sx" class="qr">输入</button>
						<button type="button" id="qx" class="qx">取消</button>
				</div>
			</div>
		</div>
		
		
		<!--员工借用的添加借用-->
		<div id="jy" class="tc">
			<div class="ksn">
				<div class="tit">
					<h2>添加借用</h2>
				</div>
				<form action="" method="post">
					<div class="kstext">
						<div class="inp">
							<div>
								<span>员工编号：</span>
								<input type="text">
							</div>
							<div>
								<span>姓名：</span>
								<input type="text">
							</div>
							<div>
								<span>科室：</span>
								<input type="text">
							</div>
							<div>
								<span>宿舍楼：</span>
								<select>
									<option>闻博轩</option>
									<option>静雅苑</option>
								</select>
							</div>
							<div>
								<span>房间号：</span>
								<input type="text">
							</div>
							<div>
								<span>借用物品：</span>
								<input type="text">
							</div>
							<div>
								<span>借用时间：</span>
								<input type="date">
							</div>
						</div>
					</div>
					<div class="cz">
						<input type="submit" id="tjty" class="qr" value="提交"/>
						<input type="button" id="qxty" class="qx" value="取消"/>
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
					<div class="kstext" align="center" >
					
						原&nbsp;密&nbsp;码&nbsp;&nbsp;：<input type="password" value="${user.password}"/><br />
					
						新&nbsp;密&nbsp;码&nbsp;&nbsp;：<input type="password" name="newPassword" placeholder="请输入密码"/><br />
					
						确认密码：<input type="password" name="confirmPassword" placeholder="确认您的密码"/>
					
					</div>
					<div class="cz">
							<button type="submit" id="xg" class="qr">修改</button>
							<button type="reset"  class="sx">重置</button>
							<button type="button" id="qxmm" class="qx">取消</button>
					</div>
				</form>
			</div>
		</div>
		<!--员工通报的添加通报-->
		<div id="jt" class="tc">
			<div class="ksn">
				<div class="tit">
					<h2>添加通报</h2>
				</div>
				<form action="" method="post">
					<div class="kstext">
						<div class="inp">
							<div>
								<span>员工编号：</span>
								<input type="text">
							</div>
							<div>
								<span>姓名：</span>
								<input type="text">
							</div>
							<div>
								<span>科室：</span>
								<input type="text">
							</div>
							<div>
								<span>宿舍楼：</span>
								<select>
									<option>闻博轩</option>
									<option>静雅苑</option>
								</select>
							</div>
							<div>
								<span>房间号：</span>
								<input type="text">
							</div>
							<div>
								<span>通报类型：</span>
								<select>
									<option>卫生</option>
									<option>违纪</option>
								</select>
							</div>
							<div>
								<span>通报时间：</span>
								<input type="date">
							</div>
							<div>
								<span>通报原因：</span>
								<input type="text">
							</div>
							<div>
								<span>处罚金额：</span>
								<input type="text">
							</div>
						</div>
					</div>
					<div class="cz">
						<input type="submit" id="tjtb" class="qr" value="提交"/>
						<input type="button" id="qxtb" class="qx" value="取消"/>
					</div>
				</form>
			</div>
		</div>
		<div class="wrapper">
			<div class="header">
				<div class="box">
					<div class="title">员工宿舍管理系统</div>
					<div class="uname">
						<span id="gly" title="点击修改密码"><span class="img"><img src="img/tx.png"/></span><a>${user.userName}</a></span>
						<span id="zx"><a href="logout">注销</a></span>
					</div>	
				</div>
			</div>
			<div class="content">
				<div class="left">
					<div class="menu"><img src="img/meun.png"><span>菜单列表</span></div>
					<div class="listo" id="x">
					</div>
				</div>
				<div class="right">
					<iframe id="ifr" src="showWelcome"></iframe>
				</div>
			</div>
		</div>
	</body>
</html>
