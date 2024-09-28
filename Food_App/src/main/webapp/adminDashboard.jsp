<%@page import="com.dto.Branch"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin dashboard</title>
</head>
<body>

	<!-- java code  -->
	<%
	List<Branch> listOfBranch = (List<Branch>) session.getAttribute("list");
	User admin = (User) session.getAttribute("admin");
	%>

	<!-- HTML code -->
	<h1><%=admin.getId()%>
		ID ADMIN LOGIN
	</h1>
	<table border="1px solid" cellspacing="5px" cellpadding="5px"
		width="100%">
		<tr>

			<th>S.NO</th>
			<th>B_ID</th>
			<th>B_NAME</th>
			<th>B_ADDRESS</th>
			<th>B_PHONE_NUMBER</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>

		<!-- java code -->

		<%
		int i = 1;
		for (Branch b : listOfBranch) {
		%>

		<tr>
			<td><%=i++%></td>
			<td><%=b.getId()%></td>
			<td><%=b.getBranchname()%></td>
			<td><%=b.getAddress()%></td>
			<td><%=b.getPhonenumber()%></td>
			<td><a href="updateBranch.jsp?id=<%=b.getId()%>"><button>UPDATE</button>
			</a></td>
			<td><a href="deleteBranch?id=<%=b.getId()%>"><button>DELETE</button>
			</a></td>
		</tr>

		<%
		}
		%>


	</table>


	<a href="createbranch.jsp">AddBranch</a>
	<a href="logout"><button>ADMIN LOGOUT</button> </a>
	<a href="userSignup.jsp"><button>HOME</button> </a>
	

</body>
</html>