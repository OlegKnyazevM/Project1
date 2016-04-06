$(document).ready(function(){

    $('.add2cart').on('click',function(){
        alert("DDDDD");
        var prodId = $(this).data('product-id');
        $.ajax({
            url: "/cart/" + prodId,
            dataType: "JSON",
            type: "GET",
            success: function(response){
                $('#cartQuantity').html(response.quantity);
                $('#cartCost').html(response.cost);
                
            }
        });

    });
});