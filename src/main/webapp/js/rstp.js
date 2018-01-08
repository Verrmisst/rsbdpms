$(document).ready(function(){
	var checkbox=$(".checkbox");
	$("#checkboxs").click(function(){
		for(var r=0;r<checkbox.length;r++){
			if(this.checked==true){
				checkbox[r].checked=true;	
			}else{
				checkbox[r].checked=false;
			}
		}
	});
	$("#plcz").click(function(){
		if($(".checkbox:checked").length>=2){			
			$("#tc",window.parent.document).css("display","block");
			$("#qr",window.parent.document).click(function(){
				var check=$(".checkbox:checked");
				for(var i=0;i<check.length;i++){
						var inp=check.parents("tr").find(".ks")[i];
						var inp1=check.parents("tr").find(".qw")[i];
						inp.value=$("#text",window.parent.document).val();
						inp1.value=$("#text1",window.parent.document).val();
				}				
			})
		}else{
			alert("请选择多条数据！")
		}
	})
	$("#ss").click(function(){
		var inputs=$("#ssk input")[0].value;
		if (inputs=="") {
			alert("搜索框不能为空！");
			return false;
		}
	})
});