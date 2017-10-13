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

