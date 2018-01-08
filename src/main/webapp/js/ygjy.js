$(document).ready(function(){
	$("#tjjy").click(function(){
		$("#jy",window.parent.document).css("display","block");
	})
	var btn=$("#tab button");
	$.each(btn,function(i,btn){
		btn.onclick=function(){
			var inps=$("#tab input");
			if(inps[i].value==""){
				alert("归还日期不能为空！")
				return false;
			}
		}
	})
	$("#qxty",window.parent.document).click(function(){
		$("#jy",window.parent.document).css("display","none");
	})
	$("#ss").click(function(){
		var inputs=$("#ssk input")[0].value;
		if (inputs=="") {
			alert("搜索框不能为空！");
			return false;
		}
	})
})