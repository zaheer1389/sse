<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> :: SSE - Home :: </title>
</head>
<body>
	<div class="site-container">
		<%@ include file="header.jsp" %>
		<div class="content">
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){		
			$('.content').height($(window).height() - ($('.main-header').height()+$('.top-navigation').height())-10);
			$($('#cssmenu li')[0]).addClass('active');
	    });
	</script>	
</body>
</html>