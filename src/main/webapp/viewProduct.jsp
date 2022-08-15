<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page import="userModel.connection.DbCon" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.webappweek6.dao.ProductDao" %>
<%@ page import="com.example.webappweek6.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="userModel.model.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<style>
    <!--
    a {
        text-decoration: none;
    }
    -->
</style>
<body bgcolor="#00FFFF">
<form action="add_product" method="post">
    <h1 align="center">Product List</h1>
    <!--  All Product shows-->
    <h1 align="center">List of Products</h1>
    <table border="1" align="center" cellpadding="5"
           style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
        Name <input type="text" name="productName">
        Price <input type="text" name="price">
        Quantity <input type="text" name="quantity">
        Category <input type="text" name="category">
        <input type="submit" value="Add Product">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Category</th>
        </tr><%
       ProductDao productDao = new ProductDao();
            List<Product> products = productDao.getAllProduct();
            %>
        <%
            for (Product product : products){%>
        <tr>
            <td>
                <%=product.getPro_id()
                %>
            </td>
            <td>
                <%=product.getPro_name()
                %>
            </td>
            <td>
                <%=product.getPro_price()
                %>
            </td>
            <td>
                <%=product.getPro_qty()
                %>
            </td>
            <td>
                <%=product.getPro_category()
                %>
            </td>

            <form action="add_product" method="post">
                <td><a value="edit" name="action"
                       href="edit.jsp?id=<%=product.getPro_id()%> ">Edit</a> <input
                        type="hidden" name="j" value="<%= product.getPro_id()%>">&nbsp;&nbsp;&nbsp;
                </td>
            </form>
            <form action="deleteServlet"  method="get">
                <td>
                    <a value="delete" name="id" href="deleteServlet?id=<%=product.getPro_id()%>">Delete</a>&nbsp;&nbsp;&nbsp;

                </td>
            </form>
        </tr>
        <%}
            %>
</form>


</table>
</form>
</body>
</html>