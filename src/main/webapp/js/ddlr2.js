$(document).ready(function(){
	$("#tl").click(function(){
		var fjh=$("#dl input")[0].value;
		var ygbh=$("#dl input")[1].value;
		var xm=$("#dl input")[2].value;
		var ks=$("#dl input")[3].value;
		var qw=$("#dl input")[4].value;
		var sj=$("#dl input")[5].value;
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
		if(ks==""){
			alert("科室不能为空！");
			return false;
		}
		if(qw==""){
			alert("勤务不能为空！");
			return false;
		}
		alert("提交成功！");
	});
	
	$("#ss").click(function(){
		
		var dept = $("#dept").val();
		var duty = $("#duty").val();
		
		
		/*if (roomCode==""&&bulidName==""&&dept==""&&duty=="") {
			alert("请至少输入一个搜索项");
			return false;
		}*/
		
		
		$.get("showroomsituation.action",{dept:dept,duty:duty},
				function(data){
				$("#chax").html(data);
				
		});
		
	});
})