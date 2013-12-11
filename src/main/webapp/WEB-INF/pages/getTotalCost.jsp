<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
    <title></title>
</head>
<body>
<form action="listTotal.do" method="post">
    <div>
        country:
        <select name="country">
        <c:forEach items="${countrylist}" var="p">
         <option value="${p.key}">${p.key}</option>
        </c:forEach>
        </select>
    </div>

    <input type="submit">
</form>

</body>
</html>