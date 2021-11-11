<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Heroes</title>
</head>
<body>
        <c:forEach items="${requestScope.all_heroes}" var="hero">
            <p><a href="${pageContext.request.contextPath}/heroInfo?id=${hero.id}">
                    ${hero.name}
            </a></p>
        </c:forEach>
</body>
</html>
