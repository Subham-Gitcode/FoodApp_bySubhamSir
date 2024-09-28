<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user Signup page </title>
</head>
<body>


<form action="userSignup">

<fieldset>

<legend>User Signup</legend>
name:<input type="text" name="name"><br><br>
email:<input type="email" name="email"><br><br>
password:<input type="password" name="pass"><br><br>
role:<input type="radio" name="role" value="admin">Admin
<input type="radio" name="role" value="branchmanager">Branch Manager
<input type="radio" name="role" value="staff">Staff<br><br>

<input type="submit" value="SIGNUP">
<input type="reset" value="CANCEL">

</fieldset>

</form>

<p>Already Having Account?<a href="login.jsp">Login Now</a></p>



</body>
</html>