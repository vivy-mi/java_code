package com.vivy.web;

import com.vivy.pojo.Application;
import com.vivy.pojo.User;
import com.vivy.service.ApplicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/selectUpStateAppServlet")
public class selectUpStateAppServlet extends HttpServlet {
    private ApplicationService service = new ApplicationService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
        String position = null;

        if(Objects.equals(user.getPosition(), "部门经理")){
            position = "普通职员";
        }
        else if(Objects.equals(user.getPosition(), "总经理")){
            position = "部门经理";
        }
        List<Application> applications = service.selectByPosition(user.getDepartment(), position);

        request.setAttribute("applications",applications);
        request.getRequestDispatcher("/printUpStateAppList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}