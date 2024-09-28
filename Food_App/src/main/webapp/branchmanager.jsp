<%@page import="com.dao.BrachDao"%>
<%@page import="com.dto.Branch"%>
<%@page import="java.util.List"%>
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
	User branchmanager = (User) session.getAttribute("branchmanager");
	List<Branch> list = branchmanager.getBranchs();

	int id=0;
	if (list.isEmpty()) {
		BrachDao dao = new BrachDao();
		List<Branch> listOfBranch = dao.findAllBranch();
		
	%>
	<h2>TAKE BRANCH</h2>

	<!-- display branch -->

	<table border="1px solid" cellspacing="5px" cellpadding="5px"
		width="100%">
		<tr>

			<th>S.NO</th>
			<th>B_ID</th>
			<th>B_NAME</th>
			<th>B_ADDRESS</th>
			<th>B_PHONE_NUMBER</th>
			<th>TAKE BRANCH</th>
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
			<td><a href="takeBranchAsBranchManager?id=<%=b.getId()%>"><button>TAKE</button></a>
			</td>
		</tr>

		<%
		}
		%>


	</table>


	<%
	} else {
	
	for (Branch b : list) {
		for (User u : b.getUsers()) {
			if (u.getId() == branchmanager.getId())
		id = b.getId();
		}
	}
	%>
	<!-- Your  Branch Id is -->
	<h1>
		YourBRANCH iD iS
		<%=id%></h1>


	<%
	}
	%>


	<a href="crerateMenu?id=<%=id%>"><button>CREATE MENU</button></a>

</body>
</html>