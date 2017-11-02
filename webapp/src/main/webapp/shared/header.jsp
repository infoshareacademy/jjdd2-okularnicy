<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle basename="i18n.napisy"/>
<html lang="${sessionScope.language}">
<head>
    <title>Menu</title>
    <nav class=nav>
        <ul>
            <li><a href="start"><fmt:message key="homePage"/></a></li>
            <li><a href="analizator"><fmt:message key="fund"/><br/><fmt:message key="currency"/></a></li>
            <li><a href="extremaGlobalne"><fmt:message key="global"/></a></li>
            <li><a href="DataRange"><fmt:message key="local"/></a></li>
            <li><a href="statistics"><fmt:message key="raport"/></a></li>
            <li><a href="logout"><fmt:message key="logout"/></a></li>
        </ul>
    </nav>
</head>
<body>
</body>
</html>
