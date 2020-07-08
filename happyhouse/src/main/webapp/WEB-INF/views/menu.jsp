<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
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
	color: white;
}
#menu {
  display: inline-block;
  width: 100%;
  margin-top: 190px;
  padding-bottom: 100px;
}
.nav-pills{
		margin: 0; 
		padding: 0;		
		}
.nav-pills .nav-item{ 
		float: left;
		width: 100%;
  		list-style: none;  		
  		margin: 1px;
		 }

.nav-pills .nav-item .nav-link {
		display: block;
		padding: 12px;
		text-align: center;		
		text-decoration: none;
		letter-spacing: 0.1em; 
		font-weight: bold;		
		background-color: #727272;
		line-height: 35px;
		color: #eee;		
	}
  .nav-pills .nav-item .nav-link:hover{
     background-color: #CC6E10;
  }
  .nav-pills .nav-item .nav-link:active{
     background-color: #CC6E10;
  }
  
  .sub{  	 
     position: fixed;
     margin: 0px 0px 0px 0px;
 }
  .nav-pills:after{
     height: 10px;
	 visibility: hidden;
	 display: block;
	 clear: both;	
   }   
   
.top1 {
       background-image: url("/resource/img/logo.jpg");
       -webkit-background-size: cover; /* For WebKit*/
       -moz-background-size: cover;    /* Mozilla*/
       -o-background-size: cover;      /* Opera*/
       background-size: cover ;
       background-repeat: no-repeat;
       width: 100%;
       height: 330px;      
}
#app{
	padding-top: 100px; 
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

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}

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

$('.nav-pills a').click(function(){
	$('.nav-pills a.active').removeClass('active');
	$(this).addClass('active'); 
});


</script>


<c:if test="${userinfo == null}">
	<div id="msg" align="center">${msg}</div>
	<div class="non-member-top">
		<div class="row">
			<div class="col-lg-5"></div>
			<div class="col-lg-3">
				<a id="title" href="${root }/">
					<img id="logo" src="/resource/img/logo.jpg" alt="logo"/>
				</a>
			</div>
			<div class="col-lg-3">
				<div class="text-right">
					<div class="btn-group">
						<a href="${root }/mvjoin" class="btn btn-sm"><i
							class="fa fa-user pr-2"></i>회원가입</a>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-sm" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">&nbsp&nbsp
							로그인 &nbsp&nbsp</button>
						<ul class="dropdown-menu dropdown-menu-right dropdown-animation"
							aria-labelledby="header-top-drop-2">
							<li><jsp:include page="/WEB-INF/views/user/login.jsp" />
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
				<a id="title" href="${root }/">
					<img id="logo" src="/resource/img/logo.jpg" alt="logo"/>
				</a>
			</div>
			<div class="col-lg-3">
				<div class="text-right">
					<div style="display:inline;">
						${userinfo.name} 님
					</div>
					<div class="btn-group">
						<a href="${root }/mvmodify" class="btn btn-sm"><i
							class="fa fa-user pr-2"></i>회원정보</a>
					</div>
					<div class="btn-group">
						<a href="${root }/logout" class="btn btn-sm"><i
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
			id="notice" class="nav-link" href="${ root }/board/notice">공지사항</a></li>
		<li role="presentation" class="nav-item"><a
			id="news" class="nav-link" href="${ root }/news">오늘의 뉴스</a></li>
		<li role="presentation" class="nav-item"><a
			id="qna" class="nav-link" href="${ root }/qna">QnA</a></li>
		<c:if test="${userinfo != null }">
		<li role="presentation" class="nav-item"><a
			id="free" class="nav-link" href="${ root }/board/free">자유게시판</a></li>
		</c:if>
		<li role="presentation" class="nav-item"><a
			id="searchAll" class="nav-link" href="${ root }/house.do?act=searchAll">주택거래정보</a></li>
		<li role="presentation" class="nav-item"><a
			id="searchAll" class="nav-link" href="${ root }/house/houseLocView.jsp">주택위치정보</a></li>
		<c:if test="${userinfo != null }">
			<li role="presentation" class="nav-item"><a
				id="searchstore" class="nav-link" href="${root }/store/mvsearchstore">상권정보</a></li>
			<li role="presentation" class="nav-item"><a
				id="mvfavarea" class="nav-link" href="${root }/moveFavArea">관심지역 설정</a></li>
		</c:if>
		<c:if test="${userinfo.type == 1 }">
			<li role="presentation" class="nav-item"><a
				id="list" class="nav-link" href="${root }/userlist">회원목록</a></li>
		</c:if>
	</ul>
</div>



