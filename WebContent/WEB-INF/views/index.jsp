<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country Info WebApp - Home</title>
    <%@ include file="../../resources/parts/headmeta.jsp" %>
</head>
<body>

<%@ include file="../../resources/parts/nav.jsp" %>

<section class="index">
    <div class="container my-auto">
        <div class="row justify-content-center">
            <h1>Country Info App - Home</h1>
        </div>
        <div class="row justify-content-center">
            <h4><a href="initial">Show initial data</a></h4>
        </div>
        <div class="row justify-content-center">
            <h4><a href="add">Add IP</a></h4>
        </div>
        <div class="row justify-content-center">
            <h4><a href="update">Update rows from API response</a></h4>
        </div>
        <div class="row justify-content-center">
            <h4><a href="report">Show report</a></h4>
        </div>
    </div>
</section>

<%@ include file="../../resources/parts/footer.jsp" %>

</body>
</html>
