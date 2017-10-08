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

<header id=header1>
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
<article id="tytul">
    <h1> ANALIZATOR FINANSOWY</h1>
    <p class=text> Witaj !!!
        <br/>
        postępuj zgodnie z informacjami wyświetlanymi na ekranie.
    </p>
    <h3>WYSZUKAJ PLIKI</h3>
    <br/>
    <form  action="start" method="post" enctype="multipart/form-data">
        <p>Wskaż plik LST: <input class=pliki type="file" name="fileLST" required accept=".lst"/></p>
        <p>Wskaż archiwum ZIP: <input class=pliki type="file" name="fileZIP" required accept=".zip"/></p>
        <br/>
        <button type="submit">WYŚLIJ</button>
    </form>
</article>

</body>
=======
<form action="start" method="post" enctype="multipart/form-data">
    <p>Tutaj wskaż plik LST: <input type="file" name="fileLST"/></p>
    <p>Tutaj wskaż archiwum ZIP: <input type="file" name="fileZIP"/></p>
    <button type="submit">Wyslij</button>
</form>
</body>

</html>