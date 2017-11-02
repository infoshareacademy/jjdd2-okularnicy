<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle basename="i18n.napisy"/>
<!DOCTYPE html>
<html lang="${sessionScope.language}">
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>

<body>
<header>
    <jsp:include page="/shared/header.jsp"/>
</header>
<div class="og" id="boxy">
    <H1><fmt:message key="chose"/></H1>
    <c:if test="${lstCorrectness == 0}"><H3 class="warning"><fmt:message key="info"/></H3></c:if>

    <div class="tooltip"><p id="x"> ? </p>
        <span class="tooltiptext"><fmt:message key="remember"/></span>
    </div>

    <form action="analizator" method="POST" enctype="multipart/form-data">
        <select class=sel name="choseFund" required>
            <c:forEach items="${filesHashMap}" var="entry">
                <option value="${entry.value},${entry.key}">${entry.key}</option>
            </c:forEach>
        </select>
        <fmt:message key="send" var="button"/>
        <input type="submit" value=${button}>
    </form>
</div>
</body>
</html>