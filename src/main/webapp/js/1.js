	$(function() {

		var pgnum = $("#pagenum").val();
		var pgcount = $("#pagecount").val();

		

		$("#ss").click(
				function() {
					var staffcode = $("#ssk input")[0].value;
					var staffname = $("#ssk input")[1].value;
					var roomcode = $("#ssk input")[2].value;
					var buildname = $("#ssk select")[0].value;
					var dept = $("#ssk select")[1].value;
					var duty = $("#ssk select")[2].value;
					var bd = $("#datetimeBegin").val();
					var ed = $("#datetimeEnd").val();

					if (staffcode == "" && staffname == "" && roomcode == ""
							&& buildname == "" && dept == "" && duty == ""
							&& bd == "" && ed == "") {
						alert("请至少填写一个搜索项");
						return false;
					}

					$.ajax({
						url : "showblurstaff",
						async : true,
						type : 'post',
						data : {
							'staffCode' : staffcode,
							'staffName' : staffname,
							'roomCode' : roomcode,
							'buildName' : buildname,
							'department' : dept,
							'duty' : duty,
							'pageNum' : pgnum,
							'pageCount' : pgcount,
							'beginDate' : bd,
							'endDate' : ed,
						},
						success : function(data) {

							$("#inp").empty();
							$("#inp").html(data);
							
							$("#firstpage").attr("href","");
							
							var pagenum = $("#pgNum").val();
							var pagecount = $("#pgCount").val();

							$("#firstpage").click(function() {

								alert(1);
								/* $.ajax({
									url : "showblurstaff",
									async : false,
									type : 'post',
									data : {
										'staffCode' : staffcode,
										'staffName' : staffname,
										'roomCode' : roomcode,
										'buildName' : buildname,
										'department' : dept,
										'duty' : duty,
										'beginDate':bd,
										'endDate':ed,
										'pageNum' : 0
													},
									success:function(data){
										
										 $("#inp").html(data); 
									}
								}); */

							});

						}

					});

					/* $.post("showblurstaff", {
						staffCode : staffcode,
						staffName : staffname,
						roomCode : roomcode,
						buildName : buildname,
						department : dept,
						duty : duty,
						pageNum : pgnum,
						pageCount : pgcount
					}, function(data) {
						$("#bottom").html(data);

						var pagenum = $("#pgNum").val();
						var pagecount = $("#pgCount").val();


						$("#firstpage").click(function() {
							
							alert(buildname);
							
							
							$.ajax();
							
							$.post("showblurstaff", {
								staffCode : staffcode,
								staffName : staffname,
								roomCode : roomcode,
								buildName : buildname,
								department : dept,
								duty : duty,
								pageNum : 0
							}, function(html) {
								
								alert(1);
								
								alert(html);
								
								$("#bottom").html(html);
							});

						});

						$("#previouspage").click(function() {
							$.post("showblurstaff", {
								staffCode : staffcode,
								staffName : staffname,
								roomCode : roomcode,
								buildName : buildname,
								department : dept,
								duty : duty,
								pageNum : pagenum - 1
							}, function(data) {
								$("#bottom").html(data);
							});

						});

						$("#nextpage").click(function() {

							$.post("showblurstaff", {
								staffCode : staffcode,
								staffName : staffname,
								roomCode : roomcode,
								buildName : buildname,
								department : dept,
								duty : duty,
								pageNum : pagenum + 1
							}, function(data) {
								$("#bottom").html(data);
							});

						});

						$("#lastpage").click(function() {
							$.post("showblurstaff", {
								staffCode : staffcode,
								staffName : staffname,
								roomCode : roomcode,
								buildName : buildname,
								department : dept,
								duty : duty,
								pageNum : pagecount - 1
							}, function(data) {
								$("#bottom").html(data);
							});

						});
					}); */

				});
	});