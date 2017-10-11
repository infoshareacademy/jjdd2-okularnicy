<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatibile" content="ie-edge, chrome-1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="Okularnicy">
    <link href="resources/fotolia-80738841.png" rel="shortcut icon"  type="image/x-icon">
    <meta name="description" content="">
    <title>ANALIZATOR FINANSOWY</title>

    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">

    <%--no cache--%>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
</head>

<body>
<header>
    <nav class=nav>
        <ul>
            <li><a href="start">STRONA GŁÓWNA</a></li>
            <li><a href="analizator">FUNDUSZ/<br>WALUTA</a></li>
            <li><a href="extremaGlobalne">EKSTREMA GLOBALNE</a></li>
            <li><a href="DataRange">EKSTREMA LOKALNE</a></li>
            <li><a href="https://www.google.pl">WYJŚCIE</a></li>
        </ul>
    </nav>
</header>

<div class="og" id="loc">
    <h1> EKSTREMA LOKALNE </h1>

    <p>Wartość minimalna: ${fundMinDate} => ${fundMinClose}</p>
    <br>
    <p>Wartość maksymalna: ${fundMaxDate} => ${fundMaxClose}</p>
</div>
</body>
</html>