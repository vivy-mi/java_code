<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%session.getAttribute("user");%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增出差申请</title>
</head>
<body>
<h2>新增出差申请</h2>
<hr>
<form id="add-form" action="${pageContext.request.contextPath}/addApplicationServlet" method="post">
    出差人姓名：<input name="name" type="text" id="name" value="${user.userName}"><br>
    部门：<input name="department" type="text" id="department" value="${user.department}"><br>
    <input type="hidden" name="position" value="${user.position}">
    目的地：<input name="destination" type="text" id="destination" ><br>
    暂定出发日期：<input name="departureDate" type="text" id="departureDate" ><br>
    预计返回日期：<input name="returnDate" type="text" id="returnDate" ><br>
    出差类别：<input name="type" type="text" id="type" ><br>
    出差事由：<input name="reason" type="text" id="reason" ><br>

    <div class="buttons">
        <input value="新增申请" type="submit" id="add_btn">
    </div>
    <br class="clear">
</form>

</body>
</html>