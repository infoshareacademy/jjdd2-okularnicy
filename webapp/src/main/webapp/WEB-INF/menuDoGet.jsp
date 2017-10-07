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
            <li><a href="analizator">FUNDUSZ</a></li>
            <li><a href="extremaGlobalne">EKSTREMA GLOBALNE</a></li>
            <li><a href="DataRange">EKSTREMA LOKALNE</a></li>
            <li><a href="https://www.google.pl">WYJŚCIE</a></li>
        </ul>
    </nav>

</header>
<article class="og" id="pokoje">

    <p class=" room">
        <a class="inroom" href="extremaGlobalne"><img src="${pageContext.request.contextPath}/resources/world.png"  title="" media-simple="true" style="height: 30vh;">
            <br>
            EKSTREMA GLOBALNE
        </a>
    </p>

    <p class="room">

        <a class="inroom" href="DataRange"><img src="${pageContext.request.contextPath}/resources/home.png"  title="" media-simple="true" style="height: 30vh;">
            <br>
            EKSTREMA LOKALNE
        </a>
    </p>

</article>


</body>
</html>