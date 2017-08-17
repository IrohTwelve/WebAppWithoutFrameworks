<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <br>
    <form method="post" action="<c:url value="/root/login"/>">
        <input title="UserName" type="text" name="userName" >
        <br>
        <input title="Password" type="password" name="password">
        <br>
        <button type="submit">Log in</button>
    </form>
    <br>
    <a href="<c:url value="/root/home"/> ">Home</a>

</body>
</html>