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

    <div class="right">
        <div id="shoppingCart">
            <ul>
                <h2 align="middle">Shopping cart</h2>
                <li>Quantity : <span id="totalAmount">0</span></li>
                <li>TotalCost : <span id="totalCost">0</span></li>
                <li>Last Added : <span id="productTitle">not added</span> </li>
                <%--<button id="shoppingCartBtn" href="">--%>
                    <button id="shoppingCartBtn" onclick="javascript:window.location='/cart/showCart'">
                    <img src="/resources/img/ShoppingCart.png" width="70" height="70" alt="" style="vertical-align:middle"><br>
                    <div>Go to Shopping cart</div>
                </button>
            </ul>

        </div>

    </div>
    <div class="left">
        <c:forEach var="product" items="${products}">
            <table border="0">
                <tr>
                    <td rowspan="4"><img src="/resources/img/noPhoto.jpg" class="noPhoto"></td>
                    <td>${product.title}</td>
                </tr>
                <tr>
                    <td>Price: ${product.price}</td>
                </tr>
                <tr>
                    <td>Description: ${product.description}</td>
                </tr>
                <tr>
                    <td>
                        <input id="cart_btn" class="btn add2cart" type="button" value="Add to cart"
                               data-product-id="${product.id} "/>
                        <a href='${product.id}'>
                            <input type="button" class="btnBody" value="View" data-product-id="${product.id}">
                        </a>
                    </td>
                </tr>
            </table>
        </c:forEach>
    </div>
</div>

<%--<script>--%>
    <%--$(document).ready(function(){--%>

        <%--$('.add2cart').on('click',function(){--%>
            <%--alert("DDDDD");--%>
            <%--var prodId = $(this).data('product-id');--%>
            <%--$.ajax({--%>
                <%--url: "/cart/" + prodId,--%>
                <%--dataType: "JSON",--%>
                <%--type: "GET",--%>
                <%--success: function(response){--%>
                    <%--$('#cartQuantity').html(response.quantity);--%>
                    <%--$('#cartCost').html(response.cost);--%>

                <%--}--%>
            <%--});--%>

        <%--});--%>
    <%--});--%>
<%--</script>--%>