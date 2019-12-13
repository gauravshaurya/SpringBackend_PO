<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <jsp:include page="VendorNavbar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor Page</title>
</head>

<SCRIPT type="text/javascript">
		console.log('I m here');
    	window.history.forward();
    	function noBack() {
    		window.history.forward();
    		
    	}
</SCRIPT>

	<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="noBack()">
	</body>
</html>