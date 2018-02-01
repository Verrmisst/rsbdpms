<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../css/single.css" />
		<script type="text/javascript" src="../js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="../js/tjss.js" ></script>
		<title>添加宿舍</title>
	</head>
	<body>
		<div class="single">
			<div class="top">
				<h3>添加宿舍</h3>
			</div>
			<div class="bottom">
				<form method="post"  action="saveroom"  id="bd">
					<div class="inp" id="dl">
						<div>
							<span>宿舍楼：</span>
							<select name="buildName">
								<option value="1">闻博轩</option>
								<option value="2">静雅苑</option>
							</select>
						</div>
						<div>
							<span>房间号：</span>
							<input type="text" name="roomCode">
						</div>
						<div>
							<span>房间人数：</span>
							<input type="text" name="size">
						</div>
						<div>
							<span>实际人数：</span>
							<input type="text" name="occupy">
						</div>
						<div>
							<span>分类：</span>
							<input type="text" name="classify">
						</div>
						<div>
							<span>备注1：</span>
							<input type="text" name="content1">
						</div>
						<div>
							<span>备注2：</span>
							<input type="text" name="content2">
						</div>
						<div>
							<span>备注3：</span>
							<input type="text" name="content3">
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
