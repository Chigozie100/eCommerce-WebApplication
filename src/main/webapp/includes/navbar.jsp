<%@ page import="com.example.webappweek6.dao.CartDao" %>
<%@ page import="userModel.model.Product" %>
<%@ page import="userModel.connection.DbCon" %>
<%@ page import="java.util.List" %>
<%
	HttpSession session1 = request.getSession(false);
String newSession =(String)session1.getAttribute("name");
%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">Gozie Store</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<%

		if(newSession!=null){%>
		<%
			HttpSession httpSession = request.getSession();
			int userId = (int) httpSession.getAttribute("userId");
			CartDao cartDao = new CartDao(DbCon.getConnection());
			List<Product> products = cartDao.getAllCartProduct(userId);
		%>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
					<a class="nav-link" href="index.jsp">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="cart.jsp">Cart <span class="badge bg-danger"><%=products.size()%></span></a>
				</li>

				<li class="nav-item">
					<a class="nav-link" href="orders.jsp">Orders</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Logout">Logout</a>
				</li>
			</ul>
		</div>
		<%}
		else {%>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
					<a class="nav-link" href="index.jsp">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="login.jsp">Cart</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="signup.jsp">SignUp</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="login.jsp">Login</a>
				</li>
			</ul>
		</div>
		<%}
		%>

	</div>
</nav>