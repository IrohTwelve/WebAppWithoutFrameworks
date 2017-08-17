<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

    <h1>Hello From JSP!!!</h1>

    <a href="<c:url value="/root/login"/> ">Login page</a><br>

    <a href="<c:url value="/root/categories"/>">Categories</a><br>
    <a href="<c:url value="/root/registration"/>">Registration</a><br>
    <a href="<c:url value="/root/adminPage"/>">Admin Page</a><br>
    <<a href="<c:url value="/root/userPage"/>">User page</a>
</body>
</html>