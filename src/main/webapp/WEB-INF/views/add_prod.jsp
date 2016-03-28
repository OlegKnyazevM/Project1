<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<div class="body">
    <form action="/product/add" method="POST">
        Title: <input type="text" name="title" value="">
        Description: <input type="text" name="description" value="">
        <%--Price: <input type="text" name="price">--%>
        <input type="submit" value="SAVE">

    </form>
</div>