$(document).ready(function(){

    $('.add2cart').on("click",function(){
        // alert("dwaawda");
        var prodId = $(this).data('product-id');
        $.ajax({
            url: '/cart/product/' + prodId,
            dataType: 'JSON',
            type: 'GET',
            success: function(response){
                $('#totalAmount').html(response.totalAmount);
                $('#totalCost').html(response.totalCost);
                $('#productTitle').html(response.productTitle);
                // alert( "Всего добавлено товаров: " + response.totalAmount + "   На сумму: " + response.totalCost);
            }

        });

    });
});