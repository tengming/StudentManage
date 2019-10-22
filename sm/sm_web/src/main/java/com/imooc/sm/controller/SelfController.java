package com.imooc.sm.controller;

import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.SelfService;
import com.imooc.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller("selfController")
public class SelfController {

    @Autowired
    private SelfService selfService;
    @Autowired
    private StaffService staffService;

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Staff staff = selfService.login(account,password);
        if (staff == null){
            response.sendRedirect("toLogin.do");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("USER",staff);
            response.sendRedirect("main.do");
        }
    }

    public void toRegister(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        Staff staff = new Staff();
        staff.setWorkTime(new Date());
        staff.setName(name);
        staff.setAccount(account);
        staff.setPassword(password);
        staffService.addRegister(staff);
        response.sendRedirect("toLogin.do");
    }

    public void main(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void toLogout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    public void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("USER",null);
        response.sendRedirect("toLogin.do");
    }

    public void info(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("../info.jsp").forward(request,response);
    }

    public void toChangePassword(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../changepassword.jsp").forward(request,response);
    }

    public void changepassword(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        String passwordNew = request.getParameter("passwordNew");

        HttpSession session = request.getSession();

        Staff staff = (Staff)session.getAttribute("USER");
        if (staff.getPassword().equals(password)){
            selfService.changePassword(staff.getId(),passwordNew);
//            response.sendRedirect("../logout.do");
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");

        }else {
            response.sendRedirect("toChangePassword.do");

        }
    }


}
