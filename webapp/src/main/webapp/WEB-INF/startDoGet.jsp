<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <jsp:include page="/shared/head.jsp"/>
</head>

<body>

<header id=header1>
    <jsp:include page="/shared/header.jsp"/>

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
</html>