<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${applicationScope.language}"/>
<fmt:setBundle basename="i18n.napisy"/>

<H1><fmt:message key="history"/></H1>

<table class="center">
    <c:forEach items="${RecordsListTotal}" var="entry">
        <tr>
            <td>${entry.name}</td>
            <td>${entry.dateTime}</td>
        </tr>
    </c:forEach>

</table>
=======