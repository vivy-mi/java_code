package com.vivy.web;

import com.vivy.pojo.Application;
import com.vivy.service.ApplicationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateApplicationServlet")
public class updateApplicationServlet extends HttpServlet {

    private ApplicationService service = new ApplicationService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        String id = request.getParameter("id");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departureDate");
        String returnDate = request.getParameter("returnDate");
        String type = request.getParameter("type");
        String reason = request.getParameter("reason");
        String state = request.getParameter("state");
        String stateReason = request.getParameter("stateReason");

        Application application = new Application();

        application.setId(Integer.parseInt(id));
        application.setDestination(destination);
        application.setDepartureDate(departureDate);
        application.setReturnDate(returnDate);
        application.setType(type);
        application.setReason(reason);
        application.setState(state);
        application.setStateReason(stateReason);

        service.update(application);

        if (state == null) {
            request.getRequestDispatcher("/selectApplicationServlet").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/selectUpStateAppServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}