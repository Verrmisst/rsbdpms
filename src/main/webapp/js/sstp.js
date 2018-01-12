$(document).ready(function(){
	/*var len=$(".ts");
	for(var i=0;i<len.length;i++){
		(function(i){
			len[i].onclick=function(){
				if (confirm("你确定删除吗？")){
					
		            var f=this.parentNode.parentNode;
					f.parentNode.removeChild(f);
		        }  
			}  
		})(i);
	}*/
	$("#ssk").submit(function(){
		var inputs=$("#ssk input")[0].value;
		if (inputs=="") {
			alert("请输入员工编号后，再进行搜索！");
			return false;
		}
	});
	
	var btn=$("#inp .tss");
	for (var r=0;r<btn.length;r++) {
		btn[r].onclick=function(){
			$("#ts").css("display","block");
		}
	}
	$("#tsss").submit(function(){
		var inputs=$("#ts input");
		for(var i=0;i<inputs.length;i++){
			if(inputs.value==""){
				alert("表单中不能为空！");
				return false;
			}
		}
		alert("提交成功！");
	});
	$("#tssq").click(function(){
		$("#ts").css("display","none");
	});
	
	
});
  
        

