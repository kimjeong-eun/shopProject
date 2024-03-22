const account = {
  id: null,
  pw: null
}

/*** SECTION - ID ***/
const idInputEl = document.querySelector('.box#signin-id')
const pwInputEl = document.querySelector('.box#signin-pw')
const signInBtn = document.querySelector('#signin')

idInputEl.addEventListener('change', () => {
  account.id = idInputEl.value
  console.log(Object.values(account))
});

pwInputEl.addEventListener('change', () => {
  account.pw = pwInputEl.value
  console.log(Object.values(account))
});

signInBtn.addEventListener('click', () => {
  const randNum = Math.floor(Math.random() * 10)
  console.log(randNum)
  if(account.id === "" || account.id === null) {
    alert("아이디를 입력해주세요")
  }
  else if (account.pw === "" || account.pw === null) {
    alert("비밀번호를 입력해주세요")
  }
  else {
    if(randNum < 4) {
      alert("존재하지 않는 아이디입니다.")
    }
    else if (randNum < 7) {
      alert("비밀번호를 확인해주세요.")
    }
    else {
      location.href = "/result/index.html"
    }
  }
});
