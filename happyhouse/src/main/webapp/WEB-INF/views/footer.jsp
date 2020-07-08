<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<style>

footer{
	margin-top: 100px;
	background-color: #DB7916;
	height: 105px;
}
footer img {
	width: 200px;
	height: 200x;

}
.foo_div{
	float: left;
}
.foo_div1{
	text-align: center;
}
.foo_div p{
	margin-top:5px;
	color: white;
}
.foo_div img{
	width: 100px;
	height: 100px;
	padding: 10px 10px 10px 10px;
}
</style>
<script>

</script>

<footer>
	<div class = "foo_div">
		<img src="/resource/img/ssafy.jpg">
	</div>
	<div class = "foo_div1">
		<span>SSAFY</span><p>					
		</p><span>신과함께</span><p>
		</p><p><span>신우현   |   서정호   |   기민균</span></p>
	</div>
</footer>