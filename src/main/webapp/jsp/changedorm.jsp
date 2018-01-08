<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../css/single.css" />
		<script type="text/javascript" src="../js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="../js/sstp.js" ></script>
		<title>宿舍调配</title>
	</head>
	<body>
		<div class="single">
			<div class="top">
				<h3>宿舍调配</h3>
				<form class="ssk" id="ssk">
					<input type="text" placeholder="请输入员工编号！！！"/>
					<button id="ss" type="button">搜索</button>
				</form>
			</div>
			<div class="bottom">
				<form>
					<div class="inp" id="inp">
						<table>
							<tr class="tr">
								<th>员工编号</th>
								<th>姓名</th>
								<th>科室</th>
								<th>勤务</th>
								<th>宿舍楼</th>
								<th>房间号</th>
								<th>床号</th>
								<th>衣柜号</th>
								<th>桌柜号</th>
								<th>鞋柜号</th>
								<th>借用</th>
								<th>通报次数</th>
								<th>入住日期</th>
								<th>操作</th>
							</tr>
							<tr>
								<form>
									<td>xxxxxx</td>
									<td>xxx</td>
									<td>外包公司</td>
									<td>外包人员</td>
									<td>
										<select>
											<option>闻博轩</option>
											<option>静雅苑</option>
										</select>
									</td>
									<td>
										<input class="ss" type="text" value="205" />
									</td>
									<td>
										<select>
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
										</select>
									</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>2017-12-30</td>
									<td>
										<button type="button" class="ts">退宿</button>
										<button type="submit" class="tss">调宿</button>
									</td>
								</form>
							</tr>
							<tr>
								<form>
									<td>xxxxxx</td>
									<td>xxx</td>
									<td>外包公司</td>
									<td>外包人员</td>
									<td>
										<select>
											<option>闻博轩</option>
											<option>静雅苑</option>
										</select>
									</td>
									<td>
										<input class="ss" type="text" value="206" />
									</td>
									<td>
										<select>
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
										</select>
									</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>2017-12-30</td>
									<td>
										<button type="button" class="ts">退宿</button>
										<button type="submit" class="tss">调宿</button>
									</td>
								</form>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
