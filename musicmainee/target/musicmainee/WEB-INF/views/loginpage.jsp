<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <script src="js/jquery.bootstrap.min.js"></script>
</head>
<body>
<div>
<%@include file="navbar.jsp"%>
</div>
<div class="container">
  <h2><center>Login</center></h2>
  <c1:if test="${s==false}">
 <div class="alert alert-danger">
  <center><h3>${mes} </h3></center>
 </div>
 </c1:if>
 
 <c1:if test="${registrationSuccess !=null}">
${registrationSuccess }
</c1:if>
<c1:if test="${logout!=null }">
${logout }
</c1:if>
 
  <form name="login" method="post" action="<c:url value="/j_spring_security_check"></c:url>">
  <c1:if test="${not empty error }">
     ${error }
  </c1:if>
  
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" class="form-control" name="j_username" placeholder="Enter email">
    </div></br>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="j_password" placeholder="Enter password">
    </div></br>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div></br>
   <input type="submit" class="btn btn-primary" value="Login"/> 
  </form>
</div>
</body>
</html>