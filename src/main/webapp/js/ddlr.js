$(document).ready(function(){
	$("#typein").submit(function(){
		var fjh=$("#dl input")[0].value;
		var ygbh=$("#dl input")[1].value;
		var xm=$("#dl input")[2].value;
		var sj=$("#dl input")[3].value;
		if(fjh==""){
			alert("房间号不能为空！");
			return false;
		}
		if(ygbh==""){
			alert("员工编号不能为空！");
			return false;
		}
		if(xm==""){
			alert("姓名不能为空！");
			return false;
		}
		/*if(sj==""){
			alert("时间不能为空！");
			return false;
		}*/
		alert("提交成功！");
	});
});