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
<h2><center> Supplier Form</center></h2>

<!--   <h2><center>Supplier</center></h2> -->
<%--   <h2> ${chose}</h2> --%>
  <c:url var="Addsupplier" value="/Supplier"/>
 
  <form:form method="POST" commandName="sup" action="${Addsupplier}">
  
   
      <form:label path="supplier_name" for="supplier_name">Supplier Name:</form:label>
      <form:input type="text" path="supplier_name" class="form-control" name="supplier_name" required="required" placeholder="Enter Name" value="${name}"/>
   </br>
     
      <form:label path="supplier_address" for="supplier_address">Supplier Address:</form:label>
      <form:input type="text" path="supplier_address"  class="form-control" name="supplier_address" required="required" placeholder="Enter Address" value="${add}"/>
   </br>
    
      <form:label path="supplier_description" for="supplier_description">Supplier Description:</form:label>
      <form:input type="text" path="supplier_description" class="form-control" name="supplier_description" required="required" placeholder="Enter Description" value="${des}"/>
    </br>
    <input type="submit" class="btn btn-primary" value="Submit"/>
    </form:form></br>
    
<table class="table table-bordered">
   <thead>
      <tr>
        <th>Supplier Name</th>
        <th>Supplier Address</th>
        <th>Supplier Description</th>
        <th>Edit</th>
        <th>Delete</th> 
       </tr>
    </thead>
    
    <c1:forEach items="${addsup}" var="list">
    <tr>
      <td><a href="#">${list.getSupplier_name()}</a></td>
      <td><a href="#">${list.getSupplier_address()}</a></td>
      <td><a href="#">${list.getSupplier_description()}</a></td>
<%--        <td><a href="sdelete/${list.supplier_id}"><span class="label label-default">Delete</span></a></td> --%>
       <td><a href='<c:url value="/sedit/${list.supplier_id}"></c:url>'>Edit</a></td>
       <td><a href='<c:url value="sdelete/${list.supplier_id}"></c:url>'>Delete</a></td>
        
<!--       <td><button type="button" class="btn btn-success">Edit</button>/<button type="button" class="btn btn-danger">Delete</button> -->
    </tr>
    </c1:forEach>
</table>
</div>   
</body>
</html>