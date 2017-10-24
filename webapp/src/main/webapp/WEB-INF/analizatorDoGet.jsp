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
<div class="og" id="boxy">
    <H1>WYBIERZ ODPOWIEDNI FUNDUSZ / WALUTĘ</H1>
    <c:if test="${lstCorrectness == 0}" ><H3 class="warning">Uwaga! Archiwum zip nie zawiera wszystkich plików zapisanych na liście LST. Nadal możesz korzystać z aplikacji, ale lista wyboru została ograniczona do plików które znajdują się w archiwum</H3></c:if>

    <div class="tooltip"> <p id="x"> ? </p>
        <span class="tooltiptext">Pamiętaj, aby po wybraniu funduszu wcisnąć przycisk Wyślij</span>
    </div>

    <form action="analizator" method="POST" enctype="multipart/form-data">
        <select class=sel name="choseFund" required>
            <c:forEach items="${filesHashMap}" var="entry">
                <option value="${entry.value},${entry.key}">${entry.key}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Wyślij">
    </form>
</div>
</body>
</html>