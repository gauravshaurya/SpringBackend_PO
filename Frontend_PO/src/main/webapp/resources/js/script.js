$(document).ready(function(){
    	var productName;
        $(".add-row").click(function(){
            var items = $(".name option:selected").val();
            var quantity = $("#quantity").val();
            
            
            
            
            $.get("getProductNameById?productId="+items, function(data, status){
                productObj=data;
                
                
                var markup = "<tr><td><input type='checkbox' name='record'></td><td>"+items+"</td><td>" + productObj.productName + "</td><td>" + quantity + "</td></td>";
                $("table ").append(markup);
                
              });
            
            
        });
        
        // Find and remove selected table rows
        $(".delete-row").click(function(){
            $("table tbody").find('input[name="record"]').each(function(){
                if($(this).is(":checked")){
                    $(this).parents("tr").remove();
                }
            });
        });
       
        
    });

///naskfkjdsbvj
$(document).ready(function(){
	 
	var purchaseOrderList = [];
    $("#raisePO").click(function() {
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
        dataType: "json",
        success: function(data){
            console.log(data);
       },
        error: function(err) {
            console.log(err);
        }
    });
});
});

//////logout

