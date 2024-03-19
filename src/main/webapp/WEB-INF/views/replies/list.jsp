<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>댓글 창</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <style>
    /* 댓글 창 스타일 */
    #comment-container {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    }
    
    #comment {
      width: 710px; /* 너비 설정 */
      height: 115px; /* 높이 설정 */
    }
  </style>
</head>
<body>
<div class="container">
  <div id="comment-container">
    <form>
      <div class="form-group">
        <label for="comment">리뷰 :</label>
        <textarea class="form-control" rows="5" id="comment"></textarea>
      </div>
      <button type="button" class="btn btn-primary" onclick="submitComment()">댓글 입력</button>
    </form>
  </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function submitComment() {
	
  var csrfHeaderName = "${_csrf.headerName}";  //"X-CSRF-TOKEN"
  var csrfTokenValue = "${_csrf.token}";
	
  var commentContent = document.getElementById("comment").value;
  
	//Ajax를 사용하여 서버로 댓글 내용을 전송합니다.
  	$.ajax({
    type: "POST",
    beforeSend: function(xhr){   // 헤더에 csrf 값 추가
        xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
     },
    url: "/replies/saveComment", // 서버에서 댓글을 저장하는 JSP 파일 경로
    data: { content: commentContent },
    success: function(response) {
      // 서버에서 응답을 받으면 콘솔에 출력합니다.
      console.log(response);
    }
  });
}
</script>

</body>
</html>
