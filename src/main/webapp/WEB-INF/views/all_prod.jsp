<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class=" body">
    <c:forEach var="product" items="${products}">
        <table border="0">
            <tr>
                <td rowspan="4"><img src="/resources/img/noPhoto.jpg"></td>
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
                    <input id="cart_btn" class="btnBody" class="btn_add2cart" type="button" value="Add to cart"
                           data-product-id="${product.id} "/>
                    <a href='${product.id}'>
                        <input type="button" class="btnBody" value="View" data-product-id="${product.id}">
                    </a>
                </td>
            </tr>
        </table>
    </c:forEach>
</div>