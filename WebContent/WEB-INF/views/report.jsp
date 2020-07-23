<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Country Info App - Report</title>
    <%@ include file="../../resources/parts/headmeta.jsp" %>
</head>
<body>

<%@ include file="../../resources/parts/nav.jsp" %>

<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <h2>Report - current database content</h2>
        </div>
    </div>
</section>
<section>

    <div class="container">
        <table class="table bg-light table-bordered table-hover table-responsive-md">
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
<%@ include file="../../resources/parts/footer.jsp" %>
</body>
</html>
