<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<c:url value="/resources/css" var="css" />
<c:url value="/resources/js" var="js" />
<c:url value="/resources/img" var="img" />
<title>Carousal Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<script src="${js}/jquery.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<link rel="stylesheet" href="${css}/font-awesome.min.css">

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>
</head>
<body>
	<%--  <img src="${img}/image5.jpg" width="1800" height="150"> --%>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/"/>"><img
					src="${img}/icon3.jpg" width="100" height="50"></a> <a
					class="navbar-brand" href="<c:url value="/"/>">MusicMainee</a>
			</div>

			<div class="collapse  navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li class="active"><a href="<c:url value="/addcategory"/>">AddCategory</a></li>
						<li><a href="<c:url value="/addproduct"/>">Add Product</a></li>
						<li><a href="<c:url value="/addsupplier"/>">Add Supplier</a></li>
					</security:authorize>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<%--     <c:if test="${s==null}"> --%>
					<%--       <li><a href="<c:url value='/signup'/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>               --%>
                    <%--       <li><a href="<c:url  value='/login'/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> --%>
					<%--     </c:if> --%>

					<c1:if test="${pageContext.request.userPrincipal.name ==null }">
						<c:url value="/login" var="login"></c:url>
						<li><a href="${login}"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
						<c:url value="/signup" var="url"></c:url>
						<li><a href="${url}"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					</c1:if>


					<%--     <c1:if test="${s==true}"> --%>
					<c1:if test="${pageContext.request.userPrincipal.name!=null}">
						<%--     <li><a>Welcome ${pageContext.request.userPrincipal.name }</a></li> --%>
						<li>
						<a href="<c:url value="/j_spring_security_logout"></c:url>">Logout</a>
<%-- 							<a href="<c:url value="/logout"></c:url>">logout</a> --%>
							<!-- 			<li><a href="#" class="btn btn-primary" style="color:Black">Cart<span class="badge">1</span></a></li> -->
					</c1:if>
					<security:authorize access="hasRole('ROLE_USER')">
						<li><a href="<c:url value="/cart"></c:url>"> Cart</a></li>
					</security:authorize>

					<%--     <li><a href="<c:url  value='/logout'/>"><c1:out value="${username}"></c1:out> <span class="glyphicon glyphicon-log-in"></span> Logout</a></li> --%>
					<!--     <li><a href="cart"><span class="glyphicons glyphicons-shopping-cart"></span>MyCart</a></li> -->

					<%--     </c1:if> --%>
				</ul>
				</ul>
				</ul>
			</div>
		</div>

	</nav>
</body>
</html>