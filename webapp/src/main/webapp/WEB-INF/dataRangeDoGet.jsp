<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatibile" content="ie-edge, chrome-1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="Okularnicy">
    <link href="resources/fotolia-80738841.png" rel="shortcut icon"  type="image/x-icon">
    <meta name="description" content="">
    <title>ANALIZATOR FINANSOWY</title>

    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">

    <%--no cache--%>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
</head>

<body>
<header>
    <jsp:include page="shared/header.jsp"/>
</header>
<div class="og" id="data">
    <H1>PODAJ ZAKRES DAT</H1>

    <form action="DataRange" method="POST" enctype="multipart/form-data">
        <h2> Data początkowa </h2>

        <select name="startDate" required>
            <c:forEach items="${fundsList}" var="fundsListValue">
                <option value="${fundsListValue.getDate()}">${fundsListValue.getDate()}</option>
            </c:forEach>
        </select>

        <h2> Data końcowa </h2>

        <select name="endDate" required>
            <c:forEach items="${fundsList}" var="fundsListValue">
                <option value="${fundsListValue.getDate()}">${fundsListValue.getDate()}</option>
            </c:forEach>
        </select>

        <br>

        <input type="submit" value="Wyślij">
    </form>
</div>
</body>
</html>

