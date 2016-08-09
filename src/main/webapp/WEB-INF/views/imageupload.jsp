<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Image Upload</title>
</head>
<body>
	<form method="POST" action="imageupload"  enctype="multipart/form-data">
		File to upload: <input type="file" name="file">
 
		Image: <input type="text" name="image">
 
 
		<input type="submit" value="ImageUpload"> upload image!
		<td>${image}</td>
	</form>	
</body>
</html>
