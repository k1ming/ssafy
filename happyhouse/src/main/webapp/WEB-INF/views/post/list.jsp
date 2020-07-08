<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${ pageContext.request.contextPath }"/>
<c:choose>
	<c:when test="${ type == '1' }">
		<c:set var="hdt" value="공지사항"/>
	</c:when>
	<c:when test="${ type == '2' }">
		<c:set var="hdt" value="오늘의 뉴스"/>
	</c:when>
	<c:otherwise>
		<c:set var="hdt" value="자유게시판"/>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${ order == 'asc' }">
		<c:set var="isorderasc" value=" checked"/>
	</c:when>
	<c:otherwise>
		<c:set var="isorderdesc" value=" checked"/>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${ key == 'contents' }">
		<c:set var="iskeycontents" value=" selected"/>
	</c:when>
	<c:when test="${ key == 'userId' }">
		<c:set var="iskeyuserId" value=" selected"/>
	</c:when>
	<c:when test="${ key == 'yyyy' }">
		<c:set var="iskeyyyyy" value=" selected"/>
	</c:when>
	<c:when test="${ key == 'yyyymm' }">
		<c:set var="iskeyyyyymm" value=" selected"/>
	</c:when>
	<c:when test="${ key == 'yyyymmdd' }">
		<c:set var="iskeyyyyymmdd" value=" selected"/>
	</c:when>
	<c:when test="${ key == 'source' }">
		<c:set var="iskeysource" value=" selected"/>
	</c:when>
	<c:otherwise>
		<c:set var="iskeytitle" value=" selected"/>
	</c:otherwise>
</c:choose>


<c:if test="${ type == '3' && userinfo == null}">
		<script>alert("접근할 자격이 없습니다.")</script>
</c:if>
<c:if test="${ type != '3' || (type == '3' && userinfo != null) }">
	<!DOCTYPE html>
	<html>
		<head>
			<title>Happy House : 글 목록</title>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
 			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  			<script type="text/javascript">
			function search() {
				if(searchform.word.value == "") {
					alert("모든 목록 조회");
				} 
				searchform.action = "${ root }/post.do";
				searchform.submit();	
			}
			
			function pageMove(pg) { 
				document.getElementById("pg").value=pg;
				document.getElementById("pageform").action = "${root}/post.do";
				document.getElementById("pageform").submit();
			}
			</script>
			<style>
		    #container {
		      width: 70%;
		      margin: 0 auto;     /* 가로로 중앙에 배치 */
		      padding-top: 10%;   /* 테두리와 내용 사이의 패딩 여백 */
		    }
		     
		    #list {
		      text-align: center;
		    }
		   
		    #write {
		      text-align: right;
		    }
		     
		    /* Bootstrap 수정 */
		    .table > thead {
		      background-color: #95dff0;
		    }
		    .table > thead > tr > th {
		      text-align: center;
		    }
		    .table-hover > tbody > tr:hover {
		      background-color: #a8e2ed;
		    }
		    .table > tbody > tr > td {
		      text-align: center;
		    }
		    .table > tbody > tr > #title {
		      text-align: left;
		    }
		     
		    div > #paging {
		      text-align: center;
		    }
		    
		  </style>

		</head>
		<body>
		<form name="pageform" id="pageform" method="GET" action="">
			<input type="hidden" name="act" id="act" value="select">
			<input type="hidden" name="pg" id="pg" value="">
			<input type="hidden" name="type" id="type" value="${ type }">
			<input type="hidden" name="order" id="order" value="${ order }">
			<input type="hidden" name="key" id="key" value="${ key }">
			<input type="hidden" name="word" id="word" value="${ word }">
		</form>

			<!-- 로그인정보 출력 공간 -->
			<jsp:include page="/WEB-INF/views/menu.jsp" />
			<div class="container" align="center">
				<div align="center">
					<div align="right">
						<td><h5 align="right">${ hdt }</h5><td>
					</div>
					<div align="left" style="margin-bottom:80px;">
						<!-- 검색 필터 공간  -->
						<table align="right">
							<tr>
								<form id="searchform" method="get" class="form-inline" action="">
							  	<input type="hidden" name="act" id="act" value="select">
							  	<input type="hidden" name="type" id="type" value="${ type }">
							  		<td><input type="radio" name="order" value="asc"  ${ isorderasc }>오름차순
							  			<input type="radio" style="margin-left:5px; name="order" value="desc" ${ isorderdesc }>내림차순</td>
									<td align="right">
										<select name="key" style="margin-left:10px; position: relative;
														    width: 150px;  /* 너비설정 */
														    height: 30px;">
										
											<option value="title" ${ iskeytitle }>제목</option>
											<option value="contents" ${ iskeycontents }>내용</option>
											<option value="userId" ${ iskeyuserId }>작성자(아이디)</option>
											<option value="yyyy" ${ iskeyyyyy }>날짜(년도)</option>
											<option value="yyyymm" ${ iskeyyyyymm }>날짜(년도월)</option>
											<option value="yyyymmdd" ${ iskeyyyyymmdd }>날짜(년도월일)</option>
											<c:if test="${ type == '2' }">
												<option value="source" ${ iskeysource }>출처</option>										
											</c:if>
										</select>
										<input type="text" placeholder="검색어 입력" name="word" value="${ word }">
										<button type="button" style="margin-left:10px;" class="btn btn-outline-info" onclick="javascript:search();">검색</button>
									</td>
								</form>
								<!-- 글쓰기 등 메뉴 이동 공간 -->
								<c:if test="${ (type != '3' && userinfo.type == '1') || (type == '3' && userinfo != null)}">
										<td><button type="button" style="margin-left:10px; margin-right:180px;" class="btn btn-outline-info" onclick="location.href = '${ root }/post.do?act=mvInsert&type=${ type }' ">글쓰기</button></td>
								</c:if>
							</tr>
						</table>
					</div>
					
					<div align="center">
						<table class="table table-striped table-bordered table-hover">
							<thead align="center">
								<tr>
									<td width="5%" >번호</td>
									<td width="15%" >제목</td>
									<td width="20%">내용</td>
									<c:if test="${ type == '2' }">
										<td width="10%">출처</td>										
									</c:if>
									<td width="10%">작성자</td>
									<td width="16%">작성 날짜</td>
									<td width="8%">조회수</td>
								</tr>
							</thead>
							<tbody align="center">
								<c:if test="${ joinpostsmembers.size() != 0 }">
									<c:forEach var="jpm" items="${ joinpostsmembers }">
										<tr>
											<!-- 출력공간1(작성된 글들 출력) -->
											<td>${ jpm.posts.no }</td>
											<td><a style="color:#2e8cff;" href="${ root }/post.do?act=detail&no=${ jpm.posts.no }&type=${ jpm.posts.type }">${ jpm.posts.title }</a></td>
											<td>${ jpm.posts.contents }</td>
											<c:if test="${ type == '2' }">
												<td>${ jpm.posts.source }</td>										
											</c:if>
											<td>${ jpm.members.userId }</td>
											<td>${ jpm.posts.makeDate }</td>
											<td>${ jpm.posts.views }</td>
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
								<c:if test="${ joinpostsmembers.size() == 0 }">
									<tr>
										<!--  출력공간2(작성된 글이 없읍니다.) -->
										<c:if test="${ type != '2' }">
												<td colspan="6">작성된 글이 없습니다.<td>										
										</c:if>
										<c:if test="${ type == '2' }">
												<td colspan="7">작성된 글이 없습니다.<td>										
										</c:if>
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>	
				</div>
			</div>
		</body>
	</html>
</c:if>