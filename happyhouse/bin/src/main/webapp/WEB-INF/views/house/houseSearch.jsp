<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<title>Happy House : House 상세조회</title>
	</head>
	<body>
		<!-- 로그인정보 출력 공간 -->
		<%@include file="/menu.jsp" %>
		<div class="container" align="center">
				<div align="center">
					<h5 align="right">주택거래정보</h5>
					
					<c:if test="${ housedeal != null }">
						<div align="center">
							<table class="table table-dark table-hover">
								<tbody align="center">
									<tr>
										<td width="300">번호</td>
										<td align="left">${ housedeal.no }</td>
									</tr>
									<tr>
										<td width="300">법정동</td>
										<td align="left">${ housedeal.dong }</td>
									</tr>
									<tr>
										<td width="300">이름</td>
										<td align="left">${ housedeal.aptName }</td>
									</tr>
									<tr>
										<td width="300">법정동 코드</td>
										<td align="left">${ housedeal.code }</td>
									</tr>
									<tr>
										<td width="300">거래 금액</td>
										<td align="left">${ housedeal.dealAmount }</td>
									</tr>
									<tr>
										<td width="300">건축 연도</td>
										<td align="left">${ housedeal.buildYear }</td>
									</tr>
									<tr>
										<td width="300">거래 연도</td>
										<td align="left">${ housedeal.dealYear }</td>
									</tr>
									<tr>
										<td width="300">거래 월</td>
										<td align="left">${ housedeal.dealMonth }</td>
									</tr>
									<tr>
										<td width="300">거래 일</td>
										<td align="left">${ housedeal.dealDay }</td>
									</tr>
									<tr>
										<td width="300">전용 면적</td>
										<td align="left">${ housedeal.area }</td>
									</tr>
									<tr>
										<td width="300">층</td>
										<td align="left">${ housedeal.floor }</td>
									</tr>
									<tr>
										<td width="300">지번 주소</td>
										<td align="left">${ housedeal.jibun }</td>
									</tr>
									<tr>
										<td width="300">거래 구분</td>
										<c:choose>
											<c:when test="${ housedeal.type == 1 }">
												<td align="left">아파트 매매</td>
											</c:when>
											<c:when test="${ housedeal.type == 2 }">
												<td align="left">아파트 전월세</td>
											</c:when>
											<c:when test="${ housedeal.type == 3 }">
												<td align="left">다세대 매매</td>
											</c:when>
											<c:when test="${ housedeal.type == 4 }">
												<td align="left">다세대 전월세</td>
											</c:when>
											<c:otherwise>
												<td align="left">기타</td>													
											</c:otherwise>
										</c:choose>
									</tr>
									<tr>
										<td width="300">월세</td>
										<td align="left">${ housedeal.rentMoney }</td>
									</tr>
								</tbody>
							</table>
						</div>	
					</c:if>
				</div>
			</div>
	</body>
</html>