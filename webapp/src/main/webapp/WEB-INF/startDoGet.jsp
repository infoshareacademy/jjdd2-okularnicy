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
<form action="start" method="post" enctype="multipart/form-data">
    <p>Tutaj wskaż plik LST: <input type="file" name="fileLST"/></p>
    <p>Tutaj wskaż archiwum ZIP: <input type="file" name="fileZIP"/></p>
    <button type="submit">Wyslij</button>
</form>
</body>

</html>