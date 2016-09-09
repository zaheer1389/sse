<%@ page language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link href="<c:url value="/resources/css/font-awesome-4.4.0/css/font-awesome.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jtable.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery.js" />" ></script>
<script src="<c:url value="/resources/js/jquery-ui.js" />" ></script>
<%-- <script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script> --%>
<script src="<c:url value="/resources/js/paging.js" />" ></script>

<div class="main-header" style="position: relative">
	<div class="header">
		<div class="logo">
			<div class="inner">
				<div class="logo-image"><img src="<c:url value="/resources/img/sse-logo.png" />" ></div>
				<div><h1><span class="logo-text">SS ENGINEERING</span></h1></div>
			</div>
		</div>
		<div class="user-info">
			<div class="greet-text"><i class="fa fa-user"></i> Welcome,Admin[<a href="/ssengineering/j_spring_security_logout">Logout</a>]</div>
		</div>
	</div>	
</div>

<div class="top-navigation">
	<div id='cssmenu'>
		<ul>
		   <li><a href='/ssengineering/home/'><span>Home</span></a></li>
		   <li class='has-sub'><a href='#'><span>Products</span></a>
		      <ul>
		         <li class='sub'><a href='/ssengineering/parts/'><span>Parts</span></a>
		            <!-- <ul>
		               <li><a href='#'><span>Sub Item</span></a></li>
		               <li class='last'><a href='#'><span>Sub Item</span></a></li>
		            </ul> -->
		         </li>
		         <li class='sub'><a href='/ssengineering/subparts/'><span>Sub Parts</span></a>
		            <!-- <ul>
		               <li><a href='#'><span>Sub Item</span></a></li>
		               <li class='last'><a href='#'><span>Sub Item</span></a></li>
		            </ul> -->
		         </li>
		      </ul>
		   </li>
		   <li class='has-sub'><a href='#'><span>Customer</span></a>
		      <ul>
		         <li class='sub'><a href='/ssengineering/customer/'><span>Manage Customers</span></a></li>
		      </ul>
		   </li>
		   <li><a href='/ssengineering/purchase/'><span>Purchase</span></a></li>
		   <li ><a href='/ssengineering/sale/'><span>Sale</span></a></li>
		</ul>
	</div>
</div>

<script type="text/javascript">
	$('body').css('margin','0px');
	$('body').css('min-height','400');
	$('body').css('min-width','600');
	
	$( window ).resize(function() {
		$('#jtableContainer').height($(window).height() - ($('.main-header').height()+$('.top-navigation').height()
				+$('.jtable-title').height()+$('.jtable-bottom-panel').height()));
	});
	
	
</script>