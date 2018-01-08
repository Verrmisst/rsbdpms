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
				<form>
					<div class="inp" id="dl">
						<div>
							<span>宿舍楼&nbsp;&nbsp;&nbsp;：</span>
							<select>
								<option>闻博轩</option>
								<option>静雅苑</option>
							</select>
						</div>
						<div>
							<span>房间号&nbsp;&nbsp;&nbsp;：</span>
							<input type="text">
						</div>
						<div>
							<span>员工编号：</span>
							<input type="text">
						</div>
						<div>
							<span>姓&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;：</span>
							<input type="text">
						</div>
						<div>
							<span>床号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</span>
							<select>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
							</select>
						</div>
						<div>
							<span>衣柜号&nbsp;&nbsp;&nbsp;：</span>
							<select>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
							</select>
						</div>
						<div>
							<span>桌柜号&nbsp;&nbsp;&nbsp;&nbsp;：</span>
							<select>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
							</select>
						</div>
						<div>
							<span>鞋柜号&nbsp;&nbsp;&nbsp;：</span>
							<select>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
							</select>
						</div>
						<div>
							<span>领取床垫&nbsp;：</span>
							<select>
								<option>是</option>
								<option>否</option>
							</select>
						</div>
						<div>
							<span>入住日期：</span>
							<input type="date">
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
