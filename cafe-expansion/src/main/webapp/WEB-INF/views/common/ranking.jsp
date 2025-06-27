<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="common-ranking">
    <h3>실시간 랭킹</h3>
    <ul>
        <c:forEach var="book" items="${hotBooks}">
            <li>
                <a href="${pageContext.request.contextPath}/book/${book.id}">
                    <img src="${pageContext.request.contextPath}${book.image}" alt="${book.title}" />
                    <span>${book.title}</span>
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
