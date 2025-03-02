package com.vivy.web;

import com.vivy.pojo.Application;
import com.vivy.service.ApplicationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllAppServlet")
public class selectAllAppServlet extends HttpServlet {
    private ApplicationService service = new ApplicationService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        List<Application> applications = service.selectAll();

        request.setAttribute("applications",applications);

        request.getRequestDispatcher("/printApplicationList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}