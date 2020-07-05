<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Country Info App - Report</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

</head>
<body>
<section>
    <div class="container">
        <div class="row justify-content-center">
            <h1>Country Info Application - Report</h1>
        </div>
        <div class="row justify-content-center">
            <h4><a href="./">Go back to homepage</a></h4>
        </div>
    </div>
</section>
<section>

    <div class="container">
        <table class="table table-bordered table-hover">
            <thead>
            <th>id</th>
            <th>isProcessed</th>
            <th>processedTimestamp</th>
            <th>ip</th>
            <th>countryName</th>
            </thead>
            <c:forEach items="${countryInfoList}" var="countryInfo" varStatus="status">
                <tr>
                    <td>${countryInfo.id}</td>
                    <td>${countryInfo.processed}</td>
                    <td>${countryInfo.processedTimestamp}</td>
                    <td>${countryInfo.ip}</td>
                    <td>${countryInfo.countryName}</td>
                </tr>

            </c:forEach>

        </table>
    </div>
</section>
</body>
</html>
