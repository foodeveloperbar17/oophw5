<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
    <body>
        <h1>${h1Message}</h1>

        <p>${additionalMessage} </p>

        <form action="/oop-hw5/create" method="post">
            <input name="name" type="text" placeholder="username">
            <br>
            <input name="password" type="password" placeholder="password">
            <br>
            <input name="submitButton" type="submit" value="submit">
        </form>

    </body>
</html>
