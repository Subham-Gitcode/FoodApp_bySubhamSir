<%@page import="com.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	User admin = (User) session.getAttribute("admin");
	if (admin != null) {
	%>

	<a href="createbranch.jsp"><button>CREATE BRANCH</button> </a>
	<a href="findAllBranch"><button>FIND ALL</button> </a>
	<a href="logout"><button>ADMIN LOGOUT</button> </a>
	<a href="userSignup.jsp"><button>HOME</button> </a>

	<%
	} else {
		
	response.getWriter().print("<h1>DO LOGIN FIRST</h1>");
	request.getRequestDispatcher("login.jsp").include(request, response);
	
	}
	%>



</body>
</html>