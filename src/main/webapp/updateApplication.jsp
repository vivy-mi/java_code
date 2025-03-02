<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改申请</title>
</head>
<body>
<h2>修改申请</h2>
<hr>
<form action="${pageContext.request.contextPath}/updateApplicationServlet" method="post">

    <%--隐藏域,提交id--%>
    <input type="hidden" name="id" value="${application.id}">

    <p>申请编号:${application.businessId}</p>
    <p>出差人姓名:${application.name}</p>
    <p>部门:${application.department}</p>
    目的地：<input name="destination" type="text" id="destination" value="${application.destination}"><br>
    暂定出发日期：<input name="departureDate" type="text" id="departureDate" value="${application.departureDate}"><br>
    预计返回日期：<input name="returnDate" type="text" id="returnDate" value="${application.returnDate}"><br>
    出差类别：<input name="type" type="text" id="type" value="${application.type}"><br>
    出差事由：<input name="reason" type="text" id="reason" value="${application.reason}"><br>


    <div class="buttons">
        <input value="确认修改" type="submit" id="update_btn">
    </div>
    <br class="clear">
</form>

</body>
</html>