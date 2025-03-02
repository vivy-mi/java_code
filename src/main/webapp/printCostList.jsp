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
        <th>报销编号</th>
        <th>出差人姓名</th>
        <th>部门</th>
        <th>目的地</th>
        <th>出发日期</th>
        <th>返回日期</th>
        <th>出差事由</th>
        <th>总金额</th>
        <th>进度状态</th>
        <th>审批理由</th>
        <th>操作</th>

    </tr>

    <c:forEach items="${costs}" var="cost" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${cost.costId}</td>
            <td>${cost.name}</td>
            <td>${cost.department}</td>
            <td>${cost.destination}</td>
            <td>${cost.departureDate}</td>
            <td>${cost.returnDate}</td>
            <td>${cost.reason}</td>
            <td>${cost.totalamount}</td>
            <td>${cost.schedule}</td>
            <td>${cost.scheduleReason}</td>
            <td><a href="${pageContext.request.contextPath}/selectUpdateCostServlet?id=${cost.id}">修改</a></td>>
        </tr>

    </c:forEach>
</table>

<button onclick="Back()">返回首页</button>

</body>
</html>