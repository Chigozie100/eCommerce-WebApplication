package com.example.webappweek6.servlet.productServlet;

import com.example.webappweek6.dao.UserDao;
import com.example.webappweek6.dao.ProductDao;
import userModel.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddProductServlet", value = "/add_product")
public class viewProductServlet extends HttpServlet {
    private static Product product;
    private static UserDao userDao;
    private  static PrintWriter printWriter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        printWriter = response.getWriter();
        // add product

        String name = request.getParameter("productName");
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String category = request.getParameter("category");
        product = new Product();

        product.setPro_name(name);
        product.setPro_price(price);
        product.setPro_qty(quantity);
        product.setPro_category(category);

        userDao = new UserDao();
        try {
            if (ProductDao.addProduct(product)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewProduct.jsp");
                requestDispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
   }
}
