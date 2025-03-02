<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>审批出差申请</title>
</head>
<body>
<h2>审批出差申请</h2>
<hr>
<form action="${pageContext.request.contextPath}/updateApplicationServlet" method="post">

    <%--隐藏域,提交id--%>
    <input type="hidden" name="id" value="${application.id}">

    <p>申请编号:${application.businessId}</p>
    <p>出差人姓名:${application.name}</p>
    <p>部门:${application.department}</p>
    <p>目的地：${application.destination}</p>
    <p>暂定出发日期：${application.departureDate}</p>
    <p>预计返回日期：${application.returnDate}</p>
    <p> 出差类别：${application.type}</p>
    <p>出差事由：${application.reason}</p>
    审批：
    <input type="radio" name="state" value="通过" id="on"><label for="on">通过</label>
    <input type="radio" name="state" value="退回" id="off"><label for="off">退回</label>
    <br>
    <label>
        审批理由：
        <textarea cols="20" rows="5" name="stateReason" id="stateReason"></textarea>
    </label>
    <br>


    <div class="buttons">
        <input value="审批出差申请" type="submit" id="update_btn">
    </div>
    <br class="clear">
</form>

</body>
</html>