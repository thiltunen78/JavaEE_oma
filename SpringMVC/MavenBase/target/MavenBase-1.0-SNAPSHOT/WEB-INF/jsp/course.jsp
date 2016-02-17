<%-- 
    Document   : course
    Created on : 17.2.2016, 12:40:23
    Author     : Tero
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" />
        <title>Course</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <h1>Add new course information</h1>
                    <form:form action="/admin/addcourse" method="POST" modelAttribute="course">
                        <form:label path="">Name</form:label><br/>
                        <form:input cssClass="form-control" path="CName"></form:input><br/>
                        <form:label path="">Grade</form:label><br/>
                        <form:input cssClass="form-control" path="grade"></form:input><br/>
                        <form:label path="">Info</form:label><br/>
                        <form:input cssClass="form-control" path="CInfo"></form:input><br/>                        
                        <input class="btn btn-primary" type="submit" value="Save Course"/>
                    </form:form>
                    <p>${save_info}</p>
                </div>
                <div class="col-md-6 col-md-offset-1">
                    <h1>All courses</h1>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Grade</th>
                                <th>Info</th>                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cour" items="${courses}">
                                <tr>
                                    <td>${cour.getCName()}</td>
                                    <td>${cour.getGrade()}</td>
                                    <td>${cour.getCInfo()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
