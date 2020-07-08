<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:if test="${userinfo == null }">
	<c:redirect url="/user.do"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>Happy House</title>
<script type="text/javascript">	
	<c:if test="${msg != null }">
		alert("${msg}");
		<%session.removeAttribute("msg");%>
	</c:if>
	$(document).ready(function(){
		<c:if test="${param.sido != null }">
			$("#sido option[value='${param.sido}']").attr("selected", "true");								
		</c:if>
		<c:if test="${param.sigungu != null }">
			$("#sigungu option[value='${param.sigungu}']").attr("selected", "true");								
		</c:if>
	});
	function update(selectedObj){
		var sido = "";
		var sigungu = "";
		sido = "&sido=" + $("#sido option:selected").val();
		if(selectedObj.id == "sigungu"){
			sigungu = "&sigungu=" + $("#sigungu option:selected").val();		
		}
		location.href = "${root}/moveFavArea?" + sido + sigungu;
	}
	function addFavArea() {
		if($("#sido option:selected").val() == ""){
			alert("시/도 입력!!");
			return;
		}
		if($("#sigungu option:selected").val() == ""){
			alert("시군구 입력!!!");
			return;
		}
		if($("#dong option:selected").val() == ""){
			alert("동 입력!!!");
			return;
		}
		document.getElementById("searchform").submit();
	}
</script>
<style type="text/css">
	body {
	    margin: 0; /* 리셋을 하지 않은 경우 추가 */
	}
	#app {
	    min-height: calc(100vh - 450px);
	}
	h1 {
		margin-top : 50px;
	}
	select {
		margin : 40px;
		width : 400px !important;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp" />
	<div class="container" align="center" id="app">
		<h1>관심지역</h1>
		관심지역설정
		<form id="searchform" method="get" class="form col-lg-9"
			action="${root }/addFavArea">
			<div>
				<select class="form-control" name="sido" id="sido" onchange="javascript:update(this)">
					<option value="" selected disabled hidden>==시/도==</option>
					<c:forEach var="item" items="${sidolist }">
						<option value="${item}">${item}</option>				
					</c:forEach>
				</select> 
			</div>
			<div>
				<select class="form-control" name="sigungu" id="sigungu" onchange="javascript:update(this)">
					<option value="" selected disabled hidden>==시/구/군==</option>
					<c:forEach var="item" items="${sigungulist }">
						<option value="${item }">${item }</option>								
					</c:forEach>
				</select> 
			</div>
			<div>
				<select class="form-control" name="dong" id="dong">
					<option value="" selected disabled hidden>==동==</option>
					<c:forEach var="item" items="${donglist }">
						<option value="${item }">${item }</option>												
					</c:forEach>
				</select> 
			</div>
			<button type="button" class="btn btn-warning" onclick="javascript:addFavArea(); ">등록</button>
		</form>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>