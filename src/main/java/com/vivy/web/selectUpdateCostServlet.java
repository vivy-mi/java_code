package com.vivy.web;

import com.vivy.pojo.Cost;
import com.vivy.service.CostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectUpdateCostServlet")
public class selectUpdateCostServlet extends HttpServlet {
    private CostService service = new CostService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        String id = request.getParameter("id");
        Cost cost = service.selectById(Integer.parseInt(id));

        request.setAttribute("cost",cost);
        request.getRequestDispatcher("/updateCost.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}