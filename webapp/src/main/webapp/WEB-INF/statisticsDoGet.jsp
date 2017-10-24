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


    <H4>Liczba wyborów użytkownika w pierwszym przedziale czasu: ${NumberOfVisitsLast1}</H4>
    <c:forEach items="${OccurrenceMapLast1}" var="entry">
        <h6>${entry.key}>>${entry.value}</h6>
    </c:forEach>

    <H4>Liczba wyborów użytkownika w drugim przedziale czasu: ${NumberOfVisitsLast2}</H4>
    <c:forEach items="${OccurrenceMapLast2}" var="entry">
        <h6>${entry.key}>>${entry.value}</h6>
    </c:forEach>




    <H4>Liczba wszystkich wyborów użytkownika: ${NumberOfVisitsTotal}</H4>
    <c:forEach items="${OccurrenceMapTotal}" var="entry">
        <h4>${entry.key}>>${entry.value}</h4>
    </c:forEach>

    <h4>Historia:</h4>
    <c:forEach items="${RecordsListTotal}" var="entry">
        <h6>${entry.name}>>${entry.dateTime}</h6>
    </c:forEach>

</div>
</body>
</html>