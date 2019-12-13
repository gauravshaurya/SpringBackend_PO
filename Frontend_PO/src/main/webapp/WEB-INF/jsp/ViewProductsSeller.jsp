<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="SellerNavbar.jsp"></jsp:include>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<SCRIPT type="text/javascript">
		console.log('I m here');
    	window.history.forward();
    	function noBack() {
    		window.history.forward();
    		
    	}
</SCRIPT>

	<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="noBack()">
	<div class="container">
		<h1 style="color: green;">Products List</h1>
		
		<table class="table table-borderless  table table-hover table-dark">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productDetails}" var="obj">
				<tr>
					<td>
						${obj.productId}
					</td>
					<td>
						${obj.productName}
					</td>
					<td>
						${obj.productPrice}
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	</body>
</html>