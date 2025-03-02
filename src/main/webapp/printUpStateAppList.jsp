<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        function Back() {
            window.location.href = "staff.jsp";
        }
    </script>
</head>
<body>
<table border="1" cellspacing="0" width="100%">
    <tr>
        <th>序号</th>
        <th>申请编号</th>
        <th>姓名</th>
        <th>部门</th>
        <th>目的地</th>
        <th>出发日期</th>
        <th>返回日期</th>
        <th>出差类别</th>
        <th>出差事由</th>
        <th>操作</th>

    </tr>

    <c:forEach items="${applications}" var="application" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${application.businessId}</td>
            <td>${application.name}</td>
            <td>${application.department}</td>
            <td>${application.destination}</td>
            <td>${application.departureDate}</td>
            <td>${application.returnDate}</td>
            <td>${application.type}</td>
            <td>${application.reason}</td>
            <td><a href="${pageContext.request.contextPath}/selectOneAppServlet?id=${application.id}">审批</a></td>>
        </tr>

    </c:forEach>
</table>

<button onclick="Back()">返回首页</button>

</body>
</html>