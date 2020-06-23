<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
User Module
<hr>
<form:form action="insertuser" modelAttribute="userBean">

FirstName<form:input path="firstName"/><br>
LastName<form:input path="lastName"/><br>
Email<form:input path="email"/><br>
submit<input type="submit">
</form:form>
</body>
</html>