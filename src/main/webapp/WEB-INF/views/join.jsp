<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 


<jsp:include page="./includes/header.jsp"></jsp:include>


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
  <script defer src="../resources/js/join.js"></script>
</head>
 
<body>

  <div class="container">
	<div class="content">
    	<form id="joinForm" name="joinForm" action="/join" method="post">
	      <!-- HEADER -->
	      <header>
	        <h2>회원가입</h2>
	        <h3>가입을 통해 더 다양한 서비스를 만나보세요!</h3>
	      </header>
		 
	      <!-- INPUT -->
	      <section>
	     	<div class="info" id="info__name">
	          <input class="box" name="username" type="text" placeholder="이름"/>
	          <div class="error-msg"></div>
	        </div>
	        <div class="info" id="info__id">
			    <div id="id-input">
			        <input class="box" name="userid" id="userid" type="text" placeholder="아이디 입력(6~20자)"/>
			    </div>
			    <div class="error-msg" id="id-error-msg"></div>
			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>
			
	        <div class="info" id="info__pw">
	          <input class="box" name="password" type="password" placeholder="비밀번호 입력 (문자, 숫자, 특수문자 포함 8~20자)"/>
	          <div class="error-msg"></div>
	        </div>
	        <div class="info" id="info__pwRe">
	          <input class="box" name="repw" type="password" placeholder="비밀번호 재입력"/>
	          <div class="error-msg"></div>
	        </div>
	        <div class="info" id="info__email">
	          <input class="box" id="email-txt" name="inputEmail" type="text" placeholder="이메일 입력"/>
	          <span>@</span>
	          <input class="box" id="domain-txt" name="inputDomain" type="text"/>
	          <select class="box" id="domain-list">
	            <option value="type">직접 입력</option>
	            <option value="naver.com">naver.com</option>
	            <option value="google.com">google.com</option>
	            <option value="gmail.com">gmail.com</option>
	            <option value="hanmail.net">hanmail.net</option>
	            <option value="nate.com">nate.com</option>
	            <option value="kakao.com">kakao.com</option>
	          </select>
	          <input type="hidden" name="email" id="email" value="" />
	        </div>
	        <div class="info" id="info__birth">
	          <div id="birth-flex">
	            <select class="box" id="birth-year" name="birthY">
	              <option disabled selected>출생 연도</option>
	            </select>
	            <select class="box" id="birth-month" name="birthM">
	              <option disabled selected>월</option>
	            </select>
	            <select class="box" id="birth-day" name="birthD">
	              <option disabled selected>일</option>
	            </select>
	            <input type="hidden" name="birth" id="birth" value="" />
	          </div>
	          <div class="error-msg"></div>
	        </div>
	        <!-- <div id="print-date"></div> -->
	        <div class="info" id="info__mobile">
	          <input class="box" name="phone" type="text" placeholder="휴대폰 번호 입력 (‘-’ 제외 11자리 입력)"/>
	          <div class="error-msg"></div>
	        </div>
	      </section>
	      <div id="result-fail"></div>
	      <button name="btn-join" id="submitBtn" type="button">가입하기</button>
	      
	      <div class="exist">
	        <span>이미 회원이신가요?</span>
	        <a href="/customLogin">로그인 하러가기</a>
	      </div>
    	</form>
	 </div>
  </div>

<script>

