<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign in</title>
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
  <link rel="stylesheet" href="../css/join_signin.css">
  <script defer src="../js/join_signin.js"></script>
</head>
<body>
  <div class="container">
    <div class="content">
      <!-- HEADER -->
      <header>
        <h2>ponku</h2>
      </header>

      <!-- INPUT -->
      <section>
        <input class="box" id="signin-id" type="text" placeholder="아이디 입력(6~20자)"/>
        <input class="box" id="signin-pw" type="password" placeholder="비밀번호 입력 (문자, 숫자, 특수문자 포함 8~20자)"/>
      </section>
      <button id="signin">로그인</button>
      <div id="link-menu">
        <a href="javascript:void(0)">아이디 찾기 </a>
        <a href="javascript:void(0)">비밀번호 찾기 </a>
        <a href="/">회원가입 </a>
      </div>
      </div>
    </div>
  </div>
</body>
</html>