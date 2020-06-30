<%@ page import="models.ShoppingCart" %>
<%@ page import="utils.ServletUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>

<h1>Shopping Cart</h1>
<form action="shoppingCart" method="post">
    <ul>
        <c:forEach var="productEntry" items="${sessionScope.shoppingCart.productsAndCounts}">
            <li>
                <input name="${productEntry.key.id}" type="text" value="${productEntry.value}">
                    ${productEntry.key.name}, $${productEntry.key.price}
            </li>
        </c:forEach>
    </ul>
    Total $${sessionScope.shoppingCart.totalPrice}
    <input type="submit" value="Update Cart">

    <br><br>
<%--    oop-hw5-2 is the name of the war file--%>
    <a href="/oop-hw5-2/">Continue shopping</a>
</form>
</body>
</html>
