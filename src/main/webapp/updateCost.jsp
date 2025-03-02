<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改报销单据</title>
</head>
<body>
<h2>修改报销单据</h2>
<hr>
<form action="${pageContext.request.contextPath}/updateCostServlet" method="post">

    <%--隐藏域,提交id--%>
    <input type="hidden" name="id" value="${cost.id}">

    <p>申请编号:${cost.costId}</p>
    <p>出差人姓名:${cost.name}</p>
    <p>部门:${cost.department}</p>
    目的地：<input name="destination" type="text" id="destination" value="${cost.destination}"><br>
    出发日期：<input name="departureDate" type="text" id="departureDate" value="${cost.departureDate}"><br>
    返回日期：<input name="returnDate" type="text" id="returnDate" value="${cost.returnDate}"><br>
    出差事由：<input name="reason" type="text" id="reason" value="${cost.reason}"><br>
    出发车费：<input name="startFare" type="text" id="startFare" value="${cost.startFare}"><br>
    返回车费：<input name="returnFare" type="text" id="returnFare" value="${cost.returnFare}"><br>
    伙食补助：<input name="foodallowance" type="text" id="foodallowance" value="${cost.foodallowance}"><br>
    公杂补助：<input name="localtrans" type="text" id="localtrans" value="${cost.localtrans}"><br>
    住宿费：<input name="accommodation" type="text" id="accommodation" value="${cost.accommodation}"><br>
    <p>总金额:${cost.totalamount}</p>

    <div class="buttons">
        <input value="确认修改" type="submit" id="update_btn">
    </div>
    <br class="clear">
</form>

</body>
</html>