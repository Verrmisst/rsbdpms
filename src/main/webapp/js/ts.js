$(document).ready(function(){
		$("#tsss").click(function(){
			var inputs=$("#ts input");
			if (inputs[2].value=="") {
				alert("请填写房间号");
				return false;
			}
			
			alert("提交成功！");
		});
		$("#tssq").click(function(){
			$("#ifr",window.parent.document).attr("src","showpagingdorm");
		});
})