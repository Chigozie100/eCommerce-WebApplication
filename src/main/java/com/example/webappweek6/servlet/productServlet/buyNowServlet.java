package com.example.webappweek6.servlet.productServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "buyNowServlet", value = "/order-now")
public class buyNowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String str = (String) httpSession.getAttribute("email");

        if (str == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else{
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
