/*$(document).ready(function(){*/
$(function() {
	
/*//	ajax获取菜单列表
	$.ajax({
		type:"get",
		url:"pagecontent.action",
		async:true,
		success:function(obj){
			
			var data = eval('(' + obj + ')');
			var str=new Array;
			var strs=new Array;
			var list="";
			var lists="";
			var listss="";
			for(var i=0;i<data.length;i++){
				if(data[i].id==1){
					str.push(data[i].funcName);
				}
				if(data[i].id==6){
					strs.push(data[i].funcName);
				}
			}
			$.each(data, function(i,item){
				if(item.id==1){
					list=item.funList[0].childFuncName;
					lists+="<li onclick=\"$('#ifr').attr('src','"+item.url+"');\"><a href=\"javascript:;\"><img id=\"img\" src=\"img/sj.png\"/>"+list+"</a></li>";
				}
				if(item.id==6){
					list=item.funList[0].childFuncName
					listss+="<li onclick=\"$('#ifr').attr('src','"+item.url+"');\"><a href=\"javascript:;\"><img id=\"img\" src=\"img/sj.png\"/>"+list+"</a></li>";
				}
			});
			var yggl="<div><h3><img src=\"img/staff.png\"><span>"+str[0]+"</span></h3><ul class=\"ulo\">"+lists+"</ul></div>";
			var	ssgl="<div><h3><img src=\"img/staff.png\"><span>"+strs[0]+"</span></h3><ul class=\"ulo\">"+listss+"</ul></div>";
			var total=yggl+ssgl;
			$("#x").append(total);
		}
	});*/
	$.ajax({
		type:"get",
		url:"pagecontent.action",
		async:true,
		success:function(data){
			var pagecontent = data.pageContent;
			var content = eval("("+pagecontent+")");
			var str = new Array();
			var strs = new Array();
			var list="";
			var lists="";
			var listss="";
			for(var i=0;i<content.length;i++){
				if(content[i].id==1){
					str.push(content[i].funcName);
				}
				if(content[i].id==6){
					strs.push(content[i].funcName);
				}
			
			}
			$.each(content, function(i,item){
				if(item.id==1){
					list=item.funList[0].childFuncName;
					lists+="<li onclick=\"$('#ifr').attr('src','"+item.funList[0].childUrl+"');\"><a href=\"javascript:;\"><img id=\"img\" src=\"img/sj.png\"/>"+list+"</a></li>";
				}
				if(item.id==6){
					list=item.funList[0].childFuncName;
					listss+="<li onclick=\"$('#ifr').attr('src','"+item.funList[0].childUrl+"');\"><a href=\"javascript:;\"><img id=\"img\" src=\"img/sj.png\"/>"+list+"</a></li>";
				}
			});
			
			var yggl = "";
			var	ssgl = "";
			
			if(str[0] != null){
			 yggl+="<div><h3><img src=\"img/staff.png\"><span>"+str[0]+"</span></h3><ul class=\"ulo\">"+lists+"</ul></div>";
			}
			
			if(strs[0] != null){
			ssgl+="<div><h3><img src=\"img/staff.png\"><span>"+strs[0]+"</span></h3><ul class=\"ulo\">"+listss+"</ul></div>";
			}
			var total=yggl+ssgl;
			
			$("#x").append(total);
		}
	});
	
	
//	批量操作的取消按钮
	$("#qx").click(function(){
		$("#tc").css("display","none");
	});
//	修改密码的取消按钮
	$("#qxmm").click(function(){
		$("#xgmm").css("display","none");
	});
//	添加借用的取消按钮
	$("#qxty").click(function(){
		$("#jy").css("display","none");
	});
//	添加通报的取消按钮
	$("#qxtb").click(function(){
		$("#jt").css("display","none");
	});
//	xx管理员你好 按钮
	$("#gly").click(function(){
		$("#xgmm").css("display","block");
	});

	
//	添加借用提交按钮判断	
	/*$("#tjty").click(function(){
		var inputs=$("#jy input",window.parent.document);
		var ygbh=inputs[0].value;
		var jywp=inputs[4].value;
		if(ygbh==""){
			alert("请填写员工编号");
			 return false;
		}
		
		if(jywp==""){
			alert("请填写借用物品");
			 return false;
		}
		
	});*/
//	修改密码修改按钮判断
	$("#changepass").submit(function(){
		var inputs=$("#xgmm input");
		
		if (inputs[1].value=="") {
			alert("密码不能为空！");
			return false;
		}
		if (inputs[2].value=="") {
			alert("确认密码不能为空！");
			return false;
		}else if (inputs[2].value!=inputs[1].value) {
			alert("两次输入密码不同！");
			return false;
		}
	});
//	添加通报提交按钮判断
	/*$("#tjtb").click(function(){
		var inputs=$("#jt input",window.parent.document);
		var ygbh=inputs[0].value;
		var tbyy=inputs[5].value;
		var cfje=inputs[5].value;
		if(ygbh==""){
			alert("请输入员工编号");
			 return false;
		}
		if(tbyy==""){
			alert("请输入通报原因");
			 return false;
		}
		if(cfje==""){
			alert("请输入处罚金额");
			 return false;
		}
	});*/
	

});
