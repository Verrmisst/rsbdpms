<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var bed=$("#bed");
	var desk=$("#desk");
	var yi=$("#yi");
	var room=$("#room");
	var build=$("#build");
	var buttono=$("#wenbo button");
	for (var i=0;i<buttono.length;i++){
		buttono[i].onclick=function(){
			var f=this.parentNode.parentNode;
			var beds=f.getElementsByTagName("td");
			bed[0].value=beds[7].innerHTML;
			desk[0].value=beds[9].innerHTML;
			yi[0].value=beds[8].innerHTML;
			room[0].value=beds[2].innerHTML;
			build[0].value=beds[1].innerHTML;
			
		}
	}
	var buttons=$("#jingya button");
	for (var i=0;i<buttons.length;i++){
		buttons[i].onclick=function(){
			var f=this.parentNode.parentNode;
			var beds=f.getElementsByTagName("td");
			bed[0].value=beds[7].innerHTML;
			desk[0].value=beds[9].innerHTML;
			yi[0].value=beds[8].innerHTML;
			room[0].value=beds[2].innerHTML;
			build[0].value=beds[1].innerHTML;
		}
	}
})
</script>
			<hr id="hr" >
			<label>[闻博轩]</label>
			<table id="wenbo">
				<tr class="tr">
					<th>操作</th>
					<th>宿舍楼</th>
					<th>房间号</th>
					<th>已入住人姓名</th>
					<th>性别</th>
					<th>科室</th>
					<th>勤务</th>
					<th>床号</th>
					<th>衣柜号</th>
					<th>桌柜号</th>
					<th>鞋柜号</th>
				</tr>
				<c:forEach items="${objectWB}" var="w">
				<tr>
					<c:choose>
					<c:when test="${w.staff.empName == null}">
					<td><button>Insert</button></td>
					</c:when>
					<c:otherwise>
					<td></td>
					</c:otherwise>
					</c:choose>
					<td>${w.buildName}</td>
					<td>${w.roomCode}</td>
					<td>${w.staff.empName}</td>
					<td>${w.staff.gender}</td>
					<td>${w.staff.dept.dictName}</td>
					<td>${w.staff.duty.dictName}</td>
					<td>${w.bedNum}</td>
					<td>${w.wardrobeNum}</td>
					<td>${w.deskNum}</td>
					<td>${w.staff.shopboxNum}</td>
				</tr>
				</c:forEach>
			</table>
			<br/>
			<label>======================================================================================</label>
			<br/><br/>
			<label>[静雅苑]</label>
			<table id="jingya">
				<tr class="tr">
					<th>操作</th>
					<th>宿舍楼</th>
					<th>房间号</th>
					<th>已入住人姓名</th>
					<th>性别</th>
					<th>科室</th>
					<th>勤务</th>
					<th>床号</th>
					<th>衣柜号</th>
					<th>桌柜号</th>
					<th>鞋柜号</th>
				</tr>
				<c:forEach items="${objectJY}" var="j">
				<tr>
					<c:choose>
					<c:when test="${j.staff.empName == null}">
					<td><button>Insert</button></td>
					</c:when>
					<c:otherwise>
					<td></td>
					</c:otherwise>
					</c:choose>
					<td>${j.buildName}</td>
					<td>${j.roomCode}</td>
					<td>${j.staff.empName}</td>
					<td>${j.staff.gender}</td>
					<td>${j.staff.dept.dictName}</td>
					<td>${j.staff.duty.dictName}</td>
					<td>${j.bedNum}</td>
					<td>${j.wardrobeNum}</td>
					<td>${j.deskNum}</td>
					<td>${j.staff.shopboxNum}</td>
				</tr>
				</c:forEach>
			</table>