$(document).ready(function() {
	
	let csrfHeaderName = "${_csrf.headerName}"; //"X-CSRF-TOKEN"
	let csrfTokenValue = "${_csrf.token}";
	let alertCheckId = false; // 기본값 false 부여
	
 /*** ID 중복검사 - 입력란에서 포커스가 벗어날 때 동작한다. ***/
    $("input[name='userid']").blur(function() {
        var userid = $(this).val();
        console.log('userId :',userid); 

        if (userid == '' || userid.length == 0) {
            $("#id-error-msg").css("color", "red").text("공백은 ID로 사용할 수 없습니다.");
            return false;
        }

        // Ajax로 전송
        $.ajax({
            url: '/checkId', // 실제로 서버에서 ID 중복 확인을 처리하는 스크립트의 경로
            type: 'POST',
            data: {userId:userid},
            dataType: 'text',
			beforeSend: function(xhr){   // 헤더에 csrf 값 추가
				xhr.setRequestHeader(csrfHeaderName,csrfTokenValue);
			},
            success: function(result) {
                if (result == "true") {
                	alertCheckId = false; //실패 시 false
                    $("#id-error-msg").css("color", "red").text("사용 불가능한 ID 입니다.");
                } else {
                	alertCheckId = true; //성공 시 true
                    $("#id-error-msg").css("color", "black").text("사용 가능한 ID 입니다.");
                }
            },
            error: function(xhr, status, error) {
                // 서버 요청 실패 시 실행할 코드
                alertCheckId = false; //실패 시 false
                console.error('AJAX request failed:', error);
            }
        }); // End Ajax
    });


/*** 회원가입 병합 ***/
	//email
	$("#email-txt").blur(function() {
		email();
	});
	
	$("#domain-list").blur(function(){
		email();
	});
	
	function email() {
		const inputEmail = $("#email-txt").val();
		const inputDomain = $("#domain-list").val();
		
		if(inputEmail != "" && inputDomain != "") {
			$("#email").val(inputEmail + "@" + inputDomain);
		}	
	};
	
	//birth
	$("#birth-year").blur(function() {
		birth();
	});
	
	$("#birth-month").blur(function(){
		birth();
	});

	$("#birth-day").blur(function(){
		birth();
	});
	
	function birth() {
		const birthY = $("#birth-year").val();
		const birthM = $("#birth-month").val();
		const birthD = $("#birth-day").val();
		
		if(birthY != "출생년도" && birthM != "월" && birthD != "일") {
			$("#birth").val(birthY + birthM + birthD);
		}	
	};

	/*** SECTION - 이름 ***/
	const nameInputEl = document.querySelector('#info__name input');
	const nameErrorMsgEl = document.querySelector('#info__name .error-msg');
	
	nameInputEl.addEventListener('change', () => {
	    const nameRegExp = /^[a-zA-Z가-힣\s]{2,}$/;
	    if (nameRegExp.test(nameInputEl.value)) { //정규식 조건 만족
	        nameErrorMsgEl.textContent = "";
	    } else {
	        nameErrorMsgEl.style.color = "red";
	        nameErrorMsgEl.textContent = "올바른 이름을 입력해주세요.";
	    }
	    console.log(account);
	});
	
	/*** SECTION - ID ***/
	const idInputEl = document.querySelector('#info__id input');
	const idErrorMsgEl = document.querySelector('#info__id .error-msg');
	const idCheckBtn = document.querySelector('#id-check');
	
	idInputEl.addEventListener('change', () => {
	  const idRegExp = /^[a-zA-Z0-9]{6,20}$/;
	  if(idRegExp.test(idInputEl.value)) { // 정규식 조건 만족
	    idErrorMsgEl.textContent = "";
	    account.id = idInputEl.value;
	  } else { // 정규식 조건 만족 X
	    idErrorMsgEl.style.color = "red";
	    idErrorMsgEl.textContent = errMsg.id.invalid;
	    account.id = null;
	  }
	  console.log(account);
	});
	
	/*** SECTION - PASSWORD ***/
	//pwVal: 패스워드, pwReVal: 패스워드 재입력, isPwValid: 패스워드 유효 여부
	let pwVal = "", pwReVal = "", isPwValid = false
	//비밀번호와 재입력 값 일치 여부
	function checkPwValid() {
	account.pw = null
	if(pwReVal === "") { // 미입력
	 pwReErrorMsgEl.textContent = ""
	}
	else if(pwVal === pwReVal) { // 비밀번호 재입력 일치
	 if(isPwValid)
	   account.pw = pwVal
	 pwReErrorMsgEl.style.color = "green"
	 pwReErrorMsgEl.textContent = errMsg.pwRe.success
	}
	else { // 비밀번호 재입력 불일치
	 pwReErrorMsgEl.style.color = "red"
	 pwReErrorMsgEl.textContent = errMsg.pwRe.fail
	}
	}
	
	const pwInputEl = document.querySelector('#info__pw input')
	const pwErrorMsgEl = document.querySelector('#info__pw .error-msg')
	pwInputEl.addEventListener('change', () => {
	const pwRegExp = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/
	pwVal = pwInputEl.value
	if(pwRegExp.test(pwVal)) { // 유효성 검사 성공
	 isPwValid = true
	 pwErrorMsgEl.textContent = ""
	} 
	else { // 유효성 검사 실패
	 isPwValid = false
	 pwErrorMsgEl.textContent = errMsg.pw
	}
	checkPwValid()
	console.log(pwVal, pwReVal, isPwValid, account)
	});
	
	/*** SECTION - PASSWORD RECHECK ***/
	const pwReInputEl = document.querySelector('#info__pwRe input')
	const pwReErrorMsgEl = document.querySelector('#info__pwRe .error-msg')
	pwReInputEl.addEventListener('change', () => {
		pwReVal = pwReInputEl.value
		checkPwValid()
		console.log(pwVal, pwReVal, isPwValid, account);
	});
	
	/*** SECTION - BIRTH ***/
	const birthArr = [-1, -1, -1]
	/* 유효한 날짜인지 여부 확인 (윤년/평년) */
	function checkBirthValid(birthArr) {
	  isBirthValid = true
	  y = birthArr[0]
	  m = birthArr[1]
	  d = birthArr[2]
	  // 생년월일 모두 선택 완료 시
	  if(y > 0 && m > 0 && d > 0) {
	    if ((m == 4 || m == 6 || m == 9 || m == 11) && d == 31) { 
	      isBirthValid = false
	    }
	    else if (m == 2) {
	      if(((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) { // 윤년
	        if(d > 29) { // 윤년은 29일까지
	          isBirthValid = false
	        }
	      } else { // 평년
	        if(d > 28) { // 평년은 28일까지
	          isBirthValid = false
	        }
	      }
	    }
	
	    if(isBirthValid) { // 유효한 날짜
	      birthErrorMsgEl.textContent = ""
	      account.birth = birthArr.join('')
	    } else { // 유효하지 않은 날짜
	      birthErrorMsgEl.textContent = "생년월일을 다시 확인해주세요"
	      account.birth = null
	    }
	  }
	}
	
	const birthErrorMsgEl = document.querySelector('#info__birth .error-msg')
	// '출생 연도' 셀렉트 박스 option 목록 동적 생성
	const birthYearEl = document.querySelector('#birth-year')
	// option 목록 생성 여부 확인
	isYearOptionExisted = false;
	birthYearEl.addEventListener('focus', function () {
	  // year 목록 생성되지 않았을 때 (최초 클릭 시)
	  if(!isYearOptionExisted) {
	    isYearOptionExisted = true
	    for(var i = 1940; i <= 2022; i++) {
	      // option element 생성
	      const yearOption = document.createElement('option')
	      yearOption.setAttribute('value', i)
	      yearOption.innerText = i
	      // birthYearEl의 자식 요소로 추가
	      this.appendChild(yearOption);
	    }
	  }
	});
	
	birthYearEl.addEventListener('change', () => {
	  birthArr[0] = birthYearEl.value
	  birthYearEl.style.color = "#383838"
	  checkBirthValid(birthArr)
	  console.log(account, birthArr)
	});
	
	// 월 select box
	const birthMonthEl = document.querySelector('#birth-month')
	isMonthOptionExisted = false;
	birthMonthEl.addEventListener('focus', function () {
	  if(!isMonthOptionExisted) {
	    isMonthOptionExisted = true
	    for(var i = 1; i <= 12; i++) {
	      const monthOption = document.createElement('option')
	      if(i < 10)
	        monthOption.setAttribute('value', '0' + i)
	      else 
	        monthOption.setAttribute('value', i)
	      
	      monthOption.innerText = i
	      this.appendChild(monthOption);
	    }
	  }
	});
	
	birthMonthEl.addEventListener('change', () => {
	  birthArr[1] = birthMonthEl.value
	  birthMonthEl.style.color = "#383838"
	  checkBirthValid(birthArr)
	  console.log(account, birthArr)
	});
	
	// 일 select box
	const birthDayEl = document.querySelector('#birth-day')
	isDayOptionExisted = false;
	birthDayEl.addEventListener('focus', function () {
	  if(!isDayOptionExisted) {
	    isDayOptionExisted = true
	    for(var i = 1; i <= 31; i++) {
	      const dayOption = document.createElement('option')
	      if(i < 10)
	        dayOption.setAttribute('value', '0' + i)
	      else
	        dayOption.setAttribute('value', i)
	      dayOption.innerText = i
	      this.appendChild(dayOption);
	    }
	  }
	});
	
	birthDayEl.addEventListener('change', () => {
	  birthArr[2] = birthDayEl.value
	  birthDayEl.style.color = "#383838"
	  checkBirthValid(birthArr)
	  console.log(account, birthArr)
	});
	
	/*** 전송 버튼 클릭 시 alert창 띄우기 ***/
	$("#submitBtn").on("click", function(e){
		//이름 유효성 검사
		const nameRegExp = /^[a-zA-Z가-힣\s]{2,}$/; // Allow alphabets, spaces, and Korean characters
	    const nameInput = $("#info__name input").val().trim();
	    if (!nameRegExp.test(nameInput)) {
	        alert("올바른 이름을 입력해주세요.");
	        return false;
	    }
	    
		//id 유효성 검사	
		const idRegExp = /^[a-zA-Z0-9]{6,20}$/;
		if(!idRegExp.test(idInputEl.value)) {
			alert("아이디는 영문자 또는 숫자로 6자 이상 20자 이하여야 합니다.");
			return false;
		}
		
		// 비밀번호 유효성 검사
	    const pwRegExp = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
	    if (!pwRegExp.test(pwVal)) {
	        alert("비밀번호는 영문, 숫자, 특수문자를 포함하여 8자 이상 20자 이하여야 합니다.");
	        return;
	    }
		
	 	// 비밀번호 재입력 일치 여부 확인
	    if (pwVal !== pwReVal) {
	        alert("비밀번호가 일치하지 않습니다.");
	        return;
	    }
	    
	    var form = $("form[name='joinForm']"); // ID를 사용하여 폼 요소를 선택
		form.submit();
	    
	});
});

</script>
	

<jsp:include page="./includes/footer.jsp"></jsp:include>
