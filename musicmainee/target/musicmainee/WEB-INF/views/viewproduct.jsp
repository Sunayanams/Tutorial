<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<%@include file="navbar.jsp"%>
</div>
<div class="container">
<h2><center>Product Details</center></h2>
      <table class="table table-bordered">
      <tr>
		<td><a href="#">${pro1.getProduct_id()}</a></td>
		<td><a href="#">${pro1.getCategory().getCategory_name()}</a>
		<td><a href="#">${pro1.getProduct_price()}</a></td>
		<td><a href="#">${pro1.getProduct_quantity()}</a></td>
		<td><a href="#">${pro1.getProduct_description()}</a></td>
		 <td><img src="${img}/${pro1.getImage()}" alt="Image not found" style="width:20%"></a></td>
		</tr>
	  </table>
       <a href="<c:url value="/Shippmentadd/${pro1.getProduct_id()}"/>" class="btn btn-primary">Buy</a>
      <a href="<c:url value="/addtocart/${product_id}"/>" class="btn btn-primary">AddtoCart</a>
</div>
</body>
</html>