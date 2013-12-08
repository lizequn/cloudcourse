<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <form action="orderPro.do" method="post">
        <input type="submit"><br>
        <c:forEach items="${productList}" var="p">
        <div style="float: left;border: 1px solid skyblue;width: 180px;margin: 1px">
            <h4>${p.partitionKey}---${p.productName}</h4>
            Price:${p.price}<br/>
            Select:<input type="radio" name="selectProduct" value="${p.rowKey}">
        </div>
        </c:forEach>

    </form>
</div>
 </body>
</html>