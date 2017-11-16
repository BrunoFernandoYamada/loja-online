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

		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">

			<!-- Loading home page -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Loading about page -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Loading contact us page -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- Load only when user clicks View products -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp" %>
			</c:if>
			
			<!-- Load only when user clicks show product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp" %>
			</c:if>
			
			<!-- Load only when user clicks show product -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp" %>
			</c:if>

		</div>

		<!-- /.container -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/popper.min.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
		
		<!-- Bootbox.js -->
		<script src="${js}/bootbox.min.js"></script>

		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
