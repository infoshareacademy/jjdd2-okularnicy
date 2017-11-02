<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle basename="i18n.napisy"/>
<!DOCTYPE html>
<html lang="${sessionScope.language}">
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>

<body>

<header>
    <nav class=nav>
        <ul>
            <li><a href="start"><fmt:message key="homePage"/></a></li>
            <li><a href=""><fmt:message key="fund"/><br/><fmt:message key="currency"/></a></li>
            <li><a href=""><fmt:message key="global"/></a></li>
            <li><a href=""><fmt:message key="local"/></a></li>
            <li><a href=""><fmt:message key="raport"/></a></li>
            <li><a href="logout"><fmt:message key="logout"/></a></li>
        </ul>
    </nav>

</header>
<article id="tytul">
    <h1><fmt:message key="title"/></h1>
    <p class=text> <fmt:message key="hello"/>
        <br/>
        <fmt:message key="instruct"/>
    </p>
    <h3><fmt:message key="search"/></h3>
    <br/>
    <form action="start" method="post" enctype="multipart/form-data">
        <p><fmt:message key="lst"/><input class=pliki type="file" name="fileLST" required accept=".lst"/></p>
        <p><fmt:message key="zip"/><input class=pliki type="file" name="fileZIP" required accept=".zip"/></p>
        <br/>
        <button type="submit"><fmt:message key="send"/></button>
    </form>
</article>

</body>
</html>