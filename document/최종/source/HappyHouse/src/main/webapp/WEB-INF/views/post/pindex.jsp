<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<p><a href="${ root }/post.do?act=mvInsert&type=1">공지사항 등록</a></p>
		<p><a href="${ root }/post.do?act=select&type=1">공지사항 조회</a></p>

		<p><a href="${ root }/post.do?act=mvInsert&type=2"">오늘의뉴스 등록</a></p>
		<p><a href="${ root }/post.do?act=select&type=2">오늘의뉴스 조회</a></p>

		<p><a href="${ root }/post.do?act=mvInsert&type=3"">자유글 등록</a></p>
		<p><a href="${ root }/post.do?act=select&type=3">자유글 조회</a></p>
	</body>
</html>