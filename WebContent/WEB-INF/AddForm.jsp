<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
	<form action="/demo/add_book" method="post">
	Book Title: <input type="text" name="bookName" required> <br>
	Year of publication: <input type="text" name="bookYear" required> <br>
	<input type="submit" value="Add a new book">
	</form>
</body>
</html>