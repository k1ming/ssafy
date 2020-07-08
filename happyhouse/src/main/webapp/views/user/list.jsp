<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:if test="${userinfo.type != 1}">
	<c:redirect url="${root }user.do"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY-글목록</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function searchMember() {
<<<<<<< HEAD
		document.getElementById("searchform").action = "${root}/find";
		document.getElementById("searchform").submit();
	}
	function pageMove(pg) { 
		document.getElementById("pg").value=pg;
		document.getElementById("pageform").action = "${root}/list";
=======
		document.getElementById("searchform").action = "${root}/user.do";
		document.getElementById("searchform").submit();
	}
	function pageMove(pg) { 
		document.getElementById("pg").value=pg;
		document.getElementById("pageform").action = "${root}/user.do";
>>>>>>> branch 'master' of https://lab.ssafy.com/cyclopki/happyhouse.git
		document.getElementById("pageform").submit();
	}
</script>
<style type="text/css">
#userdata{
	width : 100%;
}
#th1, #th2, #th6{
	width : 10%;
}
#th3, #th4{
	width : 15%;
}
#th5{
	width : 40%;
}
#userdata tbody{
	background-color: #343a40;
}
</style>
</head>
<body>
	<%@include file="/menu.jsp"%>
	<div class="container" align="center">
		<div align="center">
			<h4>회원 목록</h4>
			<form id="searchform" method="get" class="form-inline" action="">
				<input type="hidden" name="act" id="act" value="list">
				<table class="table table-borderless">
					<tr>
						<td align="right"><select class="form-control" name="key"
							id="key">
								<option value="name" selected="selected">이름</option>
								<option value="userid">아이디</option>
						</select> <input type="text" class="form-control" placeholder="검색어 입력."
							name="word" id="word">
							<button type="button" class="btn btn-primary"
								onclick="javascript:searchMember();">검색</button></td>
					</tr>
				</table>
			</form>
			<form name="pageform" id="pageform" method="GET" action="">
				<input type="hidden" name="act" id="act" value="list">
				<input type="hidden" name="pg" id="pg" value="">
				<input type="hidden" name="key" id="key" value="${key}">
				<input type="hidden" name="word" id="word" value="${word}">
			</form>
			<div id="pagenav">${navigation.navigator}</div>
			<div id="userdata">
				<table class="table table-dark table-hover">
					<thead align="center">
						<tr>
							<th id="th1">회원번호</th>
							<th id="th2">회원명</th>
							<th id="th3">연락처</th>
							<th id="th4">아이디</th>
							<th id="th5">주소</th>
							<th id="th6">회원구분</th>
						</tr>
					</thead>
					<tbody align="center">
						<c:forEach var="user" items="${userlist}">
							<tr>
								<td>${user.no}</td>
								<td>${user.name}</td>
								<td>${user.phone}</td>
								<td>${user.userId}</td>
								<td>${user.address}</td>
								<td>
									<c:if test="${user.type == 1 }">관리자</c:if> 
									<c:if test="${user.type == 2 }">회원</c:if>
								</td>
							</tr>
						</c:forEach>
						<c:if test="${userlist.size() == 0 }">
							<tr>
								<td colspan="6">조회 결과 없음</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>