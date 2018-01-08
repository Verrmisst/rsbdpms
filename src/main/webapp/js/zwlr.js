$(document).ready(function(){
	$("#ddlr").click(function(){
		
		$("#ifr",window.parent.document).attr("src","showSingle");
		
		
		
	});
	$("#Excels").click(function(){
		$("#ifr",window.parent.document).attr("src","showExcel");
	});
});