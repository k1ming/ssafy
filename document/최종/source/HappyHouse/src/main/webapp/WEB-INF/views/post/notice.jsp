<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<meta http-equiv=X-UA-Compatible content="IE=edge">
<meta name=viewport content="width=device-width,initial-scale=1">
<link rel=icon href=/favicon.ico>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>notice-board</title>
<link href=/notice/css/app.2c3d5320.css rel=preload as=style>
<link href=/notice/js/app.c6a8f33b.js rel=preload as=script>
<link href=/notice/js/chunk-vendors.3c331c5c.js rel=preload as=script>
<link href=/notice/css/app.2c3d5320.css rel=stylesheet>
<style type="text/css">
body {
    margin: 0; /* 리셋을 하지 않은 경우 추가 */
}
#app {
    min-height: calc(100vh - 450px);
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp" />
	<noscript>
		<strong>We're sorry but notice-board doesn't work properly
			without JavaScript enabled. Please enable it to continue.</strong>
	</noscript>
	<div id=app></div>
	<script src=/notice/js/chunk-vendors.3c331c5c.js></script>
	<script src=/notice/js/app.c6a8f33b.js></script>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>