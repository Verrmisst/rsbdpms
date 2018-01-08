$(document).ready(function(){
	$("#ss").click(function(){
		var inputs=$("#ssk input")[0].value;
		if (inputs=="") {
			alert("搜索框不能为空！");
			return false;
		}
	});
	$("#tjtb").click(function(){
		$("#jt",window.parent.document).css("display","block");
	})
})
