package com.vivy.web;

import com.vivy.pojo.User;
import com.vivy.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        User user = service.login(userId, password);

        PrintWriter writer = response.getWriter();

        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            writer.write("登录成功");
            request.getRequestDispatcher("/staff.jsp").forward(request,response);
        }else {
            writer.write("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}