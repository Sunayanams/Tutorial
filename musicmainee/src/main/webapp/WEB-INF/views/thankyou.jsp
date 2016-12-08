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
	<h2><center>Thank You for Buying</center></h2>
	</div>
	<div class="container">
	<h3>Details of your Transcation</h3>
	
	<c1:forEach var="lis" items="${l}">
	<h4>Product:</h4><img src="${img}/${lis.getProduct_id()}.jpg" style=width:10%" /></br>
	<h4>Product Name:</h4>${lis.getProduct_name()}</br>
<%-- 	Billing_Address:${lis.getB_address()}</br> --%>
<%-- 	Shippment_Address:${lis.getS_address()}</br> --%>
	<h4>Total_Price:</h4>${lis.getTotal_price()}</br>
	</c1:forEach>
	
	<a href="<c:url value="/"/>">Click here</a> to continue shopping...
	</div>
</body>
</html>