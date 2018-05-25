<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Librarians</title>
</head>
<body>
<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Password</th>
									<th>City</th>
									<th>Contact Number</th>
									<!-- <th>Action</th> -->
								</tr>
							</thead>
							<tbody>


								<c:forEach var="row" items="${LibrariansList}">
								<tr>
									<td><c:out value="${row.name}" /></td>
									<td><c:out value="${row.password}" /></td>
									<td><c:out value="${row.city}" /></td>
									<td><c:out value="${row.cnumber}" /></td>	
									
										</tr>
								</c:forEach>
							</tbody>
						</table>

</body>
</html>