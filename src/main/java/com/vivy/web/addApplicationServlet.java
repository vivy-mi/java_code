package com.vivy.web;

import com.vivy.pojo.Application;
import com.vivy.service.ApplicationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addApplicationServlet")
public class addApplicationServlet extends HttpServlet {
    private ApplicationService service = new ApplicationService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //# = new String(classId.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        String businessId = generateID();

        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departureDate");
        String returnDate = request.getParameter("returnDate");
        String type = request.getParameter("type");
        String reason = request.getParameter("reason");

        Application application = new Application();

        application.setBusinessId(businessId);
        application.setName(name);
        application.setDepartment(department);
        application.setPosition(position);
        application.setDestination(destination);
        application.setDepartureDate(departureDate);
        application.setReturnDate(returnDate);
        application.setType(type);
        application.setReason(reason);

        service.add(application);

        request.getRequestDispatcher("/selectApplicationServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    private int sequenceNumber = 1;

    public synchronized String generateID() {
        // 获取当前日期
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String dateStr = sdf.format(now);

        // 读取或初始化sequenceNumber
        if (sequenceNumber == 1) {
            File file = new File("sequenceNumberHouse.txt");
            if (file.exists()) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    sequenceNumber = Integer.parseInt(line);
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 组合房产编号
        String sequenceStr = String.format("%04d", sequenceNumber++);
        String ID = dateStr + sequenceStr;

        // 更新sequenceNumber到文件
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("sequenceNumberHouse.txt"));
            writer.write(String.valueOf(sequenceNumber));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ID;
    }
}