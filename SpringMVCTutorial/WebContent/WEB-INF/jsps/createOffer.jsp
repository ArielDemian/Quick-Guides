<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create offer</title>
</head>
<body>
	<sf:form action="${pageContext.request.contextPath}/do_create" method="POST" accept-charset="UTF-8" commandName="offer">
		Name: <sf:input name="name" path="name" type="text" />
		<br />
		<sf:errors path="name" />
		<br /> Email: <sf:input name="email" path="email" type="text" />
		<br />
		<sf:errors path="email" />
		<br /> Text:
		<sf:textarea name="text" path="text" rows="5" cols="90" />
		<br />
		<sf:errors path="text" />
		<br />
		<input type="submit" value="Create offer">
	</sf:form>
	<br />
	<c:forEach var="error" items="${errors}">
		<c:out value="${error}" />
		<br />
	</c:forEach>
</body>
</html>