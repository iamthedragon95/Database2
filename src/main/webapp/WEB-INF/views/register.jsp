<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<h1>Registration Form</h1>
	<br />
	<form:form modelAttribute="rege" action="fregister" method="POST">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td> Name :</td>
				<td><form:input type="text" path="name"/></td>
			</tr>
			
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><form:input path="mobilenumber" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td>Reenter Password :</td>
				<td><form:input path="confirmpassword" /></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>