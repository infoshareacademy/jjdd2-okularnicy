<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${applicationScope.language}" />
<fmt:setBundle basename="i18n.napisy"/>

<!DOCTYPE html>
<html lang="${applicationScope.language}">
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>

<body>
<header>
    <jsp:include page="/shared/header.jsp"/>
</header>
<div class="og" id="stat">
    <jsp:include page="/WEB-INF/statisticsIntel.jsp"/>

    <form action="statistics" method="post">
        <fmt:message key="firstPeriod"/>
        <fmt:message key="days"/>:<input type="text" name="days1" maxlength="2" value="${daysDuration1}" size="2">
        <fmt:message key="hours"/>:<input type="text" name="hours1" maxlength="2" value="${hoursDuration1}" size="2">
        <fmt:message key="minutes"/>:<input type="text" name="minutes1" maxlength="2" value="${minutesDuration1}" size="2">
        <fmt:message key="seconds"/>:<input type="text" name="seconds1" maxlength="2" value="${secondsDuration1}" size="2">
        <br>
        <fmt:message key="secondPeriod"/>
        <fmt:message key="days"/>:<input type="text" name="days2" maxlength="2" value="${daysDuration2}" size="2">
        <fmt:message key="hours"/>:<input type="text" name="hours2" maxlength="2" value="${hoursDuration2}" size="2">
        <fmt:message key="minutes"/>:<input type="text" name="minutes2" maxlength="2" value="${minutesDuration2}" size="2">
        <fmt:message key="seconds"/>:<input type="text" name="seconds2" maxlength="2" value="${secondsDuration2}" size="2">
        <br>
        <button type="submit"><fmt:message key="send"/></button>
    </form>

    <jsp:include page="/WEB-INF/historyIntel.jsp"/>

    <form action="email" method="post">
        <fmt:message key="email"/>
        <input type="email" name="emailAddress" placeholder="<fmt:message key="exampleEmail"/>">
        <button type="submit"><fmt:message key="send"/></button>
    </form>

</div>
</body>
</html>