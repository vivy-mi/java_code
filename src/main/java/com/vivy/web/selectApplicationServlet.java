package com.vivy.web;

import com.vivy.pojo.Application;
import com.vivy.pojo.User;
import com.vivy.service.ApplicationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectApplicationServlet")
public class selectApplicationServlet extends HttpServlet {
    private ApplicationService service = new ApplicationService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String userName = user.getUserName();
        String department = user.getDepartment();

        List<Application> applications = service.selectByUser(userName,department);

        request.setAttribute("applications",applications);

        request.getRequestDispatcher("/printApplicationList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}