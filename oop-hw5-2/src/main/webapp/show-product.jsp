<%@ page import="utils.ServletUtils" %>
<%@ page import="database.Database" %>
<%@ page import="models.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<% Database database = (Database) application.getAttribute(ServletUtils.DATABASE_KEY);
    Product product = database.getProductById(request.getParameter("id"));
%>
<head>
    <title><%= product.getName() %>
    </title>
</head>
<body>

<h1>
    <%= product.getName()%>
</h1>

<img src="<c:url value="images/"/><%= product.getImageFile()%> ">
<p>$<%= product.getPrice()%>
</p>
<form action="shoppingCart" method="post">
    <input name="productID" type="hidden" value=<%=product.getId()%>>
    <button type="submit" id="add_to_cart_button">Add to Cart</button>
</form>
</body>
</html>
