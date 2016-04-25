<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="/resources/js/shoping_cart.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/shoppingCart.css">


<div class=" body">
    <div class="left">

        <c:forEach var="item" items="${items}">
            <table border="0">
                <tr>
                    <td rowspan="5"><img src="/resources/img/noPhoto.jpg" class="noPhoto"></td>
                    <td>${item.product.title}</td>
                </tr>
                <tr>
                    <td>Price: ${item.product.price}</td>
                </tr>
                <tr>
                    <td>Description: ${item.product.description}</td>
                </tr>
                <tr>
                    <td>Quantity : ${item.quantity}</td>
                </tr>
                <tr>
                    <td>Product cost : ${item.totalItemPrice}</td>
                </tr>
                <tr>
                    <td>
                            <%--<input id="cart_btn_add" class="btn add2cart" type="button" value="Add position"--%>
                            <%--data-product-id="${item} "/>--%>
                            <%--<input id="cart_btn_dell" class="btn add2cart" type="button" value="Delete"--%>
                            <%--data-product-id="${product.id} "/>--%>

                        <div class="cart-amount" >
                            <a href="#" class="cart-amount-plus">
                                <img src="/resources/img/minus.png" width="25" height="25">
                            </a>
                            <input name="quantity" type="text" id="count" size="3" max="100" min="1"
                                   class="input-text cart-amount-input-text" value="${item.quantity}">
                            <a href="${product.id}" type="button" class="btn add2cart" data-product-id="${item.product.id}">
                                <img src="/resources/img/plus.png" width="25" height="25">
                            </a>
                        </div>
                    <td>
                        <a href='${product.id}'>
                            <input type="button" class="btnBody" value="View" data-product-id="${product.id}">
                        </a>
                    </td>
                    </td>
                </tr>
            </table>
        </c:forEach>
    </div>

</div>
<%--<script>--%>
    <%--$('.add2cart').on("click",function(){--%>
        <%--// alert("dwaawda");--%>
        <%--var prodId = $(this).data('product-id');--%>
        <%--$.ajax({--%>
            <%--url: '/cart/product/' + prodId,--%>
            <%--dataType: 'JSON',--%>
            <%--type: 'GET',--%>
            <%--success: function(response){--%>
                <%--$('#totalAmount').html(response.totalAmount);--%>
                <%--$('#totalCost').html(response.totalCost);--%>
                <%--$('#productTitle').html(response.productTitle);--%>
                <%--// alert( "Всего добавлено товаров: " + response.totalAmount + "   На сумму: " + response.totalCost);--%>
            <%--}--%>

        <%--});--%>

    <%--});--%>
<%--</script>--%>
