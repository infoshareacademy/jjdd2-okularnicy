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
            <li><a href="">FUNDUSZ</a></li>
            <li><a href="">EKSTREMA GLOBALNE</a></li>
            <li><a href="">EKSTREMA LOKALNE</a></li>
            <li><a href="https://www.google.pl">WYJŚCIE</a></li>
        </ul>
    </nav>

</header>
<article id="tytul" class="og">
    <h1> ANALIZATOR FINANSOWY</h1>
    <p class=text> Pamiętaj !!!
        <br/>
        postępuj zgodnie z informacjami wyświetlanymi na ekranie.
    </p>
    <br/>
    <form action="start2" method="post" enctype="multipart/form-data">
        <h3>Aby rozpakować archiwum ZIP kliknij poniższy przycisk</h3>
        <button type="submit">Rozpakuj</button>
    </form>
</article>

</body>
</html>
l>
=======
<form action="start2" method="post" enctype="multipart/form-data">
    <p>Aby rozpakować archiwum ZIP kliknij ponizszy przycisk</p>
    <button type="submit">Rozpakuj</button>
</form>
</body>

</html>
