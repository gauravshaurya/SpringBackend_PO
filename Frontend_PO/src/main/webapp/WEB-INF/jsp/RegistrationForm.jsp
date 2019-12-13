<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<c:set var="css" value="${pageContext.request.contextPath}/resources/css" scope="application"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Home Page</title>
<link href="${css}/style.css" rel="stylesheet"/>
</head>
<body>
<div class="sidenav">
         <div class="login-main-text">
            <h2>Welcome To<br>Purchase Order<br>Management Tool</h2>
         </div>
      </div>
      <div class="main">
      <div class="col-md-6 col-sm-12">
      <br><br><br><br>
               <h1 align="center">Registration Form</h1>
<hr/>		
<fieldset>
        <f:form action="registerUser" method="post" modelAttribute="uObj">
            <table>
             	<tr>
                    <td>Buyer Name:</td>
                    <td><f:input path="userName" required="true"/></td>
                </tr>
                <tr>
                    <td>Phone No:</td>
                    <td><f:input path="phone" required="true"/></td>
                </tr>
                <tr>
                    <td>Email ID:</td>
                    <td><f:input path="email" required="true"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><f:input path="address.houseNumber" required="true" placeholder="House No."/></td>
                </tr>
             	<tr>
                    <td/>
                    <td><f:input path="address.address1"  required="true" placeholder="Address Line1"/></td>
                </tr>
                <tr>
                    <td/>
                    <td><f:input path="address.address2"  required="true" placeholder="Address Line2"/></td>
                </tr>
                <tr>
                    <td/>
                    <td><f:input path="address.city" size="15" required="true" placeholder="City"/></td>
                </tr>
                <tr>
                    <td/>
                 	<td><f:input path="address.state" size="15" required="true" placeholder="State"/></td>
                </tr>
                <tr>
                    <td/>
                    <td><f:input path="address.pincode" size="15" required="true" placeholder="Pincode"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><f:input path="password" required="true"/></td>
                </tr>
                <tr>
                    <td><button type="submit" class="btn btn-black" value="register">Register</button></td>
                </tr>      
            </table>
                   Already a member?
                  <a href="getLoginPage">Login</a>
               </f:form>
               </fieldset>
         </div>
      </div>
</body>
</html>