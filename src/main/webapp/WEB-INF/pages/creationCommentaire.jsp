<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Add Comment</title>
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
        <form:form method="post" modelAttribute="creationCommentaire" action="ajouterCommentaire">
           group   
          <form:input  path="group_name" value="${groupe_name}" /> 
         
            user 
            <input path="name_memeber" value="${user}"/>
            
             Commentaire  
            
          <form:input path="commentaire"/> 
            
            <input type="submit"/>
        
        <table border="1">
            <thead>
                <tr>
                    <th>user</th>
                    <th>group</th>
                    <th>comment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lListeComm}" var="commentaire">
                    <tr>
                        <td><c:out value="${commentaire.auteur}"/></td>
                        <td><c:out value="${commentaire.groupe}"/></td>
                        <td><c:out value="${commentaire.content}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </form:form>
    </body>
</html>