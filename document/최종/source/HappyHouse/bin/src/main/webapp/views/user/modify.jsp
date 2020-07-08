<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test="${userinfo == null }">
	<c:redirect url="/index.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Happy House</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#deleteBtn").click(function(){
		$("#act").val("delete");
		$("#memberform").attr("action", "${root}/user.do").submit();
	});
	$("#cancelBtn").click(function(){
		$("#act").val("");
		$("#memberform").attr("action", "${root}/user.do").submit();
	});
	$("#registerBtn").click(function() {
		
		if($("#username").val() == "") {
			alert("이름 입력!!!");
			return;
		} else if($("#userid").val() == "") {
			alert("아이디 입력!!!");
			return;
		} else if($("#password").val() == "") {
			alert("비밀번호 입력!!!");
			return;
		} else if($("#password").val() != $("#pwdcheck").val()) {
			alert("비밀번호 확인!!!");
			return;
		} else if($("#address").val() == ""){
			alert("주소 확인!!!");
			return;
		} else if($("phone").val() == ""){
			alert("휴대폰 번호 확인!!!");
			return;
		} else {
			$("#act").val("modify");
			$("#memberform").attr("action", "${root}/user.do").submit();
		}
	});
	 
});
</script>
</head>
<body>
<%@include file="/menu.jsp" %>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<form id="memberform" method="post" action="">
			<input type="hidden" name="act" id="act" value="">
			<div class="form-group" align="left">
				<label for="name">이름</label>
				<input type="text" class="form-control" id="name" name="name" value="${userinfo.name}" disabled="disabled">
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" value="${userinfo.userId}" disabled="disabled">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="password" name="password" value="${userinfo.password}">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호재입력</label>
				<input type="password" class="form-control" id="pwdcheck" name="pwdcheck" value="${userinfo.password}">
			</div>
			<div class="form-group" align="left">
				<label for="tel">전화번호</label>
				<input type="text" class="form-control" id="phone" name="phone" value="${userinfo.phone }">
			</div>
			<div class="form-group" align="left">
				<label for="address">주소</label><br>
				<input type="text" class="form-control" id="address" name="address" value="${userinfo.address }">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="registerBtn">저장</button>
				<button type="button" class="btn btn-warning" id="cancelBtn">취소</button>
				<button type="button" class="btn btn-danger" id="deleteBtn">탈퇴</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>