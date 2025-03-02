<%@ page import="java.util.Objects" %>
<%@ page import="com.vivy.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%User user = (User)session.getAttribute("user");%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <script>
        function addApplication() {
            window.location.href = "addApplication.jsp";
        }

        function modifyApplication() {
            window.location.href = "${pageContext.request.contextPath}/selectApplicationServlet";
        }

        function deleteApplication() {
            window.location.href = "${pageContext.request.contextPath}/selectApplicationServlet";
        }

        function searchApplication() {
            window.location.href = "${pageContext.request.contextPath}/selectApplicationServlet";
        }

        function addCost() {
            window.location.href = "addCost.jsp";
        }

        function modifyCost() {
            window.location.href = "${pageContext.request.contextPath}/selectCostServlet";
        }

        function searchCost() {
            window.location.href = "${pageContext.request.contextPath}/selectCostServlet";
        }

        function modifyState() {
            window.location.href = "${pageContext.request.contextPath}/selectUpStateAppServlet";
        }
    </script>
</head>
<body>
<h1>首页</h1>
<hr>
<% if(Objects.equals(user.getPosition(), "总经理")||Objects.equals(user.getPosition(),"部门经理")) {%>
<button onclick="modifyState()">审批出差申请</button>
<button onclick="">审批差旅费报销</button>
<button onclick="">查询差旅费花费情况</button>
<%}%>

<% if(Objects.equals(user.getPosition(), "普通职员")||Objects.equals(user.getPosition(),"部门经理")) {%>
<button onclick="addApplication()">新增出差申请</button>

<% if(Objects.equals(user.getPosition(), "普通职员")) {%>
<button onclick="modifyApplication()">修改出差申请</button>
<button onclick="deleteApplication()">撤回出差申请</button>
<button onclick="modifyCost()">修改报销单据</button>
<%}%>

<button onclick="addCost()">报销差旅费</button>
<button onclick="searchApplication()">查看出差申请</button>
<button onclick="searchCost()">查看报销进度</button>

<%}%>

<% if(Objects.equals(user.getPosition(), "总经理")) {%>
<button onclick="">统计各个部门本年度差旅费花费情况</button>
<%}%>

<% if(Objects.equals(user.getPosition(), "财务人员")) {%>
<button onclick="">审核报销单据</button>
<button onclick="">查询报销情况</button>
<%}%>
</body>
</html>