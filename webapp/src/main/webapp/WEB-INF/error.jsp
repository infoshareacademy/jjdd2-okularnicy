<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${applicationScope.language}" />
<fmt:setBundle basename="i18n.napisy"/>
<html lang="${applicationScope.language}">
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>
<body>
<h1><fmt:message key="error1"/></h1>
<h2><fmt:message key="error2"/></h2>
<form action="start" method="GET">
    <button type="submit"><fmt:message key="back"/></button>
</form>
</body>
</html>
