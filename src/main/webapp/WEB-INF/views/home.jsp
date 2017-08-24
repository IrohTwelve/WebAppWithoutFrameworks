<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

    <h1>You are <del>not</del> welcome here</h1>

    <a href="<c:url value="/root/login"/>">Login Page</a><br>
    <a href="<c:url value="/root/registration"/> ">Registration Page</a><br>

</body>
</html>