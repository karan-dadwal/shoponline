<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url var="css" value="/resources/css" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Online - ${title}</title>

<!-- fixing menu select problem  -->
<script>
	contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap theme CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<!-- datatables bootstrap -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>


	<div class="wrapper">
		<!-- Including navbar -->

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
					</button>
					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>
				</div>
			</div>
		</nav>


		<!-- Page Content -->
		<div class="content">
			<div class="container">
				<div class="container">
					<div class="col-xs-12">

						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr>
							<blockquote style="word-wrap:break-word">${errorDesc}</blockquote>

						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Including footer -->

		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/popper.js"></script>

		<script src="${js}/bootstrap.min.js"></script>


		<!-- for jquery datatables -->
		<script src="${js}/jquery.dataTables.js"></script>

		<script src="${js}/dataTables.bootstrap.js"></script>


		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
