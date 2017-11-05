<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${applicationScope.language}"/>
<fmt:setBundle basename="i18n.napisy"/>


<table class="center">
    <thead>
    <tr>
        <th colspan="2"><H1><fmt:message key="stat"/></H1></th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td><H3><fmt:message key="firstInt"/></H3>
            <p>(<fmt:message key="days"/>:${daysDuration1}, <fmt:message key="hours"/>:${hoursDuration1}, <fmt:message
                    key="minutes"/>:${minutesDuration1}, <fmt:message key="seconds"/>:${secondsDuration1})</p></td>
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
        <td><H3><fmt:message key="secondInt"/></H3>
            <p>(<fmt:message key="days"/>:${daysDuration2}, <fmt:message key="hours"/>:${hoursDuration2}, <fmt:message
                    key="minutes"/>:${minutesDuration2}, <fmt:message key="seconds"/>:${secondsDuration2})</p></td>
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
        <td><H3><fmt:message key="all"/></H3></td>
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