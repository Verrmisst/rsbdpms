<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

		<link rel="stylesheet" href="css/single.css" />
		<script type="text/javascript" src="js/jquery-1.8.2.js" ></script>
		<script type="text/javascript" src="js/ygtb.js" ></script>
		<script type="text/javascript">
			
			$(function(){
				
				var pagenum = $("#pgnum").val();
				var pagecount = $("#pgcount").val();
				
				
				
				$.get("notificepaging",{pageNum:pagenum,pageCount:pagecount},function(data){
					
					$("#bottom").html(data);
				});
				
			});
			
		
		</script>
		
		<title>员工通报</title>

		<div class="single">
			<div class="top">
				<h3>员工通报</h3>
				<input id="tjtb" type="button" value="添加通报" style="margin-top: 10px"/>
				<form class="ssk" id="ssk" action="searchnotifice" method="post">
					<input type="text" placeholder="请输入员工编号" name="staffCode"/>
					<button id="ss" type="submit">搜索</button>
				</form>
			</div>
			<input type="hidden" id="pgnum" value="${pageNum}" /> <input
							type="hidden" id="pgcount" value="${pageCount}" /> 
			<div class="bottom" id="bottom">
					
			</div>
		</div>

