<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="utf-8" %>
<link rel="stylesheet" href="css/single.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/rstp.js"></script>
<div class="bottom">
<div class="single">
		<div class="top">
			<h3>人事调配</h3>
			<form class="ssk" id="ssk" action="showstaff" method="post">
				<input type="text" placeholder="请输入员工编号" name="empCode" />
				<button id="ss" type="submit">搜索</button>
			</form>
		</div>
			<form action="staffmanager" method="post" id="renshi">
				<div class="inp">
					<table>
						<tr class="tr">
							<th>员工编号</th>
							<th>姓名</th>
							<th>科室</th>
							<th>勤务</th>
							<th>备注</th>
						</tr>
						<c:forEach items="${employees}" var="e">
							<tr>
								<td><input type="text"  name="empcodes" value="${e.empCode}" readonly="readonly" class="xx" style="text-align: center;"/></td>
								<td>${e.empName}</td>
								<td class="td"><input type="text" class="xx ks" name="dept" style="text-align: center;"/>
								</td>
								<td><input type="text" class="xx qw" name="duty" style="text-align: center;"/></td>
								<td>${e.content}</td>
							</tr>
						</c:forEach>
					</table>
					<br /> 
					<br /> 
				</div>
				<div class="btn">
					<button type="submit" id="sub" class="sub">提交</button>
					<button type="reset" class="res">重置</button>
				</div>
			</form>
		</div>
		</div>