<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%session.getAttribute("user");%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>报销差旅费</title>
</head>
<body>
<h2>报销差旅费</h2>
<hr>
<form id="add-form" action="${pageContext.request.contextPath}/addCostServlet" method="post">
    出差人姓名：<input name="name" type="text" id="name" value="${user.userName}"><br>
    部门：<input name="department" type="text" id="department" value="${user.department}"><br>
    目的地：<input name="destination" type="text" id="destination" ><br>
    出发日期：<input name="departureDate" type="text" id="departureDate" ><br>
    返回日期：<input name="returnDate" type="text" id="returnDate" ><br>
    出差事由：<input name="reason" type="text" id="reason" ><br>
    出发车费：<input name="startFare" type="text" id="startFare" ><br>
    返回车费：<input name="returnFare" type="text" id="returnFare" ><br>
    伙食补助：<input name="foodallowance" type="text" id="foodallowance" ><br>
    公杂补助：<input name="localtrans" type="text" id="localtrans" ><br>
    住宿费：<input name="accommodation" type="text" id="accommodation" ><br>

    <div class="buttons">
        <input value="报销差旅费" type="submit" id="add_btn">
    </div>
    <br class="clear">
</form>

</body>
</html>