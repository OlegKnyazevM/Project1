<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
    <%--<title><tiles:getAsString name="title" /></title>--%>
</head>
<body>
<!-- Header -->
<tiles:insertAttribute name="header"/>
<!-- Body -->
<tiles:insertAttribute name="body"/>
<!-- Footer -->
<tiles:insertAttribute name="footer"/>
</body>
</html>