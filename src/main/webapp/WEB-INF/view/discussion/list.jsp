<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>
	<h2>Disucssions</h2>
	
	<c:choose>
		<c:when test="${fn:length(discussions) > 0}">
			<c:forEach items="${discussions}" var="discussion">
				<a href="<c:url value="/discussion/${discussion.id}/${discussion.uriSafeSubject}"></c:url>">
					<c:out value="${discussion.subject}"></c:out>
				</a>
				<br />
				<c:out value="${discussion.user}"></c:out>
				<br></br>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<i><c:out value="There are not discussions yet"></c:out></i>
		</c:otherwise>
	</c:choose>
	
	<a href="<c:url value="/discussion/create"></c:url>">new discussion</a>
</body>
</html>