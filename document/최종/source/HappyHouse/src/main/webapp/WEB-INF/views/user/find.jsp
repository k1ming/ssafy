<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="saveid" value="${cookie.ssafy_id.value}"/>
	<c:set var="idck" value=" checked=\"checked\""/>
</c:if>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>SSAFY</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
function find() {
	if(document.getElementById("userid").value == "") {
		alert("아이디 입력!!!");
		return;
	} else if(document.getElementById("name").value == "") {
		alert("이름 입력!!!");
		return;
	} else if($("#phone").val() == ""){
		alert("전화번호 입력!!!");
		return;
	} else {
		document.getElementById("searchform").action = "${root}/find";
		document.getElementById("searchform").submit();
	}
}
	 
</script>
<style type="text/css">
body {
    margin: 0; /* 리셋을 하지 않은 경우 추가 */
}
#app {
    min-height: calc(100vh - 450px);
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp" />
<c:if test="${msg != null}">
	<script type="text/javascript">
		alert("${msg}");
	</script>
</c:if>
<div class="container" align="center" id="app">
	<h3>비밀번호 찾기</h3>
	<div class="col-lg-6" align="center">
		<form id="searchform" method="post" action="">
		<input type="hidden" name="act" id="act" value="find">
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid">
			</div>
			<div class="form-group" align="left">
				<label for="">이름</label>
				<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="form-group" align="left">
				<label for="">전화번호</label>
				<input type="text" class="form-control" id="phone" name="phone" onkeydown="javascript:if(event.keyCode == 13) {find();}">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" onclick="javascript:find();">비밀번호 찾기</button>
			</div>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>