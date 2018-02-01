<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/single.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/excel.js"></script>
<title>Excel导入</title>
</head>
<body>
	<div class="single">
		<div class="top">
			<h3>Excel导入</h3>
		</div>
		<div class="bottom">
			<form action="upload.action" method="post"
				enctype="multipart/form-data">
				<div class="inp">
					<div>
						<input id="wj" type="file"
							style="background: white; margin-left: 20px;" name="upload" /> <input
							type="hidden" name="uploadtype" value="1" />
					</div>
				</div>
				<div class="inp">
					<h3>上传主档格式要求，如下所示:</h3>
					<!-- <img src="img/zwupload.jpg" /> -->
					<table>
						<tr class="tr">
							<th>员工编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>宿舍楼</th>
							<th>房间号</th>
							<th>床号</th>
							<th>衣柜号</th>
							<th>桌柜号</th>
							<th>鞋柜号</th>
						</tr>

						<tr>
							<td>唯一值</td>
							<td>中文、英文、日文</td>
							<td>男或女</td>
							<td>闻博轩或静雅苑</td>
							<td>必填</td>
							<td>必填</td>
							<td>必填</td>
							<td>必填</td>
							<td>必填</td>
						</tr>
					</table>
					<span style="font-size: 20px;color: red;">备注：上传前请检查各字段是否符合要求，检查excel文件文件中是否有空行。</span>
				</div>

				<div class="btn" style="bottom: 10px">
					<button type="submit" id="sub" class="sub">提交</button>
					<button type="reset" class="res">重置</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
