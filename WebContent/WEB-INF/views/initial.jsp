<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Country Info App - Initial data</title>
    <%@ include file="../../resources/parts/headmeta.jsp" %>
</head>
<body>
<section>
    <div class="container">
        <div class="row justify-content-center">
            <h1>Country Info Application - Initial data</h1>
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
            <th>ip</th>
            </thead>
            <c:forEach items="${initialIpList}" var="ip" varStatus="status">
                <tr>
                    <td>${ip}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>
