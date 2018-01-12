<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/single.css" />
		<script type="text/javascript" src="js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="js/ddlr.js" ></script>
		<title>单独录入</title>
	</head>
	<body>
		<div class="single">
			<div class="top">
				<h3>单独录入</h3>
			</div>
			<div class="bottom">
				<form action="singletypein" method="post" id="typein">
					<div class="inp" id="dl">
						<div>
							<span>宿舍楼&nbsp;&nbsp;&nbsp;：</span>
							<select name="buildingName">
								<option value="1">闻博轩</option>
								<option value="2">静雅苑</option>
							</select>
						</div>
						<div>
							<span>房间号&nbsp;&nbsp;&nbsp;：</span>
							<input type="text" name="roomCode">
						</div>
						<div>
							<span>员工编号：</span>
							<input type="text" name="empCode">
						</div>
						<div>
							<span>员工性别：</span>
							<select name="empGender">
								<option value="0">男</option>
								<option value="1">女</option>
							</select>
						</div>
						<div>
							<span>姓&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;：</span>
							<input type="text" name="empName"	>
						</div>
						<div>
							<span>床号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</span>
							<select name="bedNum">
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
						</div>
						<div>
							<span>衣柜号&nbsp;&nbsp;&nbsp;：</span>
							<select name="wardrobeNum">
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
						</div>
						<div>
							<span>桌柜号&nbsp;&nbsp;&nbsp;&nbsp;：</span>
							<select name="deskNum">
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
						</div>
						<div>
							<span>鞋柜号&nbsp;&nbsp;&nbsp;：</span>
							<select name="shoeboxNum">
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
						</div>
						<div>
							<span>领取床垫&nbsp;：</span>
							<select name="mattressNum">
								<option value="0">是</option>
								<option value="1">否</option>
							</select>
						</div>
						<div>
							<span>入住日期：</span>
							<input type="date" name="livingDate" width="100px" placeholder="日期输入">
						</div>
					</div>
					<div class="btn">
						<button type="submit" class="sub" id="tl">提交</button>
						<button type="reset" class="res">重置</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
