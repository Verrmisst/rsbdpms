$(document).ready(function(){
	$("#tjss").click(function(){
	
		$("#ifr",window.parent.document).attr("src","jsp/addroom.jsp");
	});
	var btn=$("#div button");
	for(var i=0;i<btn.length;i++){
		btn[i].onclick=function(){
			/*var f=this.parentNode.parentNode;
			var inputs=f.getElementsByTagName("input");
			if(inputs[0].value==""){
				alert("请输入房间人数");
				return false;
			}
			if(inputs[1].value==""){
				alert("请输入分类");
				return false;
			}
			*/
			alert("修改成功！");
		}
	}

});