<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
  <meta charset = "utf-8">
<meta name = "viewport" content = "width=device-width, initial-scale=1">
<link href = "css/bootstrap.css" rel = "stylesheet" type = "text/css"/>
<link href="css.css" rel="stylesheet" type="text/css"/>
<link rel = "stylesheet" href = "http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<title>Comment Box</title>
</head>
<body>
<div>
<%@include file="navbar.jsp"%>
</div>
<center><h1>Sign Up</h1></center>
<div class="container">
<c1:url var="subt" value="/Submit"/>
<form:form method="POST" commandName="user" action="${subt}">

<form:label path="user_name" for="user_name" >User Name:</form:label>
<form:input type="text" path="user_name" class="form-control" name="user_name" required="required"  placeholder="Enter Name"/>
</br>
<form:label path="user_address" for="user_address">User Address:</form:label>
<form:input type="text" path="user_address" class="form-control" name="user_address" required="required" placeholder="Enter Address"/>
</br>
<form:label path="user_dob" for="date/of/birth">Date/Of/Birth:</form:label>
<input type="date"  path="user_dob" class="form-control" name="dateofbirth" placeholder="Enter Date Of Birth"/>
</br>
<form:label path="user_phoneno" for="user_phoneno">Phone Number:</form:label>
<input type="number" path="user_phoneno" class="form-control" name="user_phoneno" required="required" placeholder="Enter Phone Number"/>
</br>
<form:label path="email_id" for="email_id">Email Id:</form:label>
<form:input type="text" path="email_id" class="form-control" name="email_id" required="required" placeholder="Enter Email Id"/>
</br>
  <form:label path="password" name="pwd1" for="password">Password:</form:label>
  <form:input type="password" name="pwd1"  path="password" class="form-control"  placeholder="Enter password"/>
 </br>
  <label path="password" for="password">Password:</label>
  <input type="password" name="pwd2"  class="form-control"  placeholder="Renter password"/>
</br>
<form:label path="gender" for="gender">Gender:</form:label>
<div class="radio">
  <form:radiobutton path="gender" value="Male" label="Male"/> &nbsp &nbsp
  <form:radiobutton path="gender" value="Female" label="Female"/> &nbsp &nbsp
</div>
    <input type="submit" class="btn btn-primary" value="Submit"/>    
</form:form>
</div>
</body>
</html>