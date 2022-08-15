package com.example.webappweek6.servlet.signupNLoginServlet;

import com.example.webappweek6.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "SignupServlet", value = "/action_page")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password1 = request.getParameter("pws-repeat");
        String name = request.getParameter("name");
        if (!password.equals(password1)){
            out.println("Incorrect password");
        } else {
            UserDao userDao = new UserDao();
            try {
                String newEntry = String.valueOf(userDao.userSignUp(email, password));
                if (newEntry.equals("successful")){
                    HttpSession session = request.getSession();
                    session.setAttribute("email.",email);
                    response.sendRedirect("login.jsp");
                }
                else{
                    request.setAttribute("response","Email Exit");
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
