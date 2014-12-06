<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Students</title>
</head>
<body bgcolor="#E6E6FA">

<div >
<div >
<h4>List Of All Students Ids</h4>
<ul>
<c:forEach var="option" items="${idList}" >
<li><a href="driver?act=${option}">
<c:out value="${option}"/></a></li>
</c:forEach>
</ul>
</div>
<div >
<div >
<h1>Student Information Page</h1>
<h4>Username: ${st.name}</h4>
<h4>Student ID: ${st.studentId}</h4>
<table border="1">
<tr>

<th>street address</th>
<th>city</th>
<th>state</th>
<th>zip</th>
<th>telephone</th>
<th>email</th>

</tr>
<tr>

<td>${st.address}</td>
<td>${st.city}</td>
<td>${st.state}</td>
<td>${st.zip}</td>
<td>${st.tel}</td>
<td>${st.email}</td>
</tr>
</table>
<br>
<table border="1">
<tr>


<th>dateOfSurvey</th>
<th>Grad Month/Year</th>
<th>likedAboutCampus</th>
<th>Interests</th>
</tr>
<tr>


<td>${st.dates}</td>
<td>${st.graduationMonth}</td><td>
<c:forEach var="option" items="${st.like}" >
${option}
</c:forEach>
</td>
<td>${st.how}</td>
</tr>
</table>
<br/>
<table border="1">
<tr>

<th>likely hood Of Recommendation</th>
<th>data statistics</th>
<th>comments</th>
</tr>
<tr>


<td>${st.recommendation}</td>
<td>${st.data}</td>
<td>${st.comment}</td>
</tr>
</table>

<br/>
<a href="Survey.jsp">Return to Survey Form.</a>
</div> 
</div> 
</div> 	

</body>
</html>