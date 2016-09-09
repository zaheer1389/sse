<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>:: Login - SSE ::</title>
	<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/font-awesome-4.4.0/css/font-awesome.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/jtable.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery.js" />" ></script>
	<script src="<c:url value="/resources/js/jquery-ui.js" />" ></script>
	<script src="<c:url value="/resources/js/paging.js" />" ></script>
	<script type="text/javascript">
		function setError(){
			$('#msg').append('${error}');
			$('#msg').css('color','red');
		}	
		function setLogoutMsg(){
			$('#msg').append('${logout}');
			$('#msg').css('color','green');
		}
		function setLogin(){
			$('#msg').append('${login}');
			$('#msg').css('color','red');
		}
	</script>
</head>
<body>
	
	<div class="main">
		<div class="login-form">
			<div style="  height: 140px;">
				<h1>SSE Login</h1>
				<div class="head">
					<img src="<c:url value="/resources/img/sse-logo.png" />" >
				</div>
			</div>
			<div id="msg" class="msg">
			</div>			
			<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
				<input type="text" autocomplete="off" name="username" class="text" value="USERNAME" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'USERNAME';}" >
				<input type="password" autocomplete="off" name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				<div class="submit">
					<input type="submit" value="LOGIN" >
				</div>	
				<p><a href="#">Forgot Password ?</a></p>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			</div>			 
		</div>
		
		
	<c:if test="${not empty error}">
		<script type="text/javascript">
			setError();
		</script>
	</c:if>
	<c:if test="${not empty logout}">
		<script>			
			$(document).ready(function(){
				$('#msg').append('${logout}');
				$('#msg').css('color','green');
		    });
		</script>		
	</c:if>
	<c:if test="${not empty login}">
		<script>
			setLogin();
		</script>		
	</c:if>
</body>
</html>