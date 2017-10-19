<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>

<body>

<header>
    <jsp:include page="/shared/header.jsp"/>
</header>
<div class="og" id="glob">
    <h1> EKSTREMA GLOBALNE </h1>

    <p>Wartość minimalna: ${fundMinDate} => ${fundMinClose}</p>
    <br>
    <p>Wartość maksymalna: ${fundMaxDate} => ${fundMaxClose}</p>
</div>

</body>
</html>