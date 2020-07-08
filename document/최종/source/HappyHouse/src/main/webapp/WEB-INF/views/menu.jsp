<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<style type="text/css">
#header{
	height: 290px;
}
#logo{
	padding-top: 20px;
	width: 250px;
	height: 80px;	
}
#logo:hover{
	opacity: 0.7;
}
.text-right{
	padding-top : 20px;
	font-size: 18px;
}
.member-top{
	color: white;	
	font-weight: bold;
}
.non-member-top{
	color: white;	
	font-weight: bold;
}

.btn-group {
	padding: 5px;
	color: white;	
	font-weight: bold;
}
.btn-sm {
	padding: 5px;
	color: white;	
	font-weight: bold;
}

.dropdown-menu {
	paddin-top : 100px;
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

.col-lg-3{
	font-weight: bold;
}

.page-header {
   background-image: url("/resource/img/logo.jpg");
   -webkit-background-size: cover; /* For WebKit*/
   -moz-background-size: cover;    /* Mozilla*/
   -o-background-size: cover;      /* Opera*/
   background-size: cover ;
   background-repeat: no-repeat;
   width: 100%;
   height: 100%;
}



.dropbtn {
  background-color: #ea2129;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  width: 100%;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  width: 100%;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
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
	$("ul.sub").hide();
	$("ul.nav-pills li").hover(function(){
	    $("ul:not(:animated)",this).slideDown("fast");
		},
		function(){
		   $("ul",this).slideUp("fast");
	});
});
$('.nav-pills a').click(function(){
	$('.nav-pills a.active').removeClass('active');
	$(this).addClass('active'); 
});



</script>
<div class = "top1" align="center">

	<c:if test="${userinfo == null}">
		<div id="msg" align="center">${msg}</div>
		<div class="non-member-top">
			<div class="row">
				<div class="col-lg-5"></div>
				<div class="col-lg-3">
					<a id="title" href="${root }/">
						<img id="logo" src="/resource/img/home.jpg" alt="logo"/>
					</a>
				</div>
				<div class="col-lg-3">
					<div class="text-right">
						<div class="btn-group">
								<a href="${root }/mvjoin" class="btn btn-sunflower"><i
								class="fa fa-user pr-2"></i>회원가입</a>
						</div>
						<div class="btn-group">
							<button type="button" class="btn btn-sunflower" data-toggle="dropdown"
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
						<img id="logo" src="/resource/img/home.jpg" alt="logo"/>
					</a>
				</div>
				<div class="col-lg-3">
					<div class="text-right">
						<div class="btn-group">
						<a href="${root }/mvmodify" class="btn btn-twitter"><i class="fa fa-twitter"></i> ${userinfo.name} </a>
						</div>
						<div class="btn-group">
						<a href="${root }/logout" class="btn btn-orange"><i class="fa fa-times-circle"></i>로그아웃</a>
						</div>
					</div>
				</div>
				<div class="col-lg-1"></div>
			</div>
		</div>
	</c:if>
	<div id="menu">
		<div class = "menubar">
			<ul class="nav nav-pills nav-justified">
				<li role="presentation" class="nav-item">
					<a id="notice" class="nav-link" href="${ root }/board/notice">공지사항</a>
				</li>
				<li role="presentation" class="nav-item dropdown">
					<a id="boards" class="nav-link dropbtn" href="#">게시판</a>
					<ul class="sub dropdown-content" style="padding-left:0;">
						<li role="presentation" class="nav-item" style="width: 100%; margin: 0;">
							<a id="news" class="nav-link" style="width: 100%; padding-left: 0; padding-right: 0;" href="${ root }/board/news">오늘의 뉴스</a>
						</li>
						<c:if test="${userinfo != null }">
							<li role="presentation" class="nav-item">
								<a id="qna" class="nav-link" href="${ root }/board/qna">QnA</a>
							</li>
							<li role="presentation" class="nav-item">
								<a id="free" class="nav-link" href="${ root }/board/free">자유게시판</a>
							</li>
						</c:if>
					</ul>
				</li>
				<li role="presentation" class="nav-item">
					<a id="searchAll" class="nav-link" href="${ root }/house/searchAll">주택거래정보</a>
				</li>		
				<c:if test="${userinfo != null }">
					<li role="presentation" class="nav-item">
						<a id="searchstore" class="nav-link" href="${root }/store/mvsearchstore">상권정보</a>
					</li>			
				</c:if>
				<c:if test="${userinfo.type == 1 }">
					<li role="presentation" class="nav-item">
						<a id="list" class="nav-link" href="${root }/userlist">회원목록</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>


