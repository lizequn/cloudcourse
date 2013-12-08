
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <thead>
    <th>country</th>
    <th>email</th>
    <th>password</th>
    <th>name</th>
    </thead>
<c:forEach items= "${list}" var="d">
    <tr>
        <td>${d.partitionKey}</td>
        <td>${d.rowKey}</td>
        <td>${d.password}</td>
        <td>${d.firstname}  ${d.lastname}</td>
    </tr>

</c:forEach>
</table>
</body>
</html>