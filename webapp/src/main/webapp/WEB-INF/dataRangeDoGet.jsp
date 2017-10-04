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

    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">

    <%--no cache--%>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
</head>

<body>
<p>DataRangeDoGet.jsp</p>
<p>Podaj zakres dat</p>
<form action="extremaLokalne" method="POST" enctype="multipart/form-data">
    <p>Podaj pierwsza date</p>
    <select name="startDate" required>
        <c:forEach items="${fundsList}" var="fundsListValue">
            <option value="${fundsListValue}">${fundsListValue.getDate()}</option>
        </c:forEach>
    </select>
    <p>Podaj druga date</p>
    <select name="endDate" required>
        <c:forEach items="${fundsList}" var="fundsListValue">
            <option value="${fundsListValue}">${fundsListValue.getDate()}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Wyslij">
</form>
</body>
</html>