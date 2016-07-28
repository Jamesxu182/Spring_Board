<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create</title>
</head>
<body>
	<h2>Create Discussion</h2>
	
	<form:form method="post" modelAttribute="discussionForm">
		<table>
			<tr>
				<th>
					<form:label path="user">Your Email: </form:label>
				</th>
				<th>
					<form:input type="email" path="user"></form:input>
				</th>
			</tr>
			
			<tr>
				<th>
					<form:label path="subject">Subject: </form:label>
				</th>
				<th>
					<form:input path="subject"></form:input>
				</th>
			</tr>
			
			<tr>
				<th>
					<form:label path="message">Message: </form:label>
				</th>
				<th>
					<form:textarea path="message" cols="40" rows="5"></form:textarea>
				</th>
			</tr>
			
			<tr>
				<th>
				</th>
				<th>
					<input type="submit" value="Submit"></input>
				</th>
			</tr>
			
		</table>
	</form:form>
	
	<br></br>
	
	<a href="<c:url value="/discussion/list"></c:url>">list all discussions</a>

</body>
</html>