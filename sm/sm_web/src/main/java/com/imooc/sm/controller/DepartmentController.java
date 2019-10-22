package com.imooc.sm.controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("../department_list.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../department_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Department department = new Department();
        department.setName(name);
        department.setAddress(address);

        departmentService.add(department);
        //重定向
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //为什么要转换，因getParameter得到的是字符串，Integer.parseInt()是将字符串转换成Int型
        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println("toEdit的id值" + id);
        Department department = departmentService.get(id);
        request.setAttribute("OBJ", department);

        request.getRequestDispatcher("../department_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        System.out.println("update" + id);
//        String name = request.getParameter("name");
//        String address = request.getParameter("address");
//
//        Department department = departmentService.get(id);
//        department.setName(name);
//        department.setAddress(address);
//
//        departmentService.edit(department);
//
//        response.sendRedirect("list.do");

        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println("edit的id值"+id);
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Department department = new Department();
        department.setId(id);
        department.setName(name);
        department.setAddress(address);
        departmentService.edit(department);
        response.sendRedirect("list.do");
    }


    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        departmentService.remove(id);
        response.sendRedirect("list.do");
    }
}
