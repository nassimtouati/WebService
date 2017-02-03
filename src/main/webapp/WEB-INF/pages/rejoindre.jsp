<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subscribe to a groupe </title>
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
<table id="table" border=1>
            <tr> <th> Name </th> <th> admin </th> <th> description </th> <th> Members </th> </tr>
            
             <c:forEach items="${groupe}" var="groupe">
                    <tr>
                        <td><c:out value="${groupe.name}"/></td>
                        <td><c:out value="${groupe.admin}"/></td>
                        <td><c:out value="${groupe.description}"/></td>
                        
                        <td>
                            <c:url value="souscrire" var="url">
                                <c:param name="idGroupe" value="${groupe.name}"/>
                            </c:url>
                            <a href="${url}">
                              Join
                            </a>
                        </td>
                    </tr>
                </c:forEach>
         
        </table>
             


</body>
</html>