$(document).ready(function(){
	$("#typein").submit(function(){
		var fjh=$("#dl input")[0].value;
		var ygbh=$("#dl input")[1].value;
		var xm=$("#dl input")[2].value;
		var sj=$("#dl input")[3].value;
		if(fjh==""){
			alert("请输入房间号！");
			return false;
		}
		if(ygbh==""){
			alert("请输入员工编号！");
			return false;
		}
		if(xm==""){
			alert("请输入姓名！");
			return false;
		}
		/*if(sj==""){
			alert("时间不能为空！");
			return false;
		}*/
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

});