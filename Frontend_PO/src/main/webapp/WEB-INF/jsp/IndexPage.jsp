<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<c:set var="img" value="${pageContext.request.contextPath}/resources/img" scope="application"/>
<c:set var="css" value="${pageContext.request.contextPath}/resources/css" scope="application"/>
<c:set var="js" value="${pageContext.request.contextPath}/resources/js" scope="application"/>

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
            <div class="login-form">
               <form action="login" method="post">
                  <div class="form-group">
                     <label>Email Address</label>
                     <input type="text" class="form-control" name="email" placeholder="Email Address">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" name="password"placeholder="Password">
                  </div>
                  <button type="submit" class="btn btn-black" value="login">Login</button>
                   <br/>
                   <br/>
                   Not a member?
                  <a href="getRegistrationForm">Register</a>
               </form>
            </div>
         </div>
      </div>
</body>
</html>