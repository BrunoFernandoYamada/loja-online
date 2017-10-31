<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Incluindo DataTable css -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Glyphicons css for bootstrap 4 -->
<link href="${css}/glyphicons.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>
			</div>
		</nav>

		<!-- Page Content -->

		<div class="content">
		
			<div class="container">
				
				<div class="row">
				
					<div class="col-xs-12 col-ms-12 col-md-12 col-lg-12 text-center">
							
						<div class="jumbotron">
						
							<h1>${errorTitle}</h1>
							<hr/>
							
							<blockquote style="word-wrap: break-word">
							
								${errorDescription}
								
							</blockquote>
						
						</div>
							
					</div>
				
				</div>
			
			</div>
		</div>

		<!-- /.container -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

	</div>
	
</body>

</html>
