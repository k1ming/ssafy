<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${ pageContext.request.contextPath }"/>
<c:choose>
	<c:when test="${ type == '1' }">
		<c:set var="hdt" value="공지사항"/>
	</c:when>
	<c:when test="${ type == '2' }">
		<c:set var="hdt" value="오늘의 뉴스"/>
	</c:when>
	<c:otherwise>
		<c:set var="hdt" value="자유게시판"/>	
	</c:otherwise>
</c:choose>

<c:if test="${ (type == '3' && userinfo == null) || (type != '3' && userinfo.type != '1') }">
		<script>alert("접근할 자격이 없습니다.")</script>
</c:if>
<c:if test="${ (type != '3' && userinfo.type == '1') || (type == '3' && userinfo != null) }">
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
			<title>Happy House : 글 등록</title>
			<script type="text/javascript">
				function writeArticle() {
					if(writeform.title.value == ""){
						alert("제목 입력!!!!");
						return;						
					} else if(writeform.contents.value == ""){
						alert("내용 입력!!!!");
						return;						
					} else {
						writeform.action = "${root}/post.do";
						writeform.submit();
					}
			  }
			</script>
		</head>
		<body>
			<!-- 로그인정보 출력 공간 -->
			<jsp:include page="/WEB-INF/views/menu.jsp" />
			<div class="container" align="center">
				<!-- 입력폼 공간 -->
				<div class="col-lg-6" align="center">
					<h5 align="right">${ hdt }</h5>
					<form id="writeform" method="post" action="">
					<input type="hidden" name="act" id="act" value="insert">
					<input type="hidden" name="type" id="type" value="${ type }">
					<!-- memno는 서블릿에서 session값 꺼내서 대체 -->
						<div class="form-group" align="left">
							<label for="title">제목:</label>
							<input type="text" class="form-control" id="title" name="title">
						</div>
						<div class="form-group" align="left">
							<label for="contents">내용:</label>
							<textarea class="form-control" rows="15" id="contents" name="contents"></textarea>
						</div>
						<c:if test="${ type == '2' }">
							<div class="form-group" align="left">
							<label for="source">출처:</label>
							<input type="text" class="form-control" id="source" name="source">
						</div>
						</c:if>
						<button type="button" class="btn btn-primary" onclick="javascript:writeArticle();">글작성</button>
						<button type="reset" class="btn btn-warning">초기화</button>
					</form>
				</div>
			</div>
			<jsp:include page="/WEB-INF/views/footer.jsp" />
		</body>
	</html>
</c:if>