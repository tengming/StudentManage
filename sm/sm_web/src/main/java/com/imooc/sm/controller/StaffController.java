package com.imooc.sm.controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.DepartmentService;
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

import static java.lang.Math.*;


@Controller("staffController")
public class StaffController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list = staffService.getAll();

        request.setAttribute("List", list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request, response);

    }



    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("DLIST", list);

        request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        String name = request.getParameter("name");
        String idNumber = request.getParameter("idNumber");
        String sex = request.getParameter("sex");

        Integer did = Integer.parseInt(request.getParameter("did"));
        Date workTime = new Date();
        Staff staff = new Staff();
        Date bornData = null;
        bornData = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornData"));

        staff.setName(name);
        staff.setDid(did);
        staff.setBornData(bornData);
        staff.setWorkTime(workTime);
        staff.setAccount(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);

        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        Staff staff = staffService.get(id);
        request.setAttribute("SOBJ", staff);

        List<Department> list = departmentService.getAll();
        request.setAttribute("DEDIT", list);

        request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
//        int a = (int)(random()*(9999-1000+1))+1000;
//        String idNumber = String.valueOf(a);
        staff.setIdNumber(idNumber);
//staff.setBornData(bornData);
        staffService.edit(staff);

        response.sendRedirect("list.do");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");
    }

    public void chakan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);

        request.setAttribute("Chakan", staff);
        request.getRequestDispatcher("../staff_chakan.jsp").forward(request, response);
    }

}
