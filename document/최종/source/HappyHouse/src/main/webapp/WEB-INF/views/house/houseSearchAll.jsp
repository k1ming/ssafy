<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${ pageContext.request.contextPath }"/>
<c:choose>
	<c:when test="${ key == 'aptname'}">
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
		<style type="text/css">
		body {
		    margin: 0; /* 리셋을 하지 않은 경우 추가 */
		}
		#app {
		    min-height: calc(100vh - 450px);
		}
		</style>
		<script type="text/javascript">

			// 전체 enter 이벤트 막기
			document.addEventListener('keydown', function(event) {
			  if (event.keyCode === 13) {
			    event.preventDefault();
			  };
			}, true);
		
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
										
				searchform.action = "${ root }/house/searchAll";
				searchform.submit();
			}
			
			function pageMove(pg) { 
				document.getElementById("pg").value=pg;
				document.getElementById("pageform").action = "${root}/house/searchAll";
				document.getElementById("pageform").submit();
			}
			
			function detail(no, pg){
				// alert(no);
				// alert(pg);
				/*
				if(pg > 0){
					document.getElementById("pg").value=pg;					
				}
				document.getElementById("no").value=no;
				document.getElementById("pageform").action = "${ root }/house/search";
				document.getElementById("pageform").submit();
				*/
				
				
				
				var form = document.createElement("form");
				form.setAttribute("charset", "UTF-8");
				form.setAttribute("method", "GET");  //Post 방식
				form.setAttribute("action", "${ root }/house/search"); //요청 보낼 주소
				// enter키 일때 동작 막아야함
				// form.setAttribute("onkeypress","if(event.keyCode==13){return;}");
				
				
				var hiddenField = document.createElement("input");
				hiddenField.setAttribute("type", "hidden");
				hiddenField.setAttribute("name", "no");
				hiddenField.setAttribute("value", no);
				form.appendChild(hiddenField);
				
				hiddenField = document.createElement("input");
				hiddenField.setAttribute("type", "hidden");
				hiddenField.setAttribute("name", "key");
				hiddenField.setAttribute("value", "${key}");
				form.appendChild(hiddenField);
				
				hiddenField = document.createElement("input");
				hiddenField.setAttribute("type", "hidden");
				hiddenField.setAttribute("name", "word");
				hiddenField.setAttribute("value", "${word}");
				form.appendChild(hiddenField);
				
				if(pg > 0){
					hiddenField = document.createElement("input");
					hiddenField.setAttribute("type", "hidden");
					hiddenField.setAttribute("name", "pg");
					hiddenField.setAttribute("value", pg);
					form.appendChild(hiddenField);					
				}
				
				document.body.appendChild(form);
				
				form.submit();
			}
			
			//========================================지도출력 하는 함수 부분 (시작)======================================
			var codeList=new Array(); //법정동코드  번호 저장 리스트
			
			let colorArr = ['table-primary','table-success','table-danger'];
			function loc(vo){

				$.get("${pageContext.request.contextPath}/map/loc"
						,{code:vo}
						,function(data, status){
							geocode(data);
						}//function
						, "json"
				);//get
			} 
			function geocode(jsonData) {
				let idx = 0;
				$.each(jsonData, function(index, vo) {
					let tmpLat;
					let tmpLng;
					$.get("https://maps.googleapis.com/maps/api/geocode/json"
							,{	key:'AIzaSyDWgG_7PhqagU3yAO2hOtBHORQgGhYurXo'
								, address:vo.dong+"+"+vo.aptName+"+"+vo.jibun
							}
							, function(data, status) {
								//alert(data.results[0].geometry.location.lat);
								tmpLat = data.results[0].geometry.location.lat;
								tmpLng = data.results[0].geometry.location.lng;
								$("#lat_"+index).text(tmpLat);
								$("#lng_"+index).text(tmpLng);
								addMarker(tmpLat, tmpLng, vo.aptName);
							}
							, "json"
					);//get
				});//each
			}
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
			/* 	var marker = new google.maps.Marker({
					position : multi,
					map : map
				}); */
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
			/* function callHouseDealInfo() {
				alert("you can call HouseDealInfo");
			} */

			//========================================지도출력 하는 함수 부분 (끝) ======================================
		</script>
		<c:if test="${ houseinfos.size() != 0 }">
			<c:forEach var="houseinfo" items="${ houseinfos }">
				<script>
		        	codeList.push('${ houseinfo.no }');	
				</script>
			</c:forEach>
		</c:if>
	</head>
	<body>
	<form name="pageform" id="pageform" method="GET" action="">
		<input type="hidden" name="pg" id="pg" value="">
		<input type="hidden" name="no" id="no" value="">
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
		<jsp:include page="/WEB-INF/views/menu.jsp" />
		
		<div class="row" id="app">
			<!-- 좌측 화면 -->
			<div class="left col-lg-3">
				<!-- 검색 필터 공간  -->
				<div align="left">
					<!-- 검색(key, word) -->
					<form id="searchform" method="get" action="">
						<div style="padding-left: 30px;">
							<a>아파트&nbsp:&nbsp</a>
							<input type="checkbox" name="types" value="1" ${ iscktype1 }>매매&nbsp
							<input type="checkbox" name="types" value="3" ${ iscktype3 }>전월세
							<br>
							<a>다세대&nbsp:&nbsp</a>
							<input type="checkbox" name="types" value="2" ${ iscktype2 }>매매&nbsp
							<input type="checkbox" name="types" value="4" ${ iscktype4 }>전월세
						</div>
						<div style="padding-left: 30px;">
							<select name="key">
								<option value="dong" ${ iskeydong }>법정동</option>
								<option value="aptname" ${ iskeyaptname }>이름</option>
							</select>
							<input type="text" placeholder="검색어 입력" name="word" value="${ word }">
							<button type="button" onclick="javascript:search();" onkeypress="if(event.keyCode == 13){search();}">검색</button>						
						</div>
					</form>	
					<!-- 페이지네이션 -->
					<div style="padding-left: 30px; padding-top: 10px">${ navigation.navigator }</div>			
				</div>
				<!-- 매물리스트 출력공간 -->
				<div style="padding-left: 30px;">
				
					<c:if test="${ housedeals.size() != 0 }">
						<c:forEach var="house" items="${ housedeals }">
							<hr>
							<a style="color:blue; font-size:20px; " href="javascript:detail(${ house.no }, ${ pg });">${ house.aptName }</a><br>
							<div style="line-height: 100%">
								<c:choose>
									<c:when test="${ house.type == 1 }">
										<a style="font-size: 13px;">(아파트 매매/${ house.dong })</a>
									</c:when>
									<c:when test="${ house.type == 2 }">
										<a style="font-size: 13px;">(아파트 전월세/${ house.dong })</a>
									</c:when>
									<c:when test="${ house.type == 3 }">
										<a style="font-size: 13px;">(다세대 매매/${ house.dong })</a>
									</c:when>
									<c:when test="${ house.type == 4 }">
										<a style="font-size: 13px;">(다세대 전월세/${ house.dong })</a>
									</c:when>
									<c:otherwise>
										<td>(기타</td>													
									</c:otherwise>
								</c:choose><br>
								<c:choose>
									<c:when test="${ house.type == 1 || house.type == 3 }">
										<a style="font-size: 13px;">거래금액: ${ house.dealAmount }</a>
									</c:when>
									<c:when test="${ house.type == 2 || house.type == 4 }">
										<a style="font-size: 13px;">보증금(월세): ${ house.dealAmount }(${ house.rentMoney })</a>
									</c:when>
								</c:choose><br>
								<a style="font-size: 13px;">면적: ${ house.area }</a><br>
								<a style="font-size: 13px;">거래날짜: ${house.dealYear}.${house.dealMonth}.${house.dealDay}</a>							
							</div>
						</c:forEach>
					</c:if>				
					<c:if test="${ housedeals.size() == 0 }">
						조건에 부합하는 매물이 없습니다.
					</c:if>
				</div>
			</div>
			<!-- 우측 화면 -->
			<div class="right col-lg-9">
				<!-- 상세보기 없을때 지도만 출력 -->
				<c:if test="${ housedeal == null }">
					<!-- 지도영역 -->
					<!-- ===================================================================================================================================== -->
					<!-- 법정동 코드를 가진 배열을 위에서 선언한 지도 좌표에 찍어주는 함수에 하나씩 입력해주는 부분 -->
					<script>
						for(var i in codeList){
							loc(codeList[i]);
						}
					</script>
					<!-- 지도 출력하는 부분 -->				  	
					<div id="map" style="width:80%; height: 700px;float: center; margin: auto;"></div>
					<script
						src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
					<script async defer
						src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWgG_7PhqagU3yAO2hOtBHORQgGhYurXo&callback=initMap"></script>
					<!-- ===================================================================================================================================== -->
				</c:if>
				<!-- 상세보기시 상세보기에 지도, 이미지 붙이기 -->
				<c:if test="${ housedeal != null }">
					<div id="detailData" align="center">
						<!-- 지도, 그림(왼쪽) -->
						<div style='float:left'>
							<!-- 그림 -->
							<div>
								<c:if test="${ houseinfo != null && houseinfo.img != null}">
									<img src="/resource/img/${ houseinfo.img }" width="526px" height="383">	
								</c:if>						
								<c:if test="${ houseinfo == null || houseinfo.img == null}">
									<img src="/resource/img/logo2.jpg">
								</c:if>						
							</div>
							<!-- 지도 -->
							<div>
								<c:if test="${ houseinfo != null }">
									<script>
										//addMarker('${ houseinfo.lat }','${ houseinfo.lng }','${ houseinfo.aptName }');
										console.log('${ houseinfo.aptName }');
										var plac = {
												lat : ${ houseinfo.lat },
												lng : ${ houseinfo.lng }
										};
										var map;
										function reinitMap() {
											map = new google.maps.Map(document.getElementById('map2'), {
													center : plac,
													zoom : 17
											});
											var marker = new google.maps.Marker({
													position : plac,
													map : map,
													label : '${ houseinfo.aptName }'
											});
										/* 	marker.addListener('click', function() {
												map.setZoom(17);
												map.setCenter(marker.getPosition());
												
											});
											marker.setMap(map); */
										}
									</script>								
								</c:if>
								<c:if test="${ houseinfo == null }">
									<script>
										alert("해당 매물에 대한 위치정보가 존재하지 않습니다.");
										var multi = {
											lat : 37.5665734,
											lng : 126.978179
										};
										var map;
										function reinitMap() {
											map = new google.maps.Map(document.getElementById('map2'), {
												center : multi,
												zoom : 12
											});
										/* 	var marker = new google.maps.Marker({
												position : multi,
												map : map
											}); */
										}
									</script>
								</c:if>
								<div id="map2" style="width:100%; height: 500px;float: center; margin: auto;"></div>
								<script
									src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
								<script async defer
									src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWgG_7PhqagU3yAO2hOtBHORQgGhYurXo&callback=reinitMap"></script>
								
							</div>
						</div>
						<!-- 상세보기 테이블(오른쪽) -->
						<table class="table table-striped table-bordered table-hover" style="width: 50%;">
							<tbody align="center">
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
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</body>
</html>