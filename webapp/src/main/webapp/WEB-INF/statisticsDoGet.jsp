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
<div class="og" id="boxy">
    <H1>STATYSTYKI</H1>


    <H4>Liczba wszystkich wyborów użytkownika: ${NumberOfVisitsTotal}</H4>
    <c:forEach items="${OccurrenceMapTotal}" var="entry">
        <p>${entry.key}>>${entry.value}</p>
    </c:forEach>

    <H4>Historia:</H4>
    <c:forEach items="${RecordsListTotal}" var="entry">
        <p>${entry.name}>>${entry.dateTime}</p>
    </c:forEach>

</div>
</body>
</html>