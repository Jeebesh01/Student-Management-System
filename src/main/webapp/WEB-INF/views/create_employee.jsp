<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Student</h2>
	<form action="addStudent" method="post">
	<pre>
		Name<input type="text" name="name"/>
		Email<input type="text" name="emailId"/>
		Mobile<input type="text" name="mobile"/>
		<input type="submit" value="add"/>
		</pre>
	</form>
	
	${msg}
</body>
</html>