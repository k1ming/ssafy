<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="saveid" value="${cookie.ssafy_id.value}" />
	<c:set var="idck" value=" checked=\"checked\"" />
</c:if>
<script type="text/javascript">
	function login() {
		if (document.getElementById("loginid").value == "") {
			alert("아이디 입력!!!");
			return;
		} else if (document.getElementById("loginpass").value == "") {
			alert("비밀번호 입력!!!");
			return;
		} else {
			document.getElementById("loginform").action = "${root}/login";
			document.getElementById("loginform").submit();
		}
	}

	function findPass() {
		document.location.href = "${root}/mvfind";
	}
</script>


<form id="loginform" method="post" action="">
	<input type="hidden" name="act" id="act" value="login">
	<div class="form-group" align="left">
		<label for="">아이디</label> <input type="text" class="form-control"
			id="loginid" name="loginid" placeholder="" value="${saveid}">
	</div>
	<div class="form-group" align="left">
		<label for="">비밀번호</label> <input type="password" class="form-control"
			id="loginpass" name="loginpass" placeholder=""
			onkeydown="javascript:if(event.keyCode == 13) {login();}">
	</div>
	<div class="form-group form-check" align="right">
		<label class="form-check-label"> <input
			class="form-check-input" type="checkbox" id="idsave" name="idsave"
			value="saveok" ${idck}> 아이디저장
		</label>
	</div>
	<div class="form-group" align="center">
		<button type="button" class="btn btn-warning"
			onclick="javascript:login();">로그인</button>
		<button type="button" class="btn btn-primary"
			onclick="javascript:findPass();">비밀번호 찾기</button>
	</div>
</form>

