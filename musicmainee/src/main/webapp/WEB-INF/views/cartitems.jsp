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
<h2><center>Items Details</center></h2>
${msg}
<table class="table table-bordered">
<thread>
 <tr>
 <td>Product Image</td>
 <td>Product Name</td>
 <td>Total Price</td>
 <td>Buy/Remove</td>
 </tr>
 </thread>
 <c1:forEach items="${l}" var="l1">
 <tr>
    <td><img src="${img}/${l1.getProduct_id()}.jpg" alt="sorry no Image" style="width:20%"></td>
    <td><a href="#">${l1.getProduct_name()}</a></td>
     <td><a href="#">${l1.getTotal_price()}</a></td>
     <td><a href="<c:url value="/Shippmentadd/${l1.getProduct_id()}"/>" class="btn btn-primary">Buy</a>/<a href="<c:url value="/remove/${l1.getCartitems_id()}"/>" class="btn btn-primary">Remove</a></td>
 </tr>
 </c1:forEach>
</table>
<center><label><h2>Grand Total=$ ${c1}</h2></label></center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<c:url value="/Shippmentadd"/>" class="btn btn-primary">Buy All</a>/<a href="<c:url value="/remove2/${userdetails}"/>" class="btn btn-primary">Remove All</a>
</div>

</body>
</html>