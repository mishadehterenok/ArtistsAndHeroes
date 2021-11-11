<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hero Info</title>
</head>
<body>
    <p>name: ${requestScope.full_info.name}</p>
    <p>identity: ${requestScope.full_info.identity}</p>
    <p>gender: ${requestScope.full_info.gender}</p>
    <p>age: ${requestScope.full_info.age}</p>
    <p>abilityName: ${requestScope.full_info.abilityName}</p>
</body>
</html>
