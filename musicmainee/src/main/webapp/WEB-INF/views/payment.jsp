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
		<h2>
			<center>Payment Form</center></h2>
			<form action="<c:url value="/confirmorder"/>" method="post">
				<div class="radio">
					<label><input type="radio" name="optradio" value="Card">Credit Card</label>
				</div>
				<div class="radio">
					<label><input type="radio" name="optradio" value="Cash">COD</label>
				</div>
				<input type="submit" value="Submit" class="btn btn-primary" />
			     </form></br>
			    <a href="<c:url value="/cancel"/>" class="btn btn-primary">Cancel</a>
			
		</div>
</body>
</html>