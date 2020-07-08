<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<style type="text/css">
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

#title {
	text-decoration: none;
	font-size: 30px;
	color: black;
}

.nav-pills a {
	background-color: #6c757d !important;
}
</style>

<c:if test="${userinfo == null}">
	<div id="msg" align="center">${msg}</div>
	<div class="non-member-top">
		<div class="row">
			<div class="col-lg-8"></div>
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
							<li><%@include file="/user/login.jsp"%>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>
</c:if>

<c:if test="${userinfo != null}">
	<div class="member-top">
		<div class="row">
			<div class="col-lg-8"></div>
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