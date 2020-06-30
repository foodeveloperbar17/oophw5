<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Store</title>
</head>
<body>

<h1>Student store</h1>

<p>Items available:</p>

<ul>
    <c:forEach var="product" items="${products}">
        <a href="show-product.jsp?id=${product.id}">
            <li>${product.name}</li>
        </a>
    </c:forEach>
</ul>

</body>
</html>
