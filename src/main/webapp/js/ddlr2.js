$(document).ready(function() {
	

	$("#ss").click(function() {

		var dept = $("#dept").val();
		var duty = $("#duty").val();

		/*
		 * if (roomCode==""&&bulidName==""&&dept==""&&duty=="") {
		 * alert("请至少输入一个搜索项"); return false; }
		 */

		$.get("showroomsituation.action", {
			dept : dept,
			duty : duty
		}, function(data) {
			$("#chax").html(data);

		});

	});
})