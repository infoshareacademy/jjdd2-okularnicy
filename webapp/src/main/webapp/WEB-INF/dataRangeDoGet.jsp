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
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
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
    <nav class=nav>
        <ul>
            <li><a href="start">STRONA GŁÓWNA</a></li>
            <li><a href="analizator">FUNDUSZ/<br>WALUTA</a></li>
            <li><a href="extremaGlobalne">EKSTREMA GLOBALNE</a></li>
            <li><a href="DataRange">EKSTREMA LOKALNE</a></li>
            <li><a href="https://www.google.pl">WYJŚCIE</a></li>
        </ul>
    </nav>

</header>
<div class="og" id="data">
    <H1>PODAJ ZAKRES DAT</H1>

    <form action="extremaLokalne" method="POST">

        <h2> Data początkowa </h2>

        <input type="text" name="startDate" class="datepicker"/>
        <br/>

        <h2> Data koncowa </h2>

        <input type="text" name="endDate" class="datepicker"/>
        <br/>

        <input type="submit" value="Wyślij">
    </form>
</div>
</body>
</html>

