<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Hero</title>
    <!-- CSS Bootstrap v5.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
</head>
<body>
<div class="card mx-auto mt-5" style="width: 40rem;">
    <div class="card-body">
        <h5 class="card-title text-center">Create your Hero!</h5>
        <br>
        <form action="${pageContext.request.contextPath}/create" method="post">
            <div class="mb-3 row">
                <label for="inputName" class="col-sm-2 col-form-label">Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputName" name="name">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="inputIdentity" class="col-sm-2 col-form-label">Identity:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIdentity" name="identity">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="inputRadio" class="col-sm-2 col-form-label">Gender:</label>
                <div class="col-sm-10" id="inputRadio">
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="inputRadio1" name="gender" value="MALE">
                    <label class="form-check-label" for="inputRadio1">
                        Male
                    </label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="inputRadio2" name="gender" value="FEMALE">
                    <label class="form-check-label" for="inputRadio2">
                        Female
                    </label>
                </div>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="inputAge" class="col-sm-2 col-form-label">Age:</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputAge" name="age">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="inputAbility" class="col-sm-2 col-form-label">Ability:</label>
                <div class="col-sm-10">
                <select class="form-select" aria-label="Default select example" id="inputAbility" name="ability">
                    <option selected>Choose ability</option>
                    <c:forEach items="${requestScope.abilities}" var="ability">
                        <option value="${ability.id}">${ability.name}</option>
                    </c:forEach>
                </select>
                </div>
            </div>
            <button class="btn btn-success" type="submit">Button</button>
        </form>
    </div>
</div>
</body>
</html>
