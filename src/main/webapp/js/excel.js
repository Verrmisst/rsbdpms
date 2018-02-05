$(document).ready(function(){
	$("form").submit(function(){
		var wj=$("#wj").val();
		if (wj=="") {
			alert("请选择文件！");
			return false;
		}
		
		var str = wj.substr(wj.length - 3);
		
		if(str != "xls") {
			//$("#uploadSpan").html("请选择excel2003文件");
			alert("请选择excel2003文件");
			$("#wj").empty();
			return false;
		} 
		
		alert("提交成功！");
	});
});