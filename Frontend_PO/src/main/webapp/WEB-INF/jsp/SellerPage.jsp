<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <jsp:include page="SellerNavbar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller Page</title>
</head>
<SCRIPT type="text/javascript">
		console.log('I m here');
    	window.history.forward();
    	function noBack() {
    		window.history.forward();
    		
    	}
</SCRIPT>

	<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="noBack()">
		
		<div align="center">
			<h1>Welcome Admin</h1>
		</div>
	</body>
</html>