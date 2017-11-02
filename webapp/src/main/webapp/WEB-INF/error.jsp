<%--
  Created by IntelliJ IDEA.
  User: aleksandramorawska
  Date: 28.10.17
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>
<body>
    <h1>Coś poszło nie tak !</h1>
    <h2>Wróć do strony logowania</h2>
    <form action="finanse/start" method="GET">
        <button type="submit">Wróć</button>
    </form>
</body>
</html>
