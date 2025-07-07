<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:forEach var="item" items="${items}">
    <div>
		test
        <span>${item.title}</span>
        <span>${item.category}</span>
        <!-- 필요한 정보 출력 -->
    </div>
</c:forEach>
