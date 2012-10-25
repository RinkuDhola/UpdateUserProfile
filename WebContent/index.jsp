<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script language="javascript">
function viewProfile(){
    //alert("in function");
    var f=document.form;
    f.method="post";
    f.action='ViewProfileServlet.do';                // 'edit.jsp?id='+userid;
    f.submit();
}
function viewInterest(){
    var f=document.form;
    f.method="post";
    f.action='ViewInterestServlet.do';                // 'edit.jsp?id='+userid;
   
    f.submit();
}

</script>



</head>
<body>
<form name=form >
<table>
	<tr>
		<td>User ID </td>
		<td><input type=text name=id value=""></td>
	</tr>
	<tr>
		<td><input type=button name=profile value="View Profile" style="background-color:#49743D;font-weight:bold;color:#ffffff;"  onclick="viewProfile();"></td>  
		<td><input type="button" name="interest" value="ViewInterestList" style="background-color:#49743D;font-weight:bold;color:#ffffff;"  onclick="viewInterest();"></td>  
	</tr>
</table>
</form>
</body>
</html>