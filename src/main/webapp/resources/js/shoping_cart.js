$(document).ready(function(){

    $(".add2card").on('click',function(){
        var prodId = $(this).data('product-id');
        $.ajax({
            url: "/cart/product/" + prodId,
            dataType: "JSON",
            type: "GET",
            success: function(msg){
                alert( "Добавлено: " + msg );
            }
        });


    });
});