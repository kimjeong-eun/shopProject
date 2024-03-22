<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="UTF-8">
 <script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>

<style>
* { padding: 0; margin: 0; }

body {
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

#resultBox{
	
	width: 350px;
	height: 200px;
	border: 1px solid #DCEBFF;
	background-color: #F9FFFF;

}

</style>

 <title>아이디 찾기</title>

</head>
  <body class="text-center">
  
    <jsp:include page="./includes/header.jsp"></jsp:include>
    
    <!--  html 전체 영역을 지정하는 container -->
    <div id="container">
      <!--  login 폼 영역을 : loginBox -->
	
      <form id="loginBox" action="/validId" method="post" name="findForm" >
        
        <!-- 로그인 페이지 타이틀 -->
        <div id="loginBoxTitle">아이디 찾기</div>
        <p style="font-size: 12px;">회원 정보 확인을 위한 이름과 e-mail을 입력해주세요.</p>
      
        <!-- 아이디, 비번, 버튼 박스 -->
        <div id="inputBox">
          
          <div class="input-form-box"><span>이름 </span><input type="text" name="Inputname" class="form-control" placeholder="이름을 입력하세요" required="required" autofocus="autofocus" ></div>
          <div class="input-form-box"><span>이메일 </span><input type="email" name="Inputemail" class="form-control" placeholder="이메일을 입력하세요" required="required" style="margin-bottom: 10px;"></div>
          
          <div class="button-login-box" >
            <button name="findBtn" type="submit" class="btn btn-primary btn-xs" style="width:100% ; margin-bottom: 15px;" >회원 정보 찾기</button>
            
			<div id="findInfo"><a href="/findPw">Pw찾기</a> | <a href="/join">회원가입</a> | <a href="/customLogin">로그인</a></div>    
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          </div>
        </div>
        </form>
        
        <!-- 아이디 찾은 결과  -->
        <div id="resultBox" hidden="hidden">
        	
        	 <div id="loginBoxTitle" style="font-size: 20px;">회원 정보</div>
        	<div id="resultarea">

        
        	</div>
        </div>
  
      </div> <!-- end 컨테이너  -->
      

 
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	  
  	<script>
  		
  		$(document).ready(function(){

  			var csrfHeaderName = "${_csrf.headerName}";  //"X-CSRF-TOKEN"
			var csrfTokenValue = "${_csrf.token}";

  			$("button[name='findBtn']").on("click",function(e){
  				e.preventDefault();
  				
  				var email =$("input[name='Inputemail']").val();
  				var name = $("input[name='Inputname']").val();
  				
  				//정규식 사용하여 이메일 이름 입력값 확인
  				var emailregexp = new RegExp("^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$");
  				var nameregexp = new RegExp("^[가-힣]{2,4}");
  				
  				
  				if(!nameregexp.test(name)){
  					alert("이름 입력 형식이 잘못되었습니다!*한글만 가능*");
  					$("input[name='Inputname']").focus();
  					return;
  					
  				}
  				
  				if(!emailregexp.test(email)){
  					alert("이메일 입력 형식이 잘못되었습니다!!");
  					$("input[name='Inputemail']").focus();
  					return;
  				}
  				$.ajax({
  					url :'/validEmailName',
  					data : {useremail: email,username:name},
  					type:'POST',
  					dataType : 'json',
  					beforeSend: function(xhr){   // 헤더에 csrf 값 추가
						xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
					},
  					success: function(result){
  						//alert("찾았읍니다");'
  						console.log(result);
  						
  						showResult(result);
  					},
  					error : function(e){
  						alert("일치하는 정보가 없습니다!!");
  					    console.log(e);
  					  }
  				});	
  				
  			});

  	  		function showResult(findResult){
					
  	  				$("#resultBox").removeAttr("hidden");
  	  				
  	  				var resultarea = $("#resultarea");
  	  				
  	  				var userid = findResult.userid;
  	  			
  	  				var username = findResult.username;
  	  				
  	  				var enroll_date = new Date(findResult.enroll_date);
  	  				
  	  				var enroll_date_str =  enroll_date.getFullYear() +
  	  			'-' + ( (enroll_date.getMonth()+1) < 9 ? "0" + (enroll_date.getMonth()+1) : (enroll_date.getMonth()+1) )+
  	  		'-' + ( (enroll_date.getDate()) < 9 ? "0" + (enroll_date.getDate()) : (enroll_date.getDate()) );
  	  				
  	  			var maskingUserId = maskingId(userid); //id 마스킹 처리
  	  			
	  				/*alert(findResult.userid);
	  				alert(findResult.username);
	  				alert(enroll_date_str); */
	  				
	  				var str = "<p>ID : "+maskingUserId+"</p><p> 회원가입일 : "+enroll_date_str+"</p>";
	  				
	  				resultarea.html(str);
	  				
	  		};
	  		
	  		//아이디 마스킹처리
			function maskingId(str) {
			    if (str == undefined || str === "") {
			        return "";
			    }
			    var pattern = /.{3}$/; // 정규식
			    return str.replace(pattern, "***");
			};
				  		
  			

  		});

  	</script>
	
	<jsp:include page="./includes/footer.jsp"></jsp:include>
	
  </body>

 </html>
  	 	