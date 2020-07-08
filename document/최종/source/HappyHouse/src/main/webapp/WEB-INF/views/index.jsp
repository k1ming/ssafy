<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
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
body {
    margin: 0; /* 리셋을 하지 않은 경우 추가 */
}
#app {
    min-height: calc(100vh - 450px);
}
.carousel-inner > .carousel-item > img{ 
 width: 640px; height: 520px;  
} 
.carousel-control-prev{ 
 width: 50px;
}
.carousel-control-next{ 
 width: 50px;
}
#carousel-caption{
 margin-left: -70px;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
			</script> 
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
			</script> 
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
			</script> 
<script>
	localStorage.setItem('userNo', '${userinfo.no}');
	localStorage.setItem('userType', '${userinfo.type}');
</script>
</head>
	<body>
			
		<jsp:include page="/WEB-INF/views/menu.jsp" />
		<div id="app">
			
			<div id="demo" class="carousel slide" data-ride="carousel" data-pause="hover" data-interval="2000"> 
				<div class="carousel-inner"> <!-- 슬라이드 쇼 --> 
					<div class="carousel-item active"> <!--가로--> 
						<img class="d-block w-100" src="/resource/img/bon.jpg" alt="First slide"> 
						<div id = "carousel-caption" class="carousel-caption d-none d-md-block"> 
							<h5 align="left"> 광화문 풍림 스페이스 본</h5> 
							<hr size = "2px" color = "white" align="left" width="50%">
							<p align="left">거래금액 : 105,000 ~ | 건축년도 : 2008년도 </p>
						 </div>
				    </div> 
				    <div class="carousel-item"> 
				    	<img class="d-block w-100" src="/resource/img/skyrex.jpg" alt="Second slide">
				    	<div id = "carousel-caption" class="carousel-caption d-none d-md-block"> 
							<h5 align="left"> 대성 스카이 렉스</h5> 
							<hr size = "2px" color = "white" align="left" width="50%">
							<p align="left">거래금액 : 101,500 ~ | 건축년도 : 2008년도 </p>
						</div> 
				    </div> 
				    <div class="carousel-item"> 
				    <img class="d-block w-100" src="/resource/img/forest.jpg" alt="Third slide">
				    		<div id = "carousel-caption" class="carousel-caption d-none d-md-block"> 
							<h5 align="left"> 포레스트 힐 시티</h5> 
							<hr size = "2px" color = "white" align="left" width="50%">
							<p align="left">거래금액 : 20,000 ~ | 건축년도 : 2017년도 </p>
						</div>  
				    </div> <!-- / 슬라이드 쇼 끝 -->
				    
				     <!-- 왼쪽 오른쪽 화살표 버튼 --> 
				     <a class="carousel-control-prev" href="#demo" data-slide="prev"> 
				     	<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
				     <!-- <span>Previous</span> --> </a>
				     <a class="carousel-control-next" href="#demo" data-slide="next"> 
				     	<span class="carousel-control-next-icon" aria-hidden="true"></span> 
				     <!-- <span>Next</span> --> </a> <!-- / 화살표 버튼 끝 --> 
				     <!-- 인디케이터 --> 
				     <ul class="carousel-indicators"> 
					     <li data-target="#demo" data-slide-to="0" class="active"></li> 
					     <!--0번부터시작--> 
					     <li data-target="#demo" data-slide-to="1"></li> 
					     <li data-target="#demo" data-slide-to="2"></li> 
				     </ul> <!-- 인디케이터 끝 --> 
				</div> 
				</div> 
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</body>
</html>