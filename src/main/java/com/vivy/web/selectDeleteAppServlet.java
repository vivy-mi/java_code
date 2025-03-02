package com.vivy.web;

import com.vivy.pojo.Application;
import com.vivy.service.ApplicationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/selectDeleteAppServlet")
public class selectDeleteAppServlet extends HttpServlet {
    private ApplicationService service = new ApplicationService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        String id = request.getParameter("id");

        service.delete(Integer.parseInt(id));

        request.getRequestDispatcher("/selectApplicationServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}