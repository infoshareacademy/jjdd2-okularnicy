<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${applicationScope.language}"/>
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
    <p>Wysłano wiadomosc na podany adres email.</p>
</div>


</body>
</html>