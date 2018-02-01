$(document).ready(function(){
	
	$("#tl").click(function(){
		var fjh=$("#room").val();
		if(fjh==""){
			alert("请输入房间号");
			return false;
		}
		
		alert("提交成功！");
	});
	
	$("#ss").click(function(){
		
		var dept = $("#dept").val();
		var duty = $("#duty").val();
		
		//alert(roomCode+" "+buildName+" "+dept+" "+duty);
		
		/*if (roomCode==""&bulidName==""&dept==""&duty=="") {
			alert("请至少输入一个搜索项");
			return false;
		}*/
		
		
		$.get("showroomsituation.action",{dept:dept,duty:duty},
				function(data){
				$("#chax").html(data);
				
		});
		
		/*$.ajax({
			type:"get",
			url:"showroomsituation.action",
			async:true,
			data:"roomCode="+roomCode+"&buildName="+buildName+"&dept="+dept+"&duty="+duty,
			success: function (datas) {
				$("#chax").html(datas);
             },
		});*/
	});

})