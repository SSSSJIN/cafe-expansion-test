<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>로그인 | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
  <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  <script>
    Kakao.init('e8da3210f814e01f61a25d163730ebd2');
    function kakaoLogin() {
      Kakao.Auth.authorize({
        redirectUri: 'http://localhost:8080/cafe-expansion/kakao-callback'
      });
    }
  </script>
</head>
<body style="background-color:#f5f5f5;">
  <div style="
      max-width:400px;
      margin:80px auto;
      padding:40px 20px;
      background-color:#ffffff;
      border-radius:8px;
      box-shadow:0 2px 8px rgba(0,0,0,0.1);
      text-align:center;
      font-family:'Pretendard', sans-serif;
  ">
    <img src="${pageContext.request.contextPath}/resources/image/kakao_logo.png" alt="kakao" style="height:40px; margin-bottom:24px;">
    <!-- 카카오 공식 로그인 버튼 -->
    <button type="button" onclick="kakaoLogin()" style="background:none; border:none; padding:0;">
      <img src="${pageContext.request.contextPath}/resources/image/카카오_공식_버튼_파일명.png" alt="카카오로 로그인" style="width:100%;">
    </button>
    <div style="margin-top:16px;">
      <a href="${pageContext.request.contextPath}/signup" style="color:#888;">회원가입</a>
    </div>
  </div>
  <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
