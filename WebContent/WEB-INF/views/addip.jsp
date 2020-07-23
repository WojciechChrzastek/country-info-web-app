<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Country Info App - Add IP</title>
    <%@ include file="../../resources/parts/headmeta.jsp" %>
</head>
<body>

<%@ include file="../../resources/parts/nav.jsp" %>

<section class="addip">
    <div class="container my-auto">
        <div class="row justify-content-center pb-3">
            <h2>Add IP</h2>
        </div>

        <div class="form-section row justify-content-center">
            <form:form action="addIp" method="post" modelAttribute="countryInfo">
                <form>
                    <div class="form-group row justify-content-center">
                        <label for="inputIp" class="col-sm-2 col-form-label">IP:</label>
                        <div class="col-sm-10">
                            <form:input required="true"
                                        pattern="^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$"
                                        path="ip"
                                        type="text"
                                        class="form-control"
                                        id="inputIp" placeholder="IP"/>
                            <small id="inputIpHelp" class="form-text text-muted">Please provide valid IP
                                address.</small>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <button class="btn btn-primary" type="submit">Add</button>
                    </div>
                </form>
            </form:form>
        </div>
    </div>

</section>
<%@ include file="../../resources/parts/footer.jsp" %>
</body>
</html>
