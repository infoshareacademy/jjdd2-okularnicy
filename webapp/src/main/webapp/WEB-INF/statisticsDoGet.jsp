<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>

<body>
<header>
    <jsp:include page="/shared/header.jsp"/>
</header>
<div class="og" id="stat">
    <table class="center">
        <thead>
        <tr>
            <th colspan="2"><H1>STATYSTYKI</H1></th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td><H3>Liczba wyborów użytkownika w pierwszym przedziale czasu</H3>
                <p>(dni:${daysDuration1}, godziny:${hoursDuration1}, minuty:${minutesDuration1}, sekundy:${secondsDuration1})</p></td>
            <td><H3>${NumberOfVisitsLast1}</H3></td>
        </tr>
        <tr>
            <td>
                <table class="center adjusted">
                    <tbody>
                    <c:forEach items="${OccurrenceMapLast1}" var="entry">
                    <tr>
                        <td>${entry.key}</td>
                        <td>${entry.value}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </tr>
        <tr>
            <td><H3>Liczba wyborów użytkownika w drugim przedziale czasu</H3>
                <p>(dni:${daysDuration2}, godziny:${hoursDuration2}, minuty:${minutesDuration2}, sekundy:${secondsDuration2})</p></td>
            <td><H3>${NumberOfVisitsLast2}</H3></td>
        </tr>
        <tr>
            <td>
                <table class="center adjusted">
                    <tbody>
                    <c:forEach items="${OccurrenceMapLast2}" var="entry">
                        <tr>
                            <td>${entry.key}</td>
                            <td>${entry.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </tr>
        <tr>
            <td><H3>Liczba wszystkich wyborów użytkownika</H3></td>
            <td><H3>${NumberOfVisitsTotal}</H3></td>
        </tr>
        <tr>
            <td>
                <table class="center adjusted">
                    <tbody>
                    <c:forEach items="${OccurrenceMapTotal}" var="entry">
                        <tr>
                            <td>${entry.key}</td>
                            <td>${entry.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </tr>
        </tbody>
    </table>

    <table class="center">
        <thead>
        <tr>
            <th colspan="2"><H1>HISTORIA</H1></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${RecordsListTotal}" var="entry">
            <tr>
                <td>${entry.name}</td>
                <td>${entry.dateTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>