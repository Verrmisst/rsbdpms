$(document).ready(function(){
	$("form").submit(function(){
		var wj=$("#wj").val();
		if (wj=="") {
			alert("请选择文件！");
			return false;
		}
		alert("提交成功！");
	});
});