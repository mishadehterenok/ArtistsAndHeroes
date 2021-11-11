<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JSTL Demo</title>
</head>
<body>
<ul>
    <c:forEach items="${requestScope.artists}" var="artist">
        <c:if test="${fn:length(artist.name) > 10}">
        <li>${artist.name} ${artist.age} : ${fn:length(artist.name)}</li>
        </c:if>
    </c:forEach>
</ul>
</body>
</html>
