// 에러 메세지 객체
const errMsg = {
  id: { 
    invalid: "6~20자의 영문 소문자와 숫자만 사용 가능합니다",
    success: "사용 가능한 아이디입니다",
    fail: "사용할 수 없는 아이디입니다"
  },
  pw: "8~20자의 영문, 숫자, 특수문자를 모두 포함한 비밀번호를 입력해주세요",
  pwRe: {
    success: "비밀번호가 일치합니다",
    fail: "비밀번호가 일치하지 않습니다"
  },
  birth: "생년월일을 다시 확인해주세요",
  mobile: "‘-’ 제외 11자리를 입력해주세요" 
}

// 계정 정보 객체
const account = {
  id: null,
  pw: null,
  email: null,
  birth: null,
  mobile: null
}

/*** SECTION - EMAIL ***/
emailList = ["", ""]
function checkEmailValid() {
  if(emailList[0] !== "" && emailList[1] !== "") {
    account.email = emailList.join('@')
  }
  else
  account.email = null
}

const emailInputEl = document.querySelector('#email-txt')
emailInputEl.addEventListener('change', () => {
  emailList[0] = emailInputEl.value
  checkEmailValid()
  console.log(account, emailList)
})

const domainInputEl = document.querySelector('#domain-txt')
domainInputEl.addEventListener('change', () => {
  emailList[1] = domainInputEl.value
  checkEmailValid()
  console.log(account, emailList)
})

// 도메인 직접 입력 or domain option 선택
const domainListEl = document.querySelector('#domain-list')
domainListEl.addEventListener('change', () => {
  // option에 있는 도메인 선택 시
  const domainSelected = domainListEl.value
  if(domainSelected !== "type") {
    // 선택한 도메인을 input에 입력하고 disabled
    domainInputEl.value = domainSelected
    domainInputEl.disabled = true
    emailList[1] = domainSelected
  } else { // 직접 입력
    // input 내용 초기화 & 입력 가능하도록 변경
    domainInputEl.value = ""
    domainInputEl.disabled = false
    emailList[1] = ""
  }
  checkEmailValid()
  console.log(account, emailList)
})



/*** SECTION - MOBILE ***/
const mobileInputEl = document.querySelector('#info__mobile input')
const mobileErrorMsgEl = document.querySelector('#info__mobile .error-msg')
mobileInputEl.addEventListener('change', () => {
  const mobileRegExp = /^010([0-9]{8})$/
  if(mobileRegExp.test(mobileInputEl.value)) { // 유효성 검사 성공
    account.mobile = mobileInputEl.value
    mobileErrorMsgEl.textContent = ""
  } else { // 유효성 검사 실패
    account.mobile = null
    mobileErrorMsgEl.textContent = errMsg.mobile
  }
  console.log(account)
});



