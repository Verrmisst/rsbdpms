$(document).ready(function(){
	var xsmm=$("#glzh .xsmm");
	var del=$("#glzh .del");
	var xgmm=$("#glzh .xgmm")
	for(var i=0;i<xsmm.length;i++){
		xsmm[i].onclick=function(){
			var f=this.parentNode.parentNode;
			var inputs=f.getElementsByTagName("input")[0];
			if(inputs.type=="text"){
				inputs.type="password";
				this.innerHTML="显示密码";
			}else{
				inputs.type="text";
				this.innerHTML="隐藏密码";
			}
		}
		del[i].onclick=function(){
			if (confirm("你确定删除吗？")){
	            var f=this.parentNode.parentNode;
				f.parentNode.removeChild(f);
	        }  
		}
		xgmm[i].onclick=function(){
			$("#xgmm",window.parent.document).css("display","block");  
		}
	}
})