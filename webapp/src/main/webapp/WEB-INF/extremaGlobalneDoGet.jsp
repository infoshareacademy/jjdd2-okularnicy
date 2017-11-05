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
<div class="og" id="glob">
    <h1> <fmt:message key="global"/> </h1>

    <h2>${choseFundStringFullName}</h2>

    <p><fmt:message key="min"/> ${fundMinDate} => ${fundMinClose}</p>
    <p><fmt:message key="max"/> ${fundMaxDate} => ${fundMaxClose}</p>

    <div class="chart">
        <jsp:include page="charts.jsp" />
    </div>

</div>

</body>
</html>