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
			<center>Category Form</center>
		</h2>

		<!--   <h2><center>Category</center></h2> -->
		<%--   <h2> ${chose}</h2> --%>
		<c:url var="register" value="/Reg" />
		<form:form method="POST" commandName="cat" action="${register}">
			<form:label path="category_name" for="category_name">Category Name:</form:label>
			<form:input type="text" path="category_name" class="form-control"
				name="category_name" required="required" placeholder="Enter Name" value="${name}" />
			</br>
			<form:label path="category_description" for="category_description">Category Description:</form:label>
			<form:input type="text" path="category_description" class="form-control"
				name="category_description" required="required" placeholder="Enter Description"  value="${des}" />
			</br>
			<input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>
		</br>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Category Name</th>
					<th>Category Description</th>
					<th>Edit</th>
                    <th>Delete</th> 
				</tr>
			</thead>

			<c1:forEach items="${add}" var="list">
				<tr>
					<td><a href="#">${list.getCategory_name()}</a></td>
					<td><a href="#">${list.getCategory_description()}</a></td>
					<%--       <td><a href="cdelete/${list.category_id}"><span class="label label-default">Delete</span></a></td> --%>
					<td><a
						href='<c:url value="cedit/${list.category_id}"></c:url>'>Edit</a></td>
					<td><a
						href='<c:url value="cdelete/${list.category_id}"></c:url>'>Delete</a></td>
					<!--       <td><button type="button" class="btn btn-success">Edit</button>/<button type="button" class="btn btn-danger">Delete</button> -->
					<%--     <td><a href="category/delete/${list.id}"><span class="glyphicon glyphicon-trash"></span></a> --%>
					<!--     </td> -->
				</tr>
			</c1:forEach>
		</table>
	</div>
</body>
</html>