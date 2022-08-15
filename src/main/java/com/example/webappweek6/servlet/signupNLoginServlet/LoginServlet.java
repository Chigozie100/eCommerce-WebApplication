package com.example.webappweek6.servlet.signupNLoginServlet;

import com.example.webappweek6.dao.UserDao;
import userModel.connection.DbCon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/user-login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("login-email");
        String password = request.getParameter("login-password");
        UserDao userDao = new UserDao();
       String result = userDao.userLogin(email,password);

        if(result.equals("admin")){
        HttpSession session = request.getSession();
            session.setAttribute("name",email);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewProduct.jsp");
            requestDispatcher.forward(request,response);

        } else if (result.equals("customer")) {
            HttpSession session = request.getSession();
           int id = userDao.getUserId(email,password);
            session.setAttribute("userId",id);
            session.setAttribute("name",email);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("error","incorrect email or password");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
