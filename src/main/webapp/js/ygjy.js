$(document).ready(function(){
	$("#tjjy").click(function(){
		$("#jy",window.parent.document).css("display","block");
	})
	
	$("#qxty",window.parent.document).click(function(){
		$("#jy",window.parent.document).css("display","none");
	})
	$("#ss").click(function(){
		var inputs=$("#ssk input")[0].value;
		if (inputs=="") {
			alert("请输入员工编号");
			return false;
		}
	})
})