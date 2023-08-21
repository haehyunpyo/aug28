<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin || main</title>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="../css/admin.css">

</head>
<body>
	<div class="container">
		<%@ include file="menu.jsp" %>
		<div class="main">
		 	<div class="article">
				<h1>메인영역</h1>
				<div class="box" style="background-color: Tomato" onclick="url('multiBoard')">
					게시판 관리
					<div id="comment">게시판를 관리합니다</div>
				</div>
				
				<div class="box" style="background-color: Plum" onclick="url('post')">
					게시글 관리
					<div id="comment">게시글을 관리합니다</div>
				</div>
				
				
				<div class="box" style="background-color: PeachPuff" onclick="url('member')">
					회원 관리
					<div id="comment">회원을 관리합니다</div>
				</div>
				
				<div class="box" style="background-color: MediumSlateBlue" onclick="url('comment')">
					댓글 관리
					<div id="comment">댓글을 관리합니다</div>
				</div>
				
				<div class="box" style="background-color: Silver" onclick="url('message')">
					메시지 관리
					<div id="comment">메시지를 관리합니다</div>
				</div>
				
				<div class="box" style="background-color: PaleGreen" onclick="url('mail')">
					메일 관리
					<div id="comment">메일을 관리합니다</div>
				</div>
				
				<div class="box" style="background-color: LightSkyBlue" onclick="url('notice')">
					공지사항
					<div id="comment">공지를 쓰고 관리합니다</div>
				</div>
				
			</div>
		</div>
	</div>

</body>
</html>