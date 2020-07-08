<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset=utf-8>
<meta http-equiv=X-UA-Compatible content="IE=edge">
<meta name=viewport content="width=device-width,initial-scale=1">
<link rel=icon href=/board/qna/favicon.ico>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>board-qna</title>
<link href=/qna/js/app.js rel=preload as=script>
<link href=/qna/js/chunk-vendors.js rel=preload as=script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp" />
	<noscript>
		<strong>We're sorry but board-qna doesn't work properly
			without JavaScript enabled. Please enable it to continue.</strong>
	</noscript>
	<div id=app></div>
	<script src=/qna/js/chunk-vendors.js></script>
	<script src=/qna/js/app.js></script>
</body>
</html>