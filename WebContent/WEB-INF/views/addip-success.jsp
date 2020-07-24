<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country Info WebApp - Add IP success</title>
    <%@ include file="../../resources/parts/headmeta.jsp" %>
</head>
<body>

<%@ include file="../../resources/parts/nav.jsp" %>

<section class="update">
    <div class="container my-auto">
        <div class="row justify-content-center align-items-center">
            <div class="alert alert-success" role="alert">
                <h2>IP has been successfully added to the database.</h2>
            </div>
        </div>
        <div class="row justify-content-center align-items-center">
            <h4><a href="add">Add another IP</a></h4>
        </div>
        <div class="row justify-content-center align-items-center">
            <h4><a href="./">Go back to homepage</a></h4>
        </div>
    </div>
</section>

<%@ include file="../../resources/parts/footer.jsp" %>
</body>
</html>
