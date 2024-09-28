<%@page import="com.dto.Branch"%>
<%@page import="com.dao.BrachDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update branch</title>
</head>
<body>

<%

int bracnchId=Integer.parseInt(request.getParameter("id"));
//fetch branch Based on id
BrachDao dao=new BrachDao();
Branch branch=dao.findBranchById(bracnchId);
%>

<form action="updateBranch">

<fieldset>
<legend>UPDATE BRANCH</legend>

id:<input type="text" name="id" value="<%=branch.getId()%>" readonly="readonly"><br><br>
branchName:<input type="text" name="bn" value="<%=branch.getBranchname()%>"><br><br>
address:<input type="text" name="address" value="<%=branch.getAddress()%>"><br><br>
phoneNumber:<input type="tel" name="mob" value="<%=branch.getPhonenumber()%>"><br><br>

<input type="submit" value="UPDATE BRANCH">
<input type="reset" value="CANCEL">

</fieldset>
<a href="logout"><button>ADMIN LOGOUT</button> </a>
<a href="userSignup.jsp"><button>HOME</button> </a>
</body>
</html>