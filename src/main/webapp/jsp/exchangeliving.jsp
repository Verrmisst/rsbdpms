<%@page import="java.text.SimpleDateFormat"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    	<script type="text/javascript" src="js/jquery-1.8.2.js" ></script>
    	<script type="text/javascript" src="js/ts.js" ></script>
        <link rel="stylesheet" href="css/single.css" />
    	<link rel="stylesheet"  href="css/reset.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exchange Dorm</title>
    </head>
    <body>
    	<!--调宿-->
		<div id="ts" class="tc">
			<div class="ksn">
				<div class="tit">
					<h2>调宿</h2>
				</div>
				<form action="staffexchange" method="post">
					<div class="kstext">
						<div class="inpss">
							<div>
								<span>员工编号：</span>
								<input type="text" value="${staff.empCode}" readonly="readonly" name="staffCode">
							</div>
							<div>
								<span>姓名：</span>
								<input type="text" value="${staff.empName}" >
							</div>
							<div>
								<span>宿舍楼：</span>
								<select name="build">
								<c:if test="${staff.buildingName eq '闻博轩'}">
									<option selected="selected">闻博轩</option>
									<option>静雅苑</option>
								</c:if>
								<c:if test="${staff.buildingName eq '静雅苑'}">
									<option>闻博轩</option>
									<option selected="selected">静雅苑</option>
								</c:if>
								<c:if test="${staff.buildingName eq null}">
									<option>闻博轩</option>
									<option>静雅苑</option>
								</c:if>
								</select>
							</div>
							<div>
								<span>房间号：</span>
								<input type="text" placeholder="${staff.roomCode}" name="roomCode">
							</div>
							<div>
								<span>床号：</span>
								<input type="text" placeholder="${staff.bedNum}" name="bedNum">
							</div>
							<div>
								<span>衣柜号：</span>
								<input type="text" placeholder="${staff.wardrobeNum}" name="wardrobeNum">
							</div>
							<div>
								<span>桌柜号：</span>
								<input type="text" placeholder="${staff.deskNum}" name="deskNum">
							</div>
							<div>
								<span>鞋柜号：</span>
								<input type="text" placeholder="${staff.shopboxNum}" name="shopboxNum">
							</div>
							<div>
								<span>入住时间：</span>
								<input type="date"  name="livingDate">
							</div>
						</div>
					</div>
					<div class="cz">
						<input type="submit" id="tsss" class="qr" value="提交"/>
						<input type="button" id="tssq" class="qx" value="取消"/>
					</div>
				</form>
			</div>
		</div>
 	</body>
</html>