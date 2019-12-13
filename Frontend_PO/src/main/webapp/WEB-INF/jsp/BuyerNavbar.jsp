<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">PO Management Tool</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="getPurchaseOrderForm">Create Purchase Order</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="purchaseOrderBuyer">Purchase Orders</a>
    </li>
     <li class="nav-item">
     <a class="nav-link" style="align:Right">Welcome ${sessionScope.uObj.userName}</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="logout">Logout</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
</div>

</body>
</html>
