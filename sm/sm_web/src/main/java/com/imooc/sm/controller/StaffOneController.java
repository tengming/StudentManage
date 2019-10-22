package com.imooc.sm.controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.DepartmentService;
import com.imooc.sm.service.SelfService;
import com.imooc.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffoneController")
public class StaffOneController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;

    public void listOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("USER");
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        Staff staff = staffService.get(id);
        request.setAttribute("LISTONE", staff);
        request.getRequestDispatcher("../staff_listone.jsp").forward(request, response);
    }


    public void toEditone(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff  = staffService.get(id);
        request.setAttribute("STAFFONE",staff);

        List<Department> list = departmentService.getAll();
        request.setAttribute("DEPARTONE",list);

        request.getRequestDispatcher("../staff_editone.jsp").forward(request,response);
    }



    public void editone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        Integer did = Integer.parseInt(request.getParameter("did"));

        String status = "正常";
        Staff staff = staffService.get(id);
        try {
            Date bornData = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornData"));
            staff.setBornData(bornData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setDid(did);
        staff.setName(name);
        staff.setSex(sex);
        staff.setStatus(status);
        staff.setIdNumber(idNumber);
//        staff.setBornData(bornData);
        staffService.edit(staff);

        response.sendRedirect("listOne.do");
    }
}
