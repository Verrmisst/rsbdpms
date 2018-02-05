$(document).ready(function(){
	$("#typein").submit(function(){
		
		var empcode = $("#empcode").val();
		var empname = $("#empname").val();
		var datetimeEnd = $("#datetimeEnd").val();

		if (empcode == "") {

			alert("请输入员工编号");
			return false;

		}
		if (empname == "") {

			alert("请输入员工姓名");
			return false;
		}
		if (datetimeEnd == "") {

			alert("请输入入住时间");
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

});