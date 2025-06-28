<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>${book.title} | 상세 페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body style="background-color:#f5f5f5;">
  <div style="max-width:600px; margin:40px auto;">
    <img src="${pageContext.request.contextPath}${book.imageUrl}" alt="작품표지" style="width:100%; border-radius:8px;">
    <h2 style="margin-top:24px;">${book.title}</h2>
    <p><b>작가:</b> ${book.author}</p>
    <p><b>장르:</b> ${book.genre}</p>
    <p style="margin-top:24px;">${book.description}</p>
    <div style="margin-top:24px;">
      <a href="${pageContext.request.contextPath}/home" style="color:#888;">홈으로 돌아가기</a>
    </div>
  </div>
</body>
</html>
