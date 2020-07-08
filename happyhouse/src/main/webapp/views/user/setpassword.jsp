<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
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
	$("#setBtn").click(function() {
		if($("#newpass").val() != $("#pwdcheck").val()) {
			alert("비밀번호 확인!!!");
			return;
		} else {
<<<<<<< HEAD
			$("#passwordform").attr("action", "${root}/setpassword").submit();
=======
			$("#passwordform").attr("action", "${root}/user.do").submit();
>>>>>>> branch 'master' of https://lab.ssafy.com/cyclopki/happyhouse.git
		}
	});
	 
});
</script>
</head>
<body>
<%@include file="/menu.jsp" %>
<div class="container" align="center">
	<h3>비밀번호 재설정</h3>
	<div class="col-lg-6" align="center">
		<form id="passwordform" method="post" action="">
		<input type="hidden" name="no" id="no" value="${no}">
		<input type="hidden" name="act" id="act" value="setpassword">
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="newpass" name="newpass" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호재입력</label>
				<input type="password" class="form-control" id="pwdcheck" name="pwdcheck" placeholder="">
			</div>
			<div>
				<button type="button" class="btn btn-primary" id="setBtn">설정</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>