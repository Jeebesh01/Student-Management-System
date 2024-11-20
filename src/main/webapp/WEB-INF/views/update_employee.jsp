<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<h2>Update Employee</h2>
	<form action="updateStudent" method="post">
	<pre>
	<input type="hidden" name="id" value="${employee.id}"/>
		Name<input type="text" name="name" value="${employee.name}"/>
		Email<input type="text" name="emailId" value="${employee.emailId}"/>
		Mobile<input type="text" name="mobile" value="${employee.mobile}"/>
		<input type="submit" value="add"/>
		</pre>
	</form>
	
	${msg}
</body>
</html>