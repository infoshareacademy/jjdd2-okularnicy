<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle basename="i18n.napisy"/>
<!DOCTYPE html>
<html lang="${sessionScope.language}">
<head>
    <jsp:include page="/shared/head.jsp"/>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script>
        $(function () {
            $(".datepicker").datepicker({
                dateFormat: "yy-mm-dd",
                showButtonPanel: true,
                changeMonth: true,
                changeYear: true,
                showOtherMonths: true,
                selectOtherMonths: true,
                yearRange: "1970:+nn",
                minDate: "${startDateOnList}",
                maxDate: "${endDateOnList}"
            });
        });
    </script>
    <title>ANALIZATOR FINANSOWY</title>

    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">

    <%--no cache--%>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
</head>

<body>
<header>
    <jsp:include page="/shared/header.jsp"/>
</header>
<div class="og" id="data">
    <H1><fmt:message key="dataRange"/></H1>

    <form action="extremaLokalne" method="POST">


        <input type="text" name="startDate" placeholder="<fmt:message key="start"/>" class="datepicker" required/> &nbsp

        <input type="text" name="endDate" placeholder="<fmt:message key="end"/>" class="datepicker" required/>
        <br>
        <fmt:message key="send" var="button"/>
        <input type="submit" class="datepicker" value=${button} >
    </form>
</div>
</body>
</html>

