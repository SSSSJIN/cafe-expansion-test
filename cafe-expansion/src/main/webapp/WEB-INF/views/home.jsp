<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/common/header.jsp" />

<!-- 페이지 전체를 다크 모드로 통일 -->
<style>
  body {
    background-color: #1e1e1e;
    color: #f0f0f0;
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
  }
  /* 캐러셀 컨테이너 */
  #carousel {
    position: relative;
    width: 100%;
    max-width: 800px;
    margin: 40px auto;
    overflow: hidden;
    border-radius: 8px;
  }
  /* 슬라이드 전체 래퍼 */
  .slides {
    display: flex;
    transition: transform 0.5s ease-in-out;
  }
  /* 개별 슬라이드 */
  .slide {
    min-width: 100%;
    box-sizing: border-box;
  }
  .slide img {
    width: 100%;
    display: block;
  }
  /* 이전/다음 버튼 */
  .nav-button {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    background: rgba(0,0,0,0.5);
    border: none;
    color: #fff;
    font-size: 24px;
    padding: 8px 12px;
    cursor: pointer;
    border-radius: 4px;
  }
  #prevBtn { left: 10px; }
  #nextBtn { right: 10px; }
</style>

<div id="carousel">
  <div class="slides" id="slides">
    <c:forEach var="event" items="${mainEvents}">
      <div class="slide">
        <img src="${pageContext.request.contextPath}${event.imageUrl}" alt="${event.title}" />
      </div>
    </c:forEach>
  </div>
  <button id="prevBtn" class="nav-button">&#10094;</button>
  <button id="nextBtn" class="nav-button">&#10095;</button>
</div>

<script>
  (function(){
    const slides = document.getElementById('slides');
    const total = slides.children.length;
    let index = 0;

    function update() {
      slides.style.transform = 'translateX(' + (-100 * index) + '%)';
    }
    function nextSlide() {
      index = (index + 1) % total;
      update();
    }
    function prevSlide() {
      index = (index - 1 + total) % total;
      update();
    }

    document.getElementById('nextBtn').addEventListener('click', nextSlide);
    document.getElementById('prevBtn').addEventListener('click', prevSlide);

    // 2초(2000ms)마다 자동 슬라이드
    setInterval(nextSlide, 2000);
  })();
</script>

<!-- 아래에는 기존 핫한/실시간 랭킹 기능 삽입 영역 -->
<jsp:include page="/WEB-INF/views/common/ranking.jsp" />

<jsp:include page="/WEB-INF/views/common/footer.jsp" />
