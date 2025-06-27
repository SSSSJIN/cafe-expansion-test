<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ▶ 완전히 새로 만든 다크 모드 헤더 -->
<header style="
    background-color: #191919;
    color: #ffffff;
    font-family: 'Pretendard', sans-serif;
">
  <!-- 1. Top Bar: 로고 / 책 메뉴 / 검색 / 보관함 / 로그인(또는 로그아웃) -->
  <div style="
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 10px 40px;
  ">
    <!-- 왼쪽: 로고 + 책 -->
    <div style="display: flex; align-items: center; gap: 30px;">
      <!-- 로고 -->
      <a href="${pageContext.request.contextPath}/home" style="display: inline-block;">
        <img src="${pageContext.request.contextPath}/resources/image/logo.png"
             alt="kakaopage 로고"
             style="height: 24px;"/>
      </a>
      <!-- 책 메뉴 -->
      <a href="${pageContext.request.contextPath}/home"
         style="
           color: #ffffff;
           text-decoration: none;
           font-weight: 500;
           font-size: 1rem;
         ">
        책
      </a>
    </div>

    <!-- 오른쪽: 검색창 + 보관함 + 로그인/회원가입 -->
    <div style="display: flex; align-items: center; gap: 20px;">
      <!-- 검색 폼 -->
      <form action="${pageContext.request.contextPath}/search" method="get"
            style="display: flex; align-items: center;">
        <input type="text" name="q" placeholder="제목, 작가를 입력하세요..."
               style="
                 height: 32px;
                 padding: 0 12px;
                 border: none;
                 border-radius: 4px 0 0 4px;
                 outline: none;
               "/>
        <button type="submit"
                style="
                  height: 32px;
                  border: none;
                  border-radius: 0 4px 4px 0;
                  background-color: #333;
                  cursor: pointer;
                ">
          <img src="${pageContext.request.contextPath}/resources/image/search-icon.png"
               alt="검색"
               style="height: 18px;"/>
        </button>
      </form>

      <!-- 보관함 아이콘 -->
      <a href="${pageContext.request.contextPath}/storage" title="보관함">
        <img src="${pageContext.request.contextPath}/resources/image/storage.png"
             alt="보관함"
             style="height: 24px;"/>
      </a>

      <!-- 로그인/회원가입 또는 로그아웃 아이콘 -->
      <c:choose>
        <c:when test="${not empty sessionScope.member}">
          <a href="${pageContext.request.contextPath}/logout" title="로그아웃">
            <img src="${pageContext.request.contextPath}/resources/image/login.png"
                 alt="로그아웃"
                 style="height: 24px;"/>
          </a>
        </c:when>
        <c:otherwise>
          <a href="${pageContext.request.contextPath}/login" title="로그인/회원가입">
            <img src="${pageContext.request.contextPath}/resources/image/login.png"
                 alt="로그인"
                 style="height: 24px;"/>
          </a>
        </c:otherwise>
      </c:choose>
    </div>
  </div>

  <!-- 2. 서브 네비: 지금 핫한 / 실시간 랭킹 -->
  <nav style="
      display: flex;
      align-items: center;
      gap: 20px;
      padding: 8px 40px;
      background-color: #222;
  ">
    <a href="${pageContext.request.contextPath}/hot"
       style="
         color: #ffffff;
         text-decoration: none;
         font-weight: 500;
       ">
      지금 핫한
    </a>
    <a href="${pageContext.request.contextPath}/ranking"
       style="
         color: #ffffff;
         text-decoration: none;
         font-weight: 500;
       ">
      실시간 랭킹
    </a>
  </nav>
</header>
