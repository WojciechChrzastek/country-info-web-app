<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Country Info App - Initial data</title>
    <%@ include file="../../resources/parts/headmeta.jsp" %>
</head>
<body>

<%@ include file="../../resources/parts/nav.jsp" %>

<section>
    <div class="container">
        <div class="row justify-content-center">
            <h2>IP addresses generated on application startup and added to the database</h2>
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
<%@ include file="../../resources/parts/footer.jsp" %>
</body>
</html>
