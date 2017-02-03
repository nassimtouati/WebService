<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
 font-size: 20px;
 color: teal;
 font-family: Calibri;
}

td {
 font-size: 15px;
 color: black;
 width: 100px;
 height: 22px;
 text-align: left;
}

.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}
</style>
<body>
<%@ include file="MenuGroupes.jsp" %>

<table  class="table table-striped">
                      <thead>
                        <tr>
                         
                          <th>Name</th>
                          
                          <th>Description</th>
						  <th> add comment </th>
                        </tr>
                      </thead>
                      <tbody >
                        <c:forEach items="${groupe}" var="group">
                    <tr>
                       <td><c:out value="${group.name}"/></td>
                       
                        <td><c:out value="${group.description}"/></td>
                       
                        <td>
                            <c:url value="afficherCommentaire" var="url">
                                <c:param name="idGroupe" value="${group.name}"/>
                            </c:url>
                            <a href="${url}">
                              ajouter commentaire
                            </a>
                        </td>

                    </tr>
                </c:forEach>
                      </tbody>
                    </table>

</body>
</html>