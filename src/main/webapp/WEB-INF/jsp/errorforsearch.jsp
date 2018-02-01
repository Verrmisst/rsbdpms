<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

	<style type="text/css">
		body{
			  background: -webkit-radial-gradient(#fff, #f2f9fd); /* Safari 5.1 - 6.0 */
  			background: -o-radial-gradient(#fff, #f2f9fd); /* Opera 11.6 - 12.0 */
  			background: -moz-radial-gradient(#fff, #f2f9fd); /* Firefox 3.6 - 15 */
				background: radial-gradient(#fff, #f2f9fd); /* 标准的语法 */;
		}
		.box{
			position: absolute;
	    top: -170px;
	    bottom: 0;
	    left: 0;
	    right: 0;
	    width: 560px;
	    height: 68px;
	    text-align: center;
	    margin: auto;
	    color: #908e8e;
		}
		
		.box2{
			position: absolute;
	    top: 120px;
	    bottom: 0;
	    left: 0;
	    right: 0;
	    width: 560px;
	    height: 68px;
	    text-align: center;
	    margin: auto;
	    color: #908e8e;
		}
		
		.box3{
			position: absolute;
	    top: 310px;
	    bottom: 0;
	    left: 0;
	    right: 0;
	    width: 560px;
	    height: 68px;
	    text-align: center;
	    margin: auto;
	    color: #908e8e;
		}
	</style>
  
  	<div class="box">
	    <h2>${text}</h2>
    </div>
    
    <div class="box2">
    	<h2>${text2}</h2>
    </div>
    <div class="box3">
    	<h2>${info}</h2>
    </div>
