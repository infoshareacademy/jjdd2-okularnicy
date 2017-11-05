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
    <H1><fmt:message key="stat"/></H1>
    <table class="center">
        <tr class="tr1st">
            <td class="left"><H3><fmt:message key="firstInt"/></H3>
                <p>(<fmt:message key="days"/>:${daysDuration1}, <fmt:message key="hours"/>:${hoursDuration1}, <fmt:message key="minutes"/>:${minutesDuration1}, <fmt:message key="seconds"/>:${secondsDuration1})</p></td>
            <td><H3>${NumberOfVisitsLast1}</H3></td>
        </tr>
        <tr>
            <tr>
                <c:forEach items="${OccurrenceMapLast1}" var="entry">
                        <td class="left">${entry.key}</td>
                        <td>${entry.value}</td>
                    </c:forEach>
            </tr>
        </tr>
    </table>
    <br/>
    <table class="center">
        <tr class="tr1st">
            <td class="left"><H3><fmt:message key="secondInt"/></H3>
                <p>(<fmt:message key="days"/>:${daysDuration2}, <fmt:message key="hours"/>:${hoursDuration2}, <fmt:message key="minutes"/>:${minutesDuration2}, <fmt:message key="seconds"/>:${secondsDuration2})</p></td>
            <td><H3>${NumberOfVisitsLast2}</H3></td>
        </tr>
        <tr>
            <tr>
                    <c:forEach items="${OccurrenceMapLast2}" var="entry">
                            <td class="left">${entry.key}</td>
                            <td>${entry.value}</td>
                    </c:forEach>
            </tr>
        </tr>
    </table>
    <br/>
    <table class="center">
        <tr class="tr1st">
            <td class="left"><H3><fmt:message key="all"/></H3></td>
            <td><H3>${NumberOfVisitsTotal}</H3></td>
        </tr>
        <tr>
            <tr>
                    <c:forEach items="${OccurrenceMapTotal}" var="entry">
                            <td class="left">${entry.key}</td>
                            <td>${entry.value}</td>
                    </c:forEach>
            </tr>

        </tr>
    </table>

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

    <H1><fmt:message key="history"/></H1>

    <table class="center">
        <c:forEach items="${RecordsListTotal}" var="entry">
            <tr>
                <td>${entry.name}</td>
                <td>${entry.dateTime}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>