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
<p>analizatorDoGet.jsp</p>
<form action="analizator" method="POST" enctype="multipart/form-data">
    <select name="choseFund" required>
        <c:forEach items="${filesHashMap}" var="entry">
            <option value="${entry.value}">${entry.key}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Wyslij">
</form>

<%--<form action="analizator" method="post" enctype="multipart/form-data">
    <p>Tutaj wskaż plik LST: <input type="text" name="file2"/></p>
    <button type="submit">Wyslij</button>
</form>--%>

<%--<p>map: ${filesHashMap}</p>--%>

<%--<c:forEach items="${filesHashMap}" var="entry">
    <p>${entry.key} => ${entry.value}</p>
</c:forEach>--%>



<%--<select id="food" name="fooditems">
    <c:forEach items="${foods}" var="food">
        <option value="${food.key}">
                ${food.value}
        </option>
    </c:forEach>
</select>--%>

</body>
</html>