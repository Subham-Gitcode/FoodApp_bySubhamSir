<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<form action="userlogin">
<fieldset>

<legend>LOGIN PAGE</legend>

username:<input type="email" name="email"><br><br>
password:<input type="password" name="pass"><br><br>
<input type="submit" value="LOGIN">
<input type="reset" value="CANCEL">

</fieldset>
</form>
<a href="userSignup.jsp"><button>HOME</button> </a>
</body>
</html>