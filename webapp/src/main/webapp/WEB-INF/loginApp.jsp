<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>

<body>

<div class="og" id="glob">
    <br>
    <h1>ANALIZATOR FINANSOWY</h1>
    <br>
    <br>
    Aby przejsc dalej musisz sie zalogowac
    <form action="finanse/start" method="GET">
        <button type="submit">Zaloguj</button>
    </form>
</div>
</body>
</html>
