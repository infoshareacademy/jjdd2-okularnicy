<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ANALIZATOR FINANSOWY</title>

    <%--no cache--%>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
</head>

<body>
<form action="analizator" method="POST" enctype="multipart/form-data">
    <select name="choseFund" required>
        <c:forEach items="${filesHashMap}" var="entry">
            <option value="${entry.value}">${entry.key}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Wyslij">
</form>
</body>

</html>