<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${applicationScope.language}" />
<fmt:setBundle basename="i18n.napisy"/>
<html lang="${applicationScope.language}">
<head>
    <title>Menu</title>
    <nav class=nav>
        <ul>
            <li><a href="start"><fmt:message key="homePage"/></a></li>
            <li><a href="analizator"><fmt:message key="fund"/><br/><fmt:message key="currency"/></a></li>
            <li><a href="extremaGlobalne"><fmt:message key="global"/></a></li>
            <li><a href="DataRange"><fmt:message key="local"/></a></li>
            <c:if test = "${admin == true}">
            <li><a href="statistics"><fmt:message key="raport"/></a></li>
            </c:if>
            <li><a href="logout"><fmt:message key="logout"/></a></li>
        </ul>
    </nav>
</head>
<body>
</body>
</html>

