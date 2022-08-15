<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Insert title here</title>
</head>
<body bgcolor="#00FFFF">
<form action="editproduct" method="post">
  <h1 align="center">Edit Product</h1>
  <h1>
    <a href="index.jsp">List of Products</a>
  </h1>
  <table border="1" align="center" cellpadding="5"
         style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
    <tr>
      <td>Enter Product ID</td>
      <td><input type="text" name="id" required></td>
    </tr>
    <tr>
      <td>Enter Product name</td>
      <td><input type="text" name="proName" required></td>
    </tr>
    <tr>
      <td>Enter Product Price</td>
      <td><input type="text" name="proPrice" required></td>
    </tr>
    <tr>
      <td>Enter Product quantity</td>
      <td><input type="text" name="proQuantity" required></td>
    </tr><tr>
      <td>Enter Product Category</td>
      <td><input type="text" name="proCategory" required></td>
    </tr>
    <tr>
      <td></td>
      <td align="center"><input type="submit" name="Action"
                                value="Edit"></td>
    </tr>
  </table>

</form>
</body>
</html>