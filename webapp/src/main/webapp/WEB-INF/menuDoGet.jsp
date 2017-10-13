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
<article class="og" id="pokoje">

    <p class=" room">
        <a class="inroom" href="extremaGlobalne"><img src="${pageContext.request.contextPath}/resources/world.png"  title="" media-simple="true" style="height: 30vh;">
            <br>
            EKSTREMA GLOBALNE
        </a>
    </p>

    <p class="room">

        <a class="inroom" href="DataRange"><img src="${pageContext.request.contextPath}/resources/home.png"  title="" media-simple="true" style="height: 30vh;">
            <br>
            EKSTREMA LOKALNE
        </a>
    </p>

</article>
</body>
</html>