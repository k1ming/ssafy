<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${ pageContext.request.contextPath }"/>
<c:choose>
	<c:when test="${ joinpostsmembers.posts.type == '1' }">
		<c:set var="hdt" value="공지사항"/>
	</c:when>
	<c:when test="${ joinpostsmembers.posts.type == '2' }">
		<c:set var="hdt" value="오늘의 뉴스"/>
	</c:when>
	<c:otherwise>
		<c:set var="hdt" value="자유게시판"/>	
	</c:otherwise>
</c:choose>

<c:if test="${ type == '3' && userinfo == null}">
		<script>alert("접근할 자격이 없습니다.")</script>
</c:if>
<c:if test="${ type != '3' || (type == '3' && userinfo != null) }">
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
 			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
			<title>Happy House : 글 상세보기</title>
		</head>
		<body>
			<!-- 로그인정보 출력 공간 -->
			<%@include file="/menu.jsp" %>
			<div class="container" align="center">
				<div align="right">
					<!-- 글쓰기 등 메뉴 이동 공간 -->
					<table>
						<tr>
							<h5 aligh="right">${ hdt }</h5>								
						</tr>
						<c:if test="${ (joinpostsmembers.posts.type != '3' && userinfo.type == '1') || (joinpostsmembers.posts.type == '3' && userinfo.no == joinpostsmembers.posts.memno)}">
							<tr>
								<form method="post" name="update" action="${ root }/post.do">
									<input type="hidden" name="act" value="mvUpdate">
									<input type="hidden" name="no" value="${ joinpostsmembers.posts.no }">
									<input type="hidden" name="title" value="${ joinpostsmembers.posts.title }">
									<input type="hidden" name="contents" value="${ joinpostsmembers.posts.contents }">
									<input type="hidden" name="type" value="${ joinpostsmembers.posts.type }">
									<input type="hidden" name="source" value="${ joinpostsmembers.posts.source }">
									<td><input type="submit" value="수정"></td>
								</form>									
								<form method="post" name="delete" action="${ root }/post.do">
									<input type="hidden" name="act" value="delete">
									<input type="hidden" name="no" value="${ joinpostsmembers.posts.no }">
									<input type="hidden" name="type" value="${ joinpostsmembers.posts.type }">
									<td><input type="submit" value="삭제"></td>
								</form>									
							</tr>
						</c:if>
					</table>
				</div>
					
				<c:if test="${ joinpostsmembers != null }">
					<div align="center">
						<table class="table table-dark table-hover">
							<tbody align="center">
								<tr>
									<td width="300">번호</td>
									<td align="left">${ joinpostsmembers.posts.no }</td>
								</tr>
								<tr>
									<td width="300">제목</td>
									<td align="left">${ joinpostsmembers.posts.title }</td>
								</tr>
								<tr>
									<td width="300">내용</td>
									<td align="left">${ joinpostsmembers.posts.contents }</td>
								</tr>
								<c:if test="${ joinpostsmembers.posts.type == '2' }">
									<td width="300">출처</td>
									<td align="left">${ joinpostsmembers.posts.source }</td>
								</c:if>
								<tr>
									<td width="300">작성자</td>
									<td align="left">${ joinpostsmembers.members.userId }(${ joinpostsmembers.members.name })</td>
								</tr>
								<tr>
									<td width="300">작성 날짜</td>
									<td align="left">${ joinpostsmembers.posts.makeDate }</td>
								</tr>
								<tr>
									<td width="300">조회수</td>
									<td align="left">${ joinpostsmembers.posts.views }</td>
								</tr>
							</tbody>
						</table>
					</div>	
				</c:if>
			</div>
		</body>
	</html>
</c:if>