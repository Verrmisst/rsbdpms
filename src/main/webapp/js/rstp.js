$(document).ready(function(){
	
	$("#ssk").submit(function(){
		$("#iiframe").attr("src","showstaff");
		var inputs=$("#ssk input")[0].value;
		if (inputs=="") {
			alert("请填写员工编号！");
			return false;
		}
	});
	
	$("#renshi").submit(function(){
		/*var f=this.parentNode.parentNode;
		var fx=f.getElementsByClassName("xx");
		for(var i=0;i<fx.length;i++){
			if(fx[i].value==""){
				alert("请填写科室或者职务！");
				return false;
			}
		}*/
		alert("提交成功!");
	});
});