<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<html>
<head>
	<meta charset="UTF-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<title>Sign Up</title>
 	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="../resources/css/join.css">
<title>Insert title here</title>

<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
</head>
<body>

  <div class="container">
	<div class="content">
	      <!-- HEADER -->
	      <header>
	        <h2>마이페이지</h2>
	        <h3>"${username}"님 환영합니다.</h3>
	      </header>
		 
	      <!-- INPUT -->
	      <section>
	     	<div class="info" id="info__name">
	          <input class="box" name="username" type="text" value="${username}" readonly/>
	        </div>
	        <div class="info" id="info__id">
			  <input class="box" name="userid" id="userid" type="text" value="${userid}" readonly/>
			</div>
			<div class="info" id="hidden">    
			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>
	        <div class="info" id="info__pw">
	          <input class="box" name="password" type="password" value="${password}" readonly/>
	        <div class="info" id="info__email">
	        <div class="info" id="info__email">
	          <input class="box" id="email-txt" name="inputEmail" type="text" value="${email}" readonly/>
	        </div>
	        <div class="info" id="info__birth">
	          <input class="box" id="birth" name="birth" type="text" value="${birth}" readonly/>
	        </div>
	        <div class="info" id="info__mobile">
	          <input class="box" name="phone" type="text" value="${phone}" readonly/>
	        </div>
	      </section>
	      <div id="result-fail"></div>
	      <button name="btn-join" id="submitBtn" type="button">수정하기</button>
	      <button name="btn-join" id="submitBtn" type="button">비밀번호 변경</button>
	      
	      <div class="exist">
	        <span>회원을 탈퇴하시겠습니까?</span>
	        <a href="/">회원탈퇴</a>
	      </div>
	      <div class="exist">
	        <span>홈으로 이동하시겠습니까?</span>
	        <a href="/">PONKU</a>
	      </div>
	 </div>
  </div>


</body>
</html>