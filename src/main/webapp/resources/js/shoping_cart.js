$(document).ready(function() {

    $('.add2cart').on("click", function (event) {
        event.preventDefault();
        // alert("dwaawda");
        var prodId = $(this).data('product-id');
        $.ajax({
            url: '/cart/product/' + prodId,
            dataType: 'JSON',
            type: 'GET',
            success: function (response) {
                $('#count').html(response.quantity);
                $('#totalAmount').html(response.totalAmount);
                $('#totalCost').html(response.totalCost);
                $('#productTitle').html(response.productTitle);

                // alert( "Всего добавлено товаров: " + response.totalAmount + "   На сумму: " + response.totalCost);
            }

        });

    });

    $('.add2cart2').on("click", function (event) {
        event.preventDefault();
        // alert("dwaawda");
        var prodId = $(this).data('product-id');
        $.ajax({
            url: '/cart/product/' + prodId,
            dataType: 'JSON',
            type: 'GET',
            success: function (response) {
                $('#count').html(response.quantity);
                $('#totalAmount').html(response.totalAmount);
                $('#totalCost').html(response.totalCost);
                $('#productTitle').html(response.productTitle);
                location.reload();
                // alert( "Всего добавлено товаров: " + response.totalAmount + "   На сумму: " + response.totalCost);
            }

        });

        $('.decrFromCart').on("click", function (event) {
            event.preventDefault();
             alert("decr");
            var prodId = $(this).data('product-id');
            $.ajax({
                url: '/cart/product/decr/' + prodId,
                dataType: 'JSON',
                type: 'GET',
                success: function (response) {
                    $('#count').html(response.quantity);
                    $('#totalAmount').html(response.totalAmount);
                    $('#totalCost').html(response.totalCost);
                    $('#productTitle').html(response.productTitle);
                    location.reload();
                    // alert( "Всего добавлено товаров: " + response.totalAmount + "   На сумму: " + response.totalCost);
                }

            });

        });

        $('.deleteFromCart').on("click", function () {
            var id_prod = $(this).data('product-id');
            // alert("Product id: " + id_prod);
            $.ajax({
                url: '/cart/delete/' + id_prod,
                // dataType: 'JSON',
                type: 'POST',
                success: function () {
                    location.reload();
                }
            });

        });
    });
})