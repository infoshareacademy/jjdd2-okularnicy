<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="application" />
<fmt:setLocale value="${applicationScope.language}" />
<fmt:setBundle basename="i18n.napisy"/>
<!DOCTYPE html>
<html lang="${applicationScope.language}">
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>

<body>

<div id="log">
    <form id="language">
        <select class="sel" name="language" onchange="submit()">
            <option value="pl" ${language == 'pl' ? 'selected' : ''}>Polski</option>
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        </select>
    </form>
    <br>
    <h1><fmt:message key="title"/></h1>
    <br>
    <br>
    <fmt:message key="mustLog"/>
    <br>
        <form action="finanse/start" method="GET">
        <button type="submit"><fmt:message key="login"/></button>
    </form>
</div>
</body>
</html>
