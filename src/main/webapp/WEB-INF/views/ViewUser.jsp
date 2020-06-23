<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>FirstName | LastName | Email</b>
<c:forEach items="${users}" var="userBean">
<br>
${userBean.firstName}
${userBean.lastName }
${userBean.email }
<a href="deleteuser/${userBean.id }">DELETE</a>
<a href="edituser/${userBean.id }">UPDATE</a>
</c:forEach>
</body>
</html>