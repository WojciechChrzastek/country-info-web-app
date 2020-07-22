<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Country Info App - Add IP</title>
    <%@ include file="../../resources/parts/headmeta.jsp" %>
</head>
<body>

<%@ include file="../../resources/parts/navbar.jsp" %>

<section>
    <div class="container">
        <div class="row justify-content-center">
            <h1>Add ip</h1>
        </div>
    </div>
</section>

<section>

    <div class="container">
        <div class="row justify-content-center">
            <table class="table table-borderless">
                <form:form action="addIp" method="post" modelAttribute="countryInfo">
                    <tr>
                        <td align="center" style="width: 50%">IP:
                            <form:input required="true" pattern="^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$" path="ip"/></td>
                    </tr>
                    <tr>
                        <td align="center">
                            <button class="btn btn-primary" type="submit">Add</button>
                        </td>
                    </tr>
                </form:form>
            </table>
        </div>
    </div>

</section>
<%@ include file="../../resources/parts/footer.jsp" %>
</body>
</html>
