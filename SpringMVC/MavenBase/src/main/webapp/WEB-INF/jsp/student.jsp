<%-- 
    Document   : student
    Created on : 16.2.2016, 13:54:07
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
        <title>Student</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <h1>Add new student information</h1>
                    <form:form action="/admin/addstudent" method="POST" modelAttribute="student">
                        <form:label path="">Name</form:label><br/>
                        <form:input cssClass="form-control" path="SName"></form:input><br/>
                        <form:label path="">Email</form:label><br/>
                        <form:input cssClass="form-control" path="email"></form:input><br/>
                        <form:label path="">Phone</form:label><br/>
                        <form:input cssClass="form-control" path="phone"></form:input><br/>
                        <form:label path="">Address</form:label><br/>
                        <form:input cssClass="form-control" path="address"></form:input><br/>
                        <input class="btn btn-primary" type="submit" value="Save Student"/>
                    </form:form>
                    <p>${save_info}</p>
                </div>
                <div class="col-md-6 col-md-offset-1">
                    <h1>All students</h1>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="stud" items="${students}">
                                <tr>
                                    <td>${stud.getSName()}</td>
                                    <td>${stud.getEmail()}</td>
                                    <td>${stud.getPhone()}</td>
                                    <td>${stud.getAddress()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
