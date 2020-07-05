<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add new ip</title>
</head>
<body>
<div align="center">
    <h1>Add ip</h1>
    <table cellpadding="5">
        <form:form action="save" method="post" modelAttribute="countryInfo">
            <tr>
                <td>IP:</td>
                <td><form:input path="ip"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="save"></td>
            </tr>
        </form:form>
    </table>
</div>

</body>
</html>
