$(document).ready(function(){
	$("#bd").submit(function(){
		var fjh=$("#dl input")[0].value;
		var ygbh=$("#dl input")[1].value;
		var xm=$("#dl input")[3].value;
		var sj=$("#dl input")[4].value;
		if(fjh==""){
			alert("请输入房间号！");
			return false;
		}
		if(ygbh==""){
			alert("请输入房间人数！");
			return false;
		}
		if(xm==""){
			alert("请输入分类！");
			return false;
		}
		if(sj==""){
			alert("请输入备注1！");
			return false;
		}
		alert("提交成功！");
	})
})