<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Login</h1>
${message}
<div>
    <f:form action="loginPro.do" method="post"  commandName="user">
        <div>
            <f:label for="email" path="email">Username:</f:label>
            <f:input path="email"></f:input>
        </div>
        <div>
            <f:label path="password" for="password">password:</f:label>
            <f:password path="password" ></f:password>
        </div>
        <div>
            <f:label path="country">country:</f:label>
            <f:select path="country" items="${countrylist}" />
        </div>

        <input type="submit">
    </f:form>

</div>


</body>
</html>