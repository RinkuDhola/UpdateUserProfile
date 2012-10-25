<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script language="javascript">
function removeInterest(){
   
    var f=document.form;
    f.method="post";
    f.action='EditInterestServlet.do';
    f.submit();
}
function addInterest()
{
   var f=document.form;
   f.method="post";
   f.action='AddInterestServlet.do';
   f.submit();

}
</script>
</head>

<body>
<form name=form >

<h1>  Interest List page here </h1>

 
<c:if test="${requestScope.status eq 'Success'}"> 
<input type=text name="id" value="${user.userid }">

Interest List :
<table border=2>
    <th>Status</th><th>Interest Name</th><th>Interest Description</th>
    <c:forEach var="interest" items="${requestScope.interests}">
    <tr> <td> <input type="checkbox" name="choice" value="${interest.interestid}"></td>
         <!-- <td><c:out value="${interest.interestid}"> </c:out></td> -->
         <td> <c:out value="${interest.name}"></c:out></td>
         <td><input type="text" name="Descriptionname" value=${interest.description}></td>
    </tr>    
   </c:forEach>	
</table>
<table>
	  <tr>
	  <td><input type="button" name="remove" value="Remove Selected" style="background-color:#49743D;font-weight:bold;color:#ffffff;" onclick="removeInterest();"></td> 
	  <td><input type="button" name="cancle" value="Cancle" style="background-color:#49743D;font-weight:bold;color:#ffffff;"  onclick="#"></td>     
	  </tr>
</table>

Not Interest List :
<table border=2>
    <th>Status</th><th>Interest Name</th><th>Interest Description</th>
    <c:forEach var="Ninterest" items="${requestScope.Ninterests}">  
    <tr> <td> <input type="checkbox" name=Nchoice value="${Ninterest.interestid}"></td>
         <!-- <td><c:out value="${Ninterest.interestid}"> </c:out></td> -->
         <td> <c:out value="${Ninterest.name}"></c:out></td>
         <td><input type="text" name="Descriptionname" value="${Ninterest.description}"></td>
    </tr>    
   </c:forEach>
</table>
<table>
	  <tr>
	  <td><input type="button" name="add" value="Add Selected" style="background-color:#49743D;font-weight:bold;color:#ffffff;" onclick="addInterest()"></td> 
	  <td><input type="button" name="cancle" value="Cancle" style="background-color:#49743D;font-weight:bold;color:#ffffff;"  onclick="#"></td>     
	  </tr>
</table>

</c:if>
<c:if test="${requestScope.status eq 'Costrain'}">
    <h1>  at least one interest sould be there </h1>
</c:if>

<c:if test="${requestScope.status eq 'Fail'}">
    <h1> no data found  </h1>
</c:if>

</form>

</body>
</html>