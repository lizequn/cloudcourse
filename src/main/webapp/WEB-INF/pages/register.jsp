
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>register</h1>
<div>
    <f:form action="registerPro.do" method="post"  commandName="user">
        <div>
            <f:label for="email" path="email">email:</f:label>
            <f:input path="email"></f:input>
            <f:errors path="email" cssClass="error"></f:errors>
        </div>
        <div>
            <f:label path="password" for="password">password:</f:label>
            <f:password path="password" ></f:password>
            <f:errors path="password" cssClass="error"></f:errors>
        </div>
        <div>
            <f:label path="country" for="country">country:</f:label>
            <f:password path="country" ></f:password>
            <f:errors path="country" cssClass="error"></f:errors>
        </div>
        <div>
            <f:label path="firstname" for="firstname">firstname:</f:label>
            <f:password path="firstname" ></f:password>
            <f:errors path="firstname" cssClass="error"></f:errors>
        </div>
        <div>
            <f:label path="lastname" for="lastname">lastname:</f:label>
            <f:password path="lastname" ></f:password>
            <f:errors path="lastname" cssClass="error"></f:errors>
        </div>


        <input type="submit">
    </f:form>

</div>

</body>
</html>