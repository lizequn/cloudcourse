<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cmdadmin
  Date: 11/12/13
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListTotalCost</title>
</head>
<body>
<table>
    <thead>
    <th>country</th>
    <th>email</th>
    <th>name</th>
    <th>total price</th>
    </thead>
    <c:forEach items= "${map}" var="d">
        <tr>
            <td>${d.key.partitionKey}</td>
            <td>${d.key.rowKey}</td>
            <td>${d.key.firstname}  ${d.key.lastname}</td>
            <td>${d.value}</td>
        </tr>

    </c:forEach>

</body>
</html>