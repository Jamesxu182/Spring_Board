<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Discussion: <c:out value="${discussion.subject}"></c:out></title>
</head>
<body>
	<h2>Discussion: <c:out value="${discussion.subject}"></c:out></h2>
	<i>User: <c:out value="${discussion.user}"></c:out> Created: <c:out value="${discussion.created}"></c:out></i>
	<br></br>
	<c:out value="${discussion.message}"></c:out>
	<br></br>
	<br></br>
	<c:choose>
		<c:when test="${fn:length(replies) > 0}">
			<c:forEach items="${replies}" var="reply" varStatus="i">
				<b>Reply #${i.count}</b><i> - <c:out value="${reply.user}"></c:out> - 
				<c:out value="${reply.created}"></c:out><br></br> -
				<c:out value="${reply.message}"></c:out><br></br>
				</i>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<i>There are no replies yet.</i>
			<br></br>
		</c:otherwise>
	</c:choose>
	
	<h2>Post Reply</h2>
	
	<c:set var="action"><c:url value="/discussion/${discussion.getId()}/reply"></c:url></c:set>
	<form:form method="post" action="${action}" modelAttribute="replyForm">
		<table>
			<tr>
				<th><form:label path="user">Email: </form:label></th>
				<th><form:input path="user"></form:input></th>
			</tr>
			<tr>
				<th><form:label path="message">Reply</form:label></th>
				<th><form:textarea path="message" cols="40" rows="5"></form:textarea></th>
			</tr>
			<tr>
				<th></th>
				<th><input type="submit" value="Submit"></th>
			</tr>
		</table>
	</form:form>
</body>
</html>