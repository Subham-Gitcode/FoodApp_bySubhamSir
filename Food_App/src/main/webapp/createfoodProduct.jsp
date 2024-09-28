<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>food Product</title>
</head>
<body>

<form action="createFoodProduct">

<fieldset>

<legend>FOOD PRODUCT</legend>
name:<input type="text" name="name"><br><br>
type:<input type="radio" name="type" value="veg">VEG
<input type="radio" name="type" value="non_veg">NON VEG<br><br>
about<input type="text" name="about"><br><br>
price:<input type="text" name="price"><br><br>

<input type="submit" value="CREATE FOOD PRODUCT">
<input type="reset" value="CANCEL">

</fieldset>


</form>

</body>
</html>