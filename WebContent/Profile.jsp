<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script language="javascript">
function updateRecord(){
   
    var f=document.form;
    f.method="post";
    f.action='EditProfileServlet.do'; //?user='+user;                // 'edit.jsp?id='+userid;
    f.submit();
}
</script>

</head>
<body>
<form name=form >

<h1>  profile page here </h1>
 
<c:if test="${requestScope.status eq 'Success'}"> 

<table border=2>
    
    <tr><td>First name</td><td><input type=text name=id value=${user.userid}></td></tr>
	<tr><td>First name</td> <td><input type="text" name="Fname" value=${user.firstname}></td></tr>
	<tr><td>Last name </td> <td><input type="text" name="Lname" value=${user.lastname}></td></tr>
	<tr><td>Email ID </td> <td><input type="text" name="Email" value=${user.email}></td></tr>
	<tr><td>DOB</td> <td><input type="text" name="Dob" value=${user.dob}></td></tr>
	<tr><td>City</td> <td><input type="text" name="City" value=${user.city}></td></tr>
	<tr><td>State</td> <td><input type="text" name="State" value=${user.state}></td></tr>
	<tr><td>Country</td> <td><input type="text" name="Country" value=${user.country}></td></tr>
	<tr>
	  <td><input type="button" name="update" value="Update" style="background-color:#49743D;font-weight:bold;color:#ffffff;" onclick="updateRecord();"></td> 
	  <td><input type="button" name="cancle" value="Cancle" style="background-color:#49743D;font-weight:bold;color:#ffffff;"  onclick="#"></td>     
	</tr>
</table>

</c:if>

<c:if test="${requestScope.status eq 'Fail'}">
    <h1> No data Found </h1>
</c:if>

</form>
</body>
</html>