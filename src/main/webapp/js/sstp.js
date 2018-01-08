$(document).ready(function(){
	var len=$(".ts");
	for(var i=0;i<len.length;i++){
		(function(i){
			len[i].onclick=function(){
				if (confirm("你确定删除吗？")){
		            var f=this.parentNode.parentNode;
					f.parentNode.removeChild(f);
		        }  
			}  
		})(i);
	}
	$("#ss").click(function(){
		var inputs=$("#ssk input")[0].value;
		if (inputs=="") {
			alert("搜索框不能为空！");
			return false;
		}
	})
	
	var btn=$("#inp .tss");
	for (var r=0;r<btn.length;r++) {
		btn[r].onclick=function(){
			var f=this.parentNode.parentNode;
			var inp=f.getElementsByClassName("ss");
			if (inp[0].value=="") {
				alert("宿舍号不能为空！")
				return false;
			}
			alert("调宿成功！");
		}
	}
});
  
        

