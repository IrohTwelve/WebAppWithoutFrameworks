<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>

    <h3>Categories page</h3>
        <c:forEach var="e" items="${categories}">
            <h5><c:out value="${e.name}"/> </h5>
        </c:forEach><br>

    <a href="<c:url value="/root/home"/> ">Back to home</a><br>

</body>
</html>
