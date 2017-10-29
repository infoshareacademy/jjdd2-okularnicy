<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="napisy"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>

<body>

<div id="log">
    <br>
    <fmt:message key="napisy.title" var="title" />
    <h1>${title}</h1>
    <br>
    <br>
    Aby przejść dalej musisz się zalogować
    <br>
    <form>
        <select id="language" name="language" onchange="submit()">
            <option value="pl" ${language == 'pl' ? 'selected' : ''}>Polski</option>
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        </select>
    </form>
    <form action="finanse/start" method="GET">
        <button type="submit">Zaloguj</button>
    </form>
</div>
</body>
</html>
