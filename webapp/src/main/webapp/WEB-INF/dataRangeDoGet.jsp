<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script>
        $(function() {
            $( ".datepicker" ).datepicker({
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
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
</head>

<body>
<header>
    <jsp:include page="/shared/header.jsp"/>
</header>
<div class="og" id="data">
    <H1>PODAJ ZAKRES DAT</H1>

    <form action="extremaLokalne" method="POST">


        <input type="text" name="startDate" value="Data początkowa" class="datepicker"/> &nbsp

        <input type="text" name="endDate" value="Data końcowa"  class="datepicker"/>
        <br>
        <input type="submit" value="Wyślij" class="datepicker">
    </form>
</div>
</body>
</html>

