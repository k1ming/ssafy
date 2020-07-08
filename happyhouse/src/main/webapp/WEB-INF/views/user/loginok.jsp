<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.json.simple.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	var userinfo = '${userinfo}';
	var no = '${userinfo.no}';
	var type = '${userinfo.type}';
	
	if(userinfo != null){
		localStorage.clear();
		localStorage.setItem('userinfo', JSON.stringify({'no':no,'type':type}));
		var tmp = localStorage.getItem('userinfo');
	}
	window.location.href = '/';
</script>

</head>
<body>

</body>
</html>