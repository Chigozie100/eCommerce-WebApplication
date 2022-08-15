<%@ page import="com.example.webappweek6.dao.CartDao" %>
<%@ page import="userModel.connection.DbCon" %>
<%@ page import="java.util.List" %>
<%@ page import="userModel.model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/includes/head.jsp"%>
    <title>E-Commerce Cart</title>
    <style type="text/css">

        .table tbody td{
            vertical-align: middle;
        }
        .btn-incre, .btn-decre{
            box-shadow: none;
            font-size: 25px;
        }
    </style>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>

<div class="container my-3">
    <div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col">Price</th>
            <th scope="col">Buy Now</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
           <%
               HttpSession httpSession = request.getSession();
               int userId = (int) httpSession.getAttribute("userId");
               CartDao cartDao = new CartDao(DbCon.getConnection());
              List<Product> products = cartDao.getAllCartProduct(userId);
           %>
           <%for (Product product : products){%>
        <tr><td ><%=product.getPro_name()%> </td >
            <td ><%=product.getPro_category()%></td >
            <td ><%=product.getPro_price()%> </td >
            <td ><form action = "order-now" method = "post" class="form-inline" >
                    <input type = "hidden" name = "id" value = "" class="form-input" >
                    <div class="form-group d-flex justify-content-between" >
                        <a class="btn bnt-sm btn-incre"  href = "quantity-increase?id=<%=product.getPro_id()%>" ><i class=
                   "fas fa-plus-square" ></i ></a >
                        <input type = "text" name = "quantity" class="form-control" value = <%=product.getPro_qty()%> readonly >
                        <a class="btn btn-sm btn-decre" href = "quantity-decrease?id=<%=product.getPro_id()%>" ><i class=
                   "fas fa-minus-square" ></i ></a >
                    </div >
                    <button type = "submit" class="btn btn-primary btn-sm" > Buy </button >
                </form >
            </td >
            <td ><a href = "remove-from-cart?id=<%=product.getPro_id()%>" class="btn btn-sm btn-danger" > Remove </a ></td >
        </tr >
           <%}
        %>


        </tbody>
    </table>
</div>

<%@include file="/includes/footer.jsp"%>
</body>
</html>