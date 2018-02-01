$(document).ready(function(){
	
	

	var btn=$("#inp .tss");
	for (var r=0;r<btn.length;r++) {
		btn[r].onclick=function(){
			$("#ts").css("display","block");
		}
	}
	$("#tsss").submit(function(){
		var inputs=$("#ts input");
		for(var i=0;i<inputs.length;i++){
			if(inputs.value==""){
				alert("表单中不能为空！");
				return false;
			}
		}
		alert("提交成功！");
	});
	$("#tssq").click(function(){
		$("#ts").css("display","none");
	});
	
	
});
  
        

