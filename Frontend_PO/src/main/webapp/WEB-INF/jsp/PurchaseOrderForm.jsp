<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="js" value="${pageContext.request.contextPath}/resources/js" scope="application"/>
<jsp:include page="BuyerNavbar.jsp"></jsp:include>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Order Form</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="${js}/script.js"></script>
	
<script>
$(document).ready(function(){
	 $(".add-row").click(function(){
		console.log('I m clicked');
        var items = $(".name option:selected").val();
        var quantity = $("#quantity").val();
        
        console.log('Selected Product : '+items);
        console.log('Quantity : '+quantity);
        
        $.get("getProductById?productId="+items, function(data, status){
            productObj=data;
            console.log('Hello : '+productObj.productName);
            
            
            var markup = "<tr><td><input type='checkbox' name='record'></td> <td>"+items+"</td><td>" + productObj.productName + "</td><td>" + quantity + "</td></tr>";
            $("table").append(markup);
             
          });
        
        
    }); 
    
    // Find and remove selected table rows
   /*  $(".delete-row").click(function(){
        $("table tbody").find('input[name="record"]').each(function(){
            if($(this).is(":checked")){
                $(this).parents("tr").remove();
            }
        });
    }); */
   
    
});  
</script>


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
	
<h1 style="color: green;">Create Purchase Order</h1>
 		<form action="createPurchaseOrder" method="post">
 	<select class="form-control name" name="items">
						<option value="">Select your products</option>
						<c:forEach items="${productDetails}" var="pObj">
						<option value="${pObj.productId} "> 
							${pObj.productName} 
						</option>
						</c:forEach>
						</select>
						<input type="number" min="0" pattern="\d*"  class="form-control" placeholder="Quantity" id="quantity" required/>
						<input type="button" value="Add"	class="btn btn-success add-row" />



		    <table class="table-responsive table-dark table table-hover">
        <thead>
            <tr>
                <th>Select</th>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>quantity</th>
            </tr>
        </thead>
        <tbody>
        
        </tbody>
  </table>
			<div class="row">
			<div class="col">	<button type="button" class="delete-row">Delete Row</button>
			</div>		
	<div class="col"><input type="button" value="submit"	class="btn btn-primary" id="createPurchaseOrder"/></div>
		</div>

	
	</form>
	</div>
	</body>
	 <script>
	$(document).ready(function(){
		 
		var purchaseOrderList = [];
	    $("#createPurchaseOrder").click(function() {
	    	console.log('Hello 1');
	    	var table = $("table tbody");
	    	console.log('Hello 2');
	    	 
	    	table.find('tr').each(function (i, el) {
	    		 console.log('Hello 3');
	    	        var $tds = $(this).find('td'),
	    	        	
	    	            pId = $tds.eq(1).text(),
	    	            Quantity = $tds.eq(3).text();
	    	        
	    	        // do something with productId, product, Quantity
	    	        
	    	        
	    	        
	    	        var myObj = {
	    	        		  productId: pId,
	    	        		  quantity:Quantity
	    	        		  
	    	        		};
	    	        purchaseOrderList.push(myObj);
	    	    });
	    	console.log(purchaseOrderList);
	    	
	     
	    $.ajax({
	        type: "POST",
	        url: "createPurchaseOrder",
	        data: JSON.stringify(purchaseOrderList),
	        contentType: "application/json; charset=utf-8",
	        
	        success: function(data){
	        	console.log('I m Success : '+data);
	            alert('Purchase Order has been created');
	       },
	        error: function(err) {
	        	console.log('I m error '+err);
	            
	        }
	});
	});
	}); 
	</script> 
</html>