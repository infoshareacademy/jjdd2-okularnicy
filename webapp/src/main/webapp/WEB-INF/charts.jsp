<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            var data = google.visualization.arrayToDataTable([
                ["Date", ' '],
                <c:forEach var="daty" items="${fundList}">
                    ["${daty.getDate()}", ${daty.getClose()}],
                </c:forEach>
            ]);

            var options = {
                title: '${choseFundStringFullName}',
                curveType: 'function',
                legend: { position: 'top' }
            };

            var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

            chart.draw(data, options);
        }
    </script>
</head>
<body>

<div id="curve_chart" style="width: 100vw; height: 50vh ; font-size: 10px;"></div>


</body>
</html>