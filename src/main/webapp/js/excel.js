$(document).ready(function(){
	$("#sub").click(function(){
		var wj=$("#wj").val();
		if (wj=="") {
			alert("请选择文件！");
			return false;
		}
		alert("提交成功！");
	})
})