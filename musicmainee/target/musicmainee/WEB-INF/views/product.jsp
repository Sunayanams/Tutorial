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
<h2><center>Product Form</center></h2>

<c:url value="/Product" var="url"/>
  <form:form method="post" commandName="pro" action="${url}"  enctype="multipart/form-data">
    <form:label path="product_name">Product Name:</form:label>
      <form:input type="text" path="product_name" class="form-control" name="product_name" required="required" placeholder="Enter Name" value="${name}"/>
    </br>
    
   <form:label path="product_price" >Product Price:</form:label>
     <form:input type="number" path="product_price" class="form-control" name="product_price" required="required" value="${price}"/>
    </br>
    
   <form:label path="product_quantity">Product Quantity:</form:label>
     <form:input type="number" path="product_quantity" class="form-control" name="product_quantity" required="required" value="${quantity}"/>
    </br> 
    
    <form:label path="product_description">Product Description:</form:label>
      <form:input type="text" path="product_description" class="form-control" name="product_description" required="required" placeholder="Enter Description" value="${des}"/>
    </br>
    
   <form:select path="category.category_id" Class="form-control">
    <form:option value="NONE">Select Category Name</form:option>
    <c1:forEach items="${lcategorydetails}" var="list">
    <form:option value="${list.getCategory_id()}">${list.getCategory_name()}</form:option>
    </c1:forEach>
   </form:select></br>

   <form:select path="supplier.supplier_id" Class="form-control">
    <form:option value="NONE">Select Supplier Name</form:option>
    <c1:forEach items="${lsupplierdetails}" var="list">
    <form:option value="${list.getSupplier_id()}">${list.getSupplier_name()}</form:option>
    </c1:forEach>
   </form:select></br>
   
  <form:input type="file" path="img" name="image"  value="Upload File" />
  </br>
  <input type="submit" class="btn btn-primary" value="Submit"/>  
 </form:form></br>
 
 <table class="table table-bordered">
   <thead>
      <tr>
        <th>Image</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Product Quantity</th>
        <th>Product Description</th>
        <th>Edit</th>
        <th>Delete</th> 
         
        </tr>
    </thead>
    
  <c1:forEach items="${addpro}" var="list">
    <tr>
    <td><img src="${img}/${list.getImage()}" alt="sorry no Image" style="width:20%"></td>
     <td><a href="#">${list.getProduct_name()}</a></td>
      <td><a href="#">${list.getProduct_price()}</a></td>
      <td><a href="#">${list.getProduct_quantity()}</a></td>
      <td><a href="#">${list.getProduct_description()}</a></td>
      <td><a href='<c:url value="/pedit/${list.product_id}"></c:url>'>Edit</a></td>
      <td><a href='<c:url value="pdelete/${list.product_id}"></c:url>'>Delete</a></td>
<%--        <td><a href="pdelete/${list.product_id}"><span class="label label-default">Delete</span></a></td> --%>
<!--       <td><button type="button" class="btn btn-success">Edit</button>/<button type="button" class="btn btn-danger">Delete</button> -->
    </tr>
    </c1:forEach>
</table>

</div>   
</body>
</html>