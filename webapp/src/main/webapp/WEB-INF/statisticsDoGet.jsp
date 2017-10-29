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
<div class="statistics" id="stat">
    <table>
        <thead>
        <tr>
            <th><H1>STATYSTYKI</H1></th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>Liczba wyborów użytkownika w pierwszym przedziale czasu:</td>
            <td>${NumberOfVisitsLast1}</td>
        </tr>
        <tr>
            <td><c:forEach items="${OccurrenceMapLast1}" var="entry">
                <h6>${entry.key}>>${entry.value}</h6>
            </c:forEach></td>
        </tr>
        <tr>
            <td>Liczba wyborów użytkownika w drugim przedziale czasu:</td>
            <td>${NumberOfVisitsLast2}</td>
        </tr>
        <tr>
            <td><c:forEach items="${OccurrenceMapLast2}" var="entry">
                <h6>${entry.key}>>${entry.value}</h6>
            </c:forEach></td>
        </tr>
        <tr>
            <td>Liczba wszystkich wyborów użytkownika:</td>
            <td>${NumberOfVisitsTotal}</td>
        </tr>
        <tr>
            <td><c:forEach items="${OccurrenceMapTotal}" var="entry">
                <h4>${entry.key}>>${entry.value}</h4>
            </c:forEach></td>
        </tr>
        </tbody>
    </table>

    <table>
        <thead>
        <tr>
            <th><H1>Historia:</H1></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${RecordsListTotal}" var="entry">
            <tr>
                <td><h6>${entry.name}>>${entry.dateTime}</h6></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>