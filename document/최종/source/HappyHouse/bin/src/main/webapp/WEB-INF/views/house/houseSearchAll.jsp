<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${ pageContext.request.contextPath }"/>
<c:choose>
	<c:when test="${ key == aptname}">
		<c:set var="iskeyaptname" value=" selected"/>
	</c:when>
	<c:otherwise>
		<c:set var="iskeydong" value=" selected"/>
	</c:otherwise>
</c:choose>

<c:if test="${ types != null }">
	<c:if test="${ fn:length(types) != 0 }">
		<c:forEach var="type" items="${ types }">
			<c:choose>
				<c:when test="${ type == '1' }">
					<c:set var="iscktype1" value=" checked"/>
				</c:when>
				<c:when test="${ type == '2' }">
					<c:set var="iscktype2" value=" checked"/>
				</c:when>
				<c:when test="${ type == '3' }">
					<c:set var="iscktype3" value=" checked"/>
				</c:when>
				<c:when test="${ type == '4' }">
					<c:set var="iscktype4" value=" checked"/>
				</c:when>
			</c:choose>
		</c:forEach>
	</c:if>
</c:if>



<!DOCTYPE html>
<html>
	<head>
		<title>Happy House : House 목록</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script type="text/javascript">

			function search() {
				var isTypeCk = false;
		        var arr_types = document.getElementsByName("types");
		        for(var i=0;i<arr_types.length;i++){
		            if(arr_types[i].checked == true) {
		            	isTypeCk = true;
		                break;
		            }
		        }
		    
		        if(!isTypeCk){
		        	alert("주택타입을 선택하지 않아 전체 조회합니다.");
		        }
										
				searchform.action = "${ root }/house.do";
				searchform.submit();
			}
			
			function pageMove(pg) { 
				document.getElementById("pg").value=pg;
				document.getElementById("pageform").action = "${root}/house.do";
				document.getElementById("pageform").submit();
			}
		</script>
	</head>
	<body>
	<form name="pageform" id="pageform" method="GET" action="">
		<input type="hidden" name="act" id="act" value="searchAll">
		<input type="hidden" name="pg" id="pg" value="">
		<c:if test="${ types != null }">
			<c:if test="${ fn:length(types) != 0 }">
				<c:forEach var="type" items="${ types }">
					<input type="hidden" name="types" id="types" value="${ type }">
				</c:forEach>
			</c:if>
		</c:if>
		<input type="hidden" name="key" id="key" value="${ key }">
		<input type="hidden" name="word" id="word" value="${ word }">
	</form>
		<!-- 로그인정보 출력 공간 -->
		<%@include file="/menu.jsp" %>
		<div class="container" align="center">
				<div align="center">
					<div align="right">
						<div align="center">
							<h5 align="right">주택거래정보</h5>
						</div>
						<table align="right">
							<!-- 검색 필터 공간  -->
							<form id="searchform" method="get" class="form-inline" action="">
						  	<input type="hidden" name="act" id="act" value="searchAll">
								<tr align="right">
									<td align="right">
										<td><input type="checkbox" name="types" value="1" ${ iscktype1 }>아파트 매매</td>
										<td><input type="checkbox" name="types" value="2" ${ iscktype2 }>아파트 전월세</td>
										<td><input type="checkbox" name="types" value="3" ${ iscktype3 }>다세대 매매</td>
										<td><input type="checkbox" name="types" value="4" ${ iscktype4 }>다세대 전월세</td>
									</td>
									<td align="right">
										<select name="key">
											<option value="dong" ${ iskeydong }>법정동</option>
											<option value="aptname" ${ iskeyaptname }>이름</option>
										</select>
										<input type="text" placeholder="검색어 입력" name="word" value="${ word }">
										<button type="button" onclick="javascript:search();">검색</button>
									</td>
								</tr>
							</form>
						</table>
					</div>
					
					<div align="center">
						<table class="table table-dark table-hover" >
							<thead align="center">
								<tr>
									<td>번호</td>
									<td>법정동</td>
									<td>이름</td>
									<td>법정동 코드</td>
									<td>거래 금액</td>
									<td>건축 연도</td>
									<td>거래 연도</td>
									<td>거래 월</td>
									<td>거래 일</td>
									<td>전용 면적</td>
									<td>층</td>
									<td>지번 주소</td>
									<td>거래 구분(1234)</td>
									<td>월세</td>
								</tr>
							</thead>
							<tbody align="center">
								<c:if test="${ housedeals.size() != 0 }">
									<c:forEach var="house" items="${ housedeals }">
										<tr>
											<!-- 출력공간1(작성된 글들 출력) -->
											<td>${ house.no }</td>
											<td>${ house.dong }</td>
											<td><a style="color:white;" href="${ root }/house.do?act=search&no=${ house.no }">${ house.aptName }</a></td>
											<td>${ house.code }</td>
											<td>${ house.dealAmount }</td>
											<td>${ house.buildYear }</td>
											<td>${ house.dealYear }</td>
											<td>${ house.dealMonth }</td>
											<td>${ house.dealDay }</td>
											<td>${ house.area }</td>
											<td>${ house.floor }</td>
											<td>${ house.jibun }</td>
											<c:choose>
												<c:when test="${ house.type == 1 }">
													<td>아파트 매매</td>
												</c:when>
												<c:when test="${ house.type == 2 }">
													<td>아파트 전월세</td>
												</c:when>
												<c:when test="${ house.type == 3 }">
													<td>다세대 매매</td>
												</c:when>
												<c:when test="${ house.type == 4 }">
													<td>다세대 전월세</td>
												</c:when>
												<c:otherwise>
													<td>기타</td>													
												</c:otherwise>
											</c:choose>
											<td>${ house.rentMoney }</td>
										</tr>
									</c:forEach>
									
									<table>
								  		<tr>
								  			<td>
								  				<!-- page 출력부분 -->
								  				${ navigation.navigator }
								  			</td>
								  		</tr>
								  	</table>
								  		
								</c:if>
								<c:if test="${ housedeals.size() == 0 }">
									<tr>
										<!--  출력공간2(조건에 부합하는 매물이 없읍니다.) -->
										<td colspan="14">조건에 부합하는 매물이 없읍니다.<td>										
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>	
				</div>
			</div>
	</body>
</html>