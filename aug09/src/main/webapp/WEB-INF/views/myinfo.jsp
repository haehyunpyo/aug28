<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>❤ 사용자 정보</title>
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<script src="./js/jquery-3.7.0.min.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {

	});
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<!-- Masthead-->
	<header class="masthead">
		<div class="container">
		<h1>사용자 정보 보기</h1>
			<div>번호 : ${my.m_no }</div>
			<div>아이디 : ${my.m_id }</div>
			<div>이름 : ${my.m_name }</div>
			<div>가입일 : ${my.m_joindate }</div>
			<div>MBTI : ${my.m_mbti }</div>
			<div>성별 : ${my.m_gender }</div>
			<div>등급 : ${my.m_grade }</div>
		</div>
	</header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/scripts.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>