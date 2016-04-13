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
                <li>Last Added : <span id="productTitle">0</span> </li>
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
                        <input id="cart_btn_add" class="btn add2cart" type="button" value="Add position"
                               data-product-id="${product.id} "/>
                        <input id="cart_btn_dell" class="btn add2cart" type="button" value="Delete"
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
