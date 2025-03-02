package com.vivy.web;


import com.vivy.pojo.Cost;
import com.vivy.pojo.User;
import com.vivy.service.CostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectCostServlet")
public class selectCostServlet extends HttpServlet {
    private CostService service = new CostService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String userName = user.getUserName();
        String department = user.getDepartment();

        List<Cost> costs = service.selectByUser(userName,department);

        request.setAttribute("costs",costs);

        request.getRequestDispatcher("/printCostList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}