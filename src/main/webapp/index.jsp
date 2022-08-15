<%@ page import="com.example.webappweek6.dao.ProductDao" %>
<%@ page import="java.util.List" %>
<%@ page import="userModel.model.Product" %>
<%@ page import="static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09/08/2022
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <%@include file="/includes/head.jsp"%>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<div class="container">
    <div class="card-header my-3">All Products</div>
    <%
        List<Product> products = ProductDao.getAllProduct();
    %>
    <div class="row">
    <%  for (Product p : products){%>
        <div class="col-md-3 my-3">
            <div class="card w-100">
                <img class="card-img-top" src="Product-image/<%=p.getImage()%>" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><%=p.getPro_name()%></h5>
                    <h6 class="price"><%=p.getPro_price()%></h6>
                    <h6 class="category"><%=p.getPro_category()%></h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a class="btn btn-dark" href="add-to-cart?id=<%=p.getPro_id()%>">Add to Cart</a> <a
                            class="btn btn-primary" href="order-now">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
    <%}
    %>
    </div>
</div>

<%@include file="/includes/footer.jsp"%>
</body>
</html>
