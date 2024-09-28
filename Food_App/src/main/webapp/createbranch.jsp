<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="createbranch">

<fieldset>
<legend>CREATE BRANCH</legend>

branchName:<input type="text" name="bn"><br><br>
address:<input type="text" name="address"><br><br>
phoneNumber:<input type="tel" name="mob"><br><br>
<input type="submit" value="CREATE BRANCH">
<input type="reset" value="CANCEL">

</fieldset>


</form>
<a href="userSignup.jsp"><button>HOME</button> </a>
</body>
</html>