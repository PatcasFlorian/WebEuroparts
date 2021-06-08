<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body >
<h1><a href="new-admin.htm">New User</a></h1>

<table>
<thead>
<tr>
              <th>NR.</th>
              <th>Nume</th>
              <th>PhoneNumber</th>
</tr>
</thead>
<tbody>
          <c:forEach var="categorie" items="${model.listUsr }"> 
      <tr> 
     <td style="color: Red" ><c:out value="${categorie.id}"></c:out></td>  
       <td style="color: Green"><c:out value="${categorie.fullName}"></c:out></td>
       <td style="color: Green"><c:out value="${categorie.phoneNumber}"></c:out></td>
       <td>
        
            </tr>
        </c:forEach>
          </tbody>

</table>


</body>
</html>