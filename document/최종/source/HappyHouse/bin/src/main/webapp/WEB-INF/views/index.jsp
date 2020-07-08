<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="saveid" value="${cookie.ssafy_id.value}" />
	<c:set var="idck" value=" checked=\"checked\"" />
</c:if>

<!DOCTYPE html>
<html lang="ko">
<head>

<title>Happy House</title>
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
<style type="text/css">
#banner {
	background-image: url('img/banner.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	margin-top: 30px;
	height: 450px !important;
	background-position: 50% 70%;
	animation: fadein 5s;
	opacity: 0.7;
	background-position: 50% 70%;
}
#select{
	padding:15px;'
	margin: 15px;
	background-color:#4d4d4d;
	
}
#sido, #gugun, #dong{
	border-radius: 8px;
}

keyframes fadein {
	from {opacity: 0.0;
}

to {
	opacity: 0.7;
}

}
#banner-text {
	position: absolute;
	top: 60%;
	left: 50%;
	transform: translate(-50%, -50%);
	font-size: 30px;
	opacity: 0.7;
	color: white;
	font-family: serif;
}
</style>



<style type="text/css">
#header{
	height: 150px;
}
#logo{
	width: 200px;
	height: 100px;
}
#logo:hover{
	opacity: 0.7;
}
.text-right{
	padding-top : 50px;
}
.btn-group {
	padding: 10px;
}

.dropdown-menu {
	width: 300px;
	height: 300px;
}

#loginform {
	padding: 20px;
}

#title{
	text-decoration: none;
	font-size: 35px;
	color: black;
}

.nav-pills a {
	color: white;
	font-weight: bold;
	background-color: #81DAF5 !important;
}

.nav-pills a.active {
	background-color: #007bff !important;
}

#menu{
	margin-bottom: 20px;
}
</style>
<script type="text/javascript">

$(window).on('load',function(){
	var act = '${param.act}';
	var id;
	if(act != ""){
		if(act == 'select'){
			var type = '${param.type}';
			if(type == 1){ //공지
				id = 'notice';
			}else if(type == 2){//뉴스
				id = 'news';
			}else if(type == 3){//자유
				id = 'free';
			}
		} else if(act =='mvsearchstore'){
			id = 'searchstore';
		} 
		else{
			id = act;
		}
	
		$('.nav-pills a.active').removeClass('active');
		$('#'+id).addClass('active');     		
	}
});
	
</script>
<script type="text/javascript">
	function login() {
		if (document.getElementById("loginid").value == "") {
			alert("아이디 입력!!!");
			return;
		} else if (document.getElementById("loginpass").value == "") {
			alert("비밀번호 입력!!!");
			return;
		} else {
			document.getElementById("loginform").action = "${root}/user.do";
			document.getElementById("loginform").submit();
		}
	}

	function findPass() {
		document.location.href = "${root}/user.do?act=mvfind";
	}
</script>


</head>
<body>
	
	
	


	<c:if test="${userinfo == null}">
	<div id="msg" align="center">${msg}</div>
	<div class="non-member-top">
		<div class="row">
			<div class="col-lg-5"></div>
			<div class="col-lg-3">
				<a id="title" href="${root}/index.do">
					<img id="logo" src="${root }/resource/img/logo.jpg" alt="logo"/>
				</a>
			</div>
			<div class="col-lg-3">
				<div class="text-right">
					<div class="btn-group">
						<a href="${root }/user.do?act=mvjoin" class="btn btn-sm"><i
							class="fa fa-user pr-2"></i>회원가입</a>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-sm" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">&nbsp&nbsp
							로그인 &nbsp&nbsp</button>
						<ul class="dropdown-menu dropdown-menu-right dropdown-animation"
							aria-labelledby="header-top-drop-2">
							<li>

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

							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${userinfo != null}">
	<div class="member-top">
		<div class="row">
			<div class="col-lg-5"></div>
			<div class="col-lg-3">
				<a id="title" href="${root}/index.do">
					<img id="logo" src="${root }/resource/img/logo.jpg" alt="logo"/>
				</a>
			</div>
			<div class="col-lg-3">
				<div class="text-right">
					<div class="btn-group">
						<a href="${root }/user.do?act=mvmodify" class="btn btn-sm"><i
							class="fa fa-user pr-2"></i>회원정보</a>
					</div>
					<div class="btn-group">
						<a href="${root }/user.do?act=logout" class="btn btn-sm"><i
							class="fa fa-user pr-2"></i>로그아웃</a>
					</div>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>
</c:if>
<div id="menu">
	<ul class="nav nav-pills nav-justified">
		<li role="presentation" class="nav-item"><a
			id="notice" class="nav-link" href="${ root }/post.do?act=select&type=1">공지사항</a></li>
		<li role="presentation" class="nav-item"><a
			id="news" class="nav-link" href="${ root }/post.do?act=select&type=2">오늘의 뉴스</a></li>
		<c:if test="${userinfo != null }">
		<li role="presentation" class="nav-item"><a
			id="free" class="nav-link" href="${ root }/post.do?act=select&type=3">자유게시판</a></li>
		</c:if>
		<li role="presentation" class="nav-item"><a
			id="searchAll" class="nav-link" href="${ root }/house.do?act=searchAll">주택거래정보</a></li>
		<li role="presentation" class="nav-item"><a
			id="searchAll" class="nav-link" href="${ root }/house/houseLocView.jsp">주택위치정보</a></li>
		<c:if test="${userinfo != null }">
			<li role="presentation" class="nav-item"><a
				id="searchstore" class="nav-link" href="${root }/store.do?act=mvsearchstore">상권정보</a></li>
			<li role="presentation" class="nav-item"><a
				id="mvfavarea" class="nav-link" href="${root }/user.do?act=mvfavarea">관심지역 설정</a></li>
		</c:if>
		<c:if test="${userinfo.type == 1 }">
			<li role="presentation" class="nav-item"><a
				id="list" class="nav-link" href="${root }/user.do?act=list">회원목록</a></li>
		</c:if>
	</ul>
</div>







	<div id="banner">
		<div id="banner-text">HAPPY HOUSE</div>
	</div>
<script>
let colorArr = ['table-primary','table-success','table-danger'];
$(document).ready(function(){
	$.get("${pageContext.request.contextPath}/MainController"
		,{command:"sido"}
		,function(data, status){
			$.each(data, function(index, vo) {
				$("#sido").append("<option value='"+vo.sido_name+"'>"+vo.sido_name+"</option>");
			});//each
		}//function
		, "json"
	);//get
});//ready
$(document).ready(function(){
	$("#sido").change(function() {
		$.get("${pageContext.request.contextPath}/MainController"
				,{command:"sigungu", sido:$("#sido").val()}
				,function(data, status){
					$("#sigungu").empty();
					$("#sigungu").append('<option value="0">선택</option>');
					$.each(data, function(index, vo) {
						$("#sigungu").append("<option value='"+vo.sigungu_name+"'>"+vo.sigungu_name+"</option>");
					});//each
				}//function
				, "json"
		);//get
	});//change
	$("#sigungu").change(function() {
		$.get("${pageContext.request.contextPath}/MainController"
				,{command:"dong", sigungu:$("#sigungu").val(), sido:$("#sido").val()}
				,function(data, status){
					$("#dong").empty();
					$("#dong").append('<option value="0">선택</option>');
					$.each(data, function(index, vo) {
						$("#dong").append("<option value='"+vo.dong_name+"'>"+vo.dong_name+"</option>");
					});//each
				}//function
				, "json"
		);//get
	});//change
	$("#dong").change(function() {
		$.get("${pageContext.request.contextPath}/MainController"
				,{command:"apt", sido:$("#sido").val(), sigungu:$("#sigungu").val(), dong:$("#dong").val()}
				,function(data, status){
					$("#searchResult").empty();
					$("tbody").empty();
					$.each(data, function(index, vo) {
						let str = "<tr class="+colorArr[index%3]+">"
						+ "<td>" + vo.no + "</td>"
						+ "<td>" + vo.dong + "</td>"
						+ "<td>" + vo.AptName + "</td>"
						+ "<td>" + vo.jibun + "</td>"
						+ "<td>" + vo.code
						+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
						$("tbody").append(str);
					});//each
					geocode(data);
				}//function
				, "json"
		);//get
	});//change
	
});//ready

function geocode(jsonData) {
	let idx = 0;
	$.each(jsonData, function(index, vo) {
		let tmpLat;
		let tmpLng;
		$.get("https://maps.googleapis.com/maps/api/geocode/json"
				,{	key:'AIzaSyC3Jh6Rt72qHXe5GomCfP_4LAuHjs_sr0U'
					, address:vo.dong+"+"+vo.AptName+"+"+vo.jibun
				}
				, function(data, status) {
					//alert(data.results[0].geometry.location.lat);
					tmpLat = data.results[0].geometry.location.lat;
					tmpLng = data.results[0].geometry.location.lng;
					$("#lat_"+index).text(tmpLat);
					$("#lng_"+index).text(tmpLng);
					addMarker(tmpLat, tmpLng, vo.AptName);
				}
				, "json"
		);//get
	});//each
}
</script>
	<div  align="center" id="select">
		 <select id="sido">
			<option value="0">도/광역시</option>
		</select> 
		 <select id="sigungu">
			<option value="0">시/구/군</option>
		</select> 
		<select id="dong">
			<option value="0">동</option>
		</select>
	</div>
		<table class="table mt-2" style="width:40%; display: inline;" >
			<thead>
				<tr>
					<th>번호</th>
					<th>법정동</th>
					<th>아파트이름</th>
					<th>지번</th>
					<th>지역코드</th>
					<th>위도</th>
					<th>경도</th>
				</tr>
			</thead>
			<tbody id="searchResult">
			</tbody>
		</table>
	
	<div id="map" style="width:50%; height: 500px;float: right; margin: auto;"></div>
	<script
		src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC3Jh6Rt72qHXe5GomCfP_4LAuHjs_sr0U&callback=initMap"></script>
	<script>
		var multi = {
			lat : 37.5665734,
			lng : 126.978179
		};
		var map;
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				center : multi,
				zoom : 12
			});
			var marker = new google.maps.Marker({
				position : multi,
				map : map
			});
		}
		function addMarker(tmpLat, tmpLng, aptName) {
			var marker = new google.maps.Marker({
				position : new google.maps.LatLng(parseFloat(tmpLat),
						parseFloat(tmpLng)),
				label : aptName
			});
			marker.addListener('click', function() {
				map.setZoom(17);
				map.setCenter(marker.getPosition());
				callHouseDealInfo();
			});
			marker.setMap(map);
		}
		function callHouseDealInfo() {
			alert("you can call HouseDealInfo");
		}
	</script>

</body>
</html>