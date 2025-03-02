package com.vivy.web;

import com.vivy.pojo.Cost;
import com.vivy.service.CostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addCostServlet")
public class addCostServlet extends HttpServlet {
    private CostService service = new CostService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        int sequenceNumber = 0;
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String currentYear = yearFormat.format(new Date());
        // 确保申请序号是四位数
        int currentSeq = ++sequenceNumber;
        String sequenceStr = String.format("%04d", currentSeq);
        // 组合成报销编号
        String costId = currentYear + sequenceStr;
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departureDate");
        String returnDate = request.getParameter("returnDate");
        String reason = request.getParameter("reason");
        double startFare = Double.parseDouble(request.getParameter("startFare"));
        double returnFare = Double.parseDouble(request.getParameter("returnFare"));
        double foodallowance = Double.parseDouble(request.getParameter("foodallowance"));
        double localtrans = Double.parseDouble(request.getParameter("localtrans"));
        double accommodation = Double.parseDouble(request.getParameter("accommodation"));
        double totalamount = startFare + returnFare + foodallowance + localtrans + accommodation;

        Cost cost = new Cost();

        cost.setCostId(costId);
        cost.setName(name);
        cost.setDepartment(department);
        cost.setDestination(destination);
        cost.setDepartureDate(departureDate);
        cost.setReturnDate(returnDate);
        cost.setReason(reason);
        cost.setStartFare(startFare);
        cost.setReturnFare(returnFare);
        cost.setFoodallowance(foodallowance);
        cost.setLocaltrans(localtrans);
        cost.setAccommodation(accommodation);
        cost.setTotalamount(totalamount);

        service.add(cost);

        request.getRequestDispatcher("/selectCostServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}