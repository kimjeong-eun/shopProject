<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<html>
<head>
<meta charset="UTF-8">
    <script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>

<style type="text/css">
* { padding: 0; margin: 0; }

html, body {
  height: 100%;
  background: #ffffff;
}

#container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  height: 60%;
}

#loginBox {
  width: 300px;
  text-align: center;
  background-color: #ffffff;
}
.input-form-box {
  border: 0px solid #ff0000;
  display: flex;
  margin-bottom: 5px;
}
.input-form-box > span {
  display: block;
  text-align: left;
  padding-top: 5px;
  min-width: 65px;
}
.button-login-box {
  margin: 10px 0;
}
#loginBoxTitle {
  color:#000000;
  font-weight: bold;
  font-size: 40px;
  text-transform: uppercase;
  padding: 5px;
  margin-bottom: 20px;
  background: linear-gradient(to right, #270a09, #8ca6ce);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
#inputBox {
  margin: 10px;
}

#inputBox button {
  padding: 3px 5px;
}

#findInfo a:hover{

	color: #2828CD;

}

</style>

 <title>로그인</title>

 <!-- Bootstrap CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
  <body class="text-center">
    <jsp:include page="./includes/header.jsp"></jsp:include>
    
    <!--  html 전체 영역을 지정하는 container -->
    <div id="container">
      <!--  login 폼 영역을 : loginBox -->
	
      <form id="loginBox" action="/login" method="post">
   
        <!-- 로그인 페이지 타이틀 -->
        <div id="loginBoxTitle">PonKu</div>
        <!-- 아이디, 비번, 버튼 박스 -->
        <div id="inputBox">
          <div class="input-form-box"><span>아이디 </span><input type="text" name="username" class="form-control"></div>
          <div class="input-form-box"><span>비밀번호 </span><input type="password" name="password" class="form-control"></div>
      	  <p style="color:red ">${errorMsg }</p> <!-- 로그인 정보 일치하지 않을 시 오류메세지  -->
          <input type="checkbox" name="remember-me" /><p style="display: inline ;">로그인 상태 유지</p>
			<div id="findInfo"><a href="/findId">ID찾기</a> | <a href="/findPw">Pw찾기</a>|<a href="/join">회원가입</a></div>
          <div class="button-login-box" >
            <button type="submit" class="btn btn-primary btn-xs" style="width:100%">로그인</button>        
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          </div>
        </div>
      </div>
    </form>
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

	<jsp:include page="./includes/footer.jsp"></jsp:include>
  </body>
  
  	<script>
  		
  		if(${not empty errorMsg }){
  			//로그인 실패라면 id입력 태그 포커스 
  			
  			$("input[name=username]").focus();
  			
  		}
	
  	</script>
  	 	
</html>