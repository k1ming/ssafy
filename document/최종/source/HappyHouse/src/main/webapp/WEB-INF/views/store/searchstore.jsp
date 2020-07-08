<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath}" />
<c:if test="${userinfo == null }">
	<c:redirect url="/views/index.jsp"></c:redirect>
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
<style type="text/css">
body {
    margin: 0; /* 리셋을 하지 않은 경우 추가 */
}
#app {
    min-height: calc(100vh - 450px);
}
</style>
<title>Happy House</title>
<script type="text/javascript">
	$(document).ready(function() {
		<c:if test="${param.key == 'upL' }">
		$("#upL option[value='${param.word}']").attr("selected", "");
		</c:if>
		<c:if test="${param.key == 'upM' }">
		$("#upL option[value='${upL}']").attr("selected", "");
		$("#upM option[value='${param.word}']").attr("selected", "");
		</c:if>
		<c:if test="${param.key == 'upS' }">
		$("#upL option[value='${upL}']").attr("selected", "");
		$("#upM option[value='${upM}']").attr("selected", "");
		$("#upS option[value='${param.word}']").attr("selected", "");
		</c:if>
	});

	function update(selectedObj) {
		if (selectedObj.id == "upL") {
			var dongcode = '${param.dongcode}';
			if (dongcode == "") {
				alert('관심지역을 선택하세요');
				return;
			}
			location.href = "/store/mvsearchstore?dongcode=${param.dongcode}&key=upL&word="
					+ $("#upL option:selected").val();
		} else if (selectedObj.id == "upM") {
			location.href = "/store/mvsearchstore?dongcode=${param.dongcode}&key=upM&word="
					+ $("#upM option:selected").val();
		}
	}
	function searchStore() {
		var dongcode = '${param.dongcode}';
		if (dongcode == "") {
			alert('관심지역을 선택하세요');
			return;
		}
		var key;
		var word;
		if ($('#upS option:selected').val() != "") {
			key = "upS";
			word = $('#upS option:selected').val();
		} else if ($('#upM option:selected').val() != "") {
			key = "upM";
			word = $('#upM option:selected').val();
		} else if ($('#upL option:selected').val() != "") {
			key = "upL";
			word = $('#upL option:selected').val();
		} else {
			key = "all";
		}
		location.href = "/store/searchstore?dongcode=${param.dongcode}&key="
				+ key + "&word=" + word;
	}
	function pageMove(pg) { 
		location.href = "/store/searchstore?dongcode=${param.dongcode}&key="
			+ '${param.key}' + "&word=" + '${param.word}' + "&pg=" + pg;
	}
</script>
<style type="text/css">
h1 {
	margin-top: 50px;
}

select {
	margin: 30px;
	width: 300px !important;
}

#searchbtn {
	height: 40px;
	margin: auto 0;
}

#searchform {
	align: center;
}

#storedata {
	width: 95%;
}


</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp" />
	<c:if test="${msg != null}">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<div class="row" id="app">
		<div class="left col-lg-3">
			<div align="left">
				<a style="padding-left: 30px; padding-right: 110px">관심 지역 목록</a>
				<a href="${root }/moveFavArea" style="color: black;">추가</a>
			</div>
			<div style="padding-left: 30px">
				<c:forEach var="fav" items="${favlist }">
					<hr>
					<a href="${root }/store/mvsearchstore?dongcode=${fav.code}">
						${fav.sido } / ${fav.sigungu } / ${fav.dong } </a>&nbsp
				<a href="${root }/delFavArea?dongcode=${fav.code}"
						style="color: black">삭제</a>
				</c:forEach>
				<c:if test="${favlist.size() == 0 }">
					<hr>
				등록하신 관심지역이 없습니다.<br>
				등록 후 이용해 주세요
			</c:if>
			</div>
		</div>
		<div class="right col-lg-9">
			<div id="searchform" method="get" class="form" align="center">
				<div class="row" style="margin-left:300px;">
					<select class="form-control col-lg-2" name="upL" id="upL"
						onchange="javascript:update(this)">
						<option value="" selected disabled hidden>==업종대분류==</option>
						<c:forEach var="item" items="${upLlist }">
							<option id="${item.code }" value="${item.code}">${item.codeNm}</option>
						</c:forEach>
					</select> <select class="form-control col-lg-2" name="upM" id="upM"
						onchange="javascript:update(this)">
						<option value="" selected disabled hidden>==업종중분류==</option>
						<c:forEach var="item" items="${upMlist }">
							<option value="${item.code }">${item.codeNm }</option>
						</c:forEach>
					</select> <select class="form-control col-lg-2" name="upS" id="upS">
						<option value="" selected disabled hidden>==업종소분류==</option>
						<c:forEach var="item" items="${upSlist }">
							<option value="${item.code }">${item.codeNm }</option>
						</c:forEach>
					</select>
					<button id="searchbtn" type="button"
						class="btn btn-warning col-lg-1"
						onclick="javascript:searchStore(); ">검색</button>
				</div>
			</div>
			<div id="pagenav">${navigation.navigator}</div>
			<div id="storedata" align="center">
				<table class="table table-striped table-bordered table-hover">
					<thead align="center" style="background-color: #E28B00;">
						<tr>
							<td>상가번호</td>
							<td>상가명</td>
							<td>업종소분류</td>
							<td>도로명주소</td>
							<td>우편번호</td>
						</tr>

					</thead>
					<tbody align="center">
						<c:if test="${ storeList.size() != 0 }">
							<c:forEach var="store" items="${ storeList }">
								<tr>
									<!-- 출력공간1(작성된 글들 출력) -->
									<td>${ store.no }</td>
									<td align="left">${ store.shopName }</td>
									<td align="left">${ store.upjongS }</td>
									<td align="left">${ store.address }</td>
									<td>${ store.postCode }</td>
								</tr>
							</c:forEach>
						</c:if>
						
						<c:if test="${ storeList.size() == 0 }">
							<tr>
								<!--  출력공간2(작성된 글이 없읍니다.) -->
								<td colspan="5">검색하신 조건에 맞는 상가 정보가 없습니다.
								<td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>