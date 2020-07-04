<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Country Info Application Home</title>
</head>
<body>
  <div align="center">
    <h1>Country Info Application</h1>
    <h3><a href="new">Add IP</a></h3>
    <table border="1" cellpadding="5">
      <tr>
        <th>id</th>
        <th>isProcessed</th>
        <th>processedTimestamp</th>
        <th>ip</th>
        <th>countryName</th>
      </tr>
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
</body>
</html>
