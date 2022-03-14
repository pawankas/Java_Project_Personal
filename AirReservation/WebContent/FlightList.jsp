<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Flight Reservation System</title>
</head>
<body>
    <center>
        <h1>Flight Management</h1>
        <h2>
            <a href="/new">Add New Flight</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Flights</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Flights</h2></caption>
            <tr>
                <th>Flight Id</th>
                <th>Flight Name</th>
                <th>Flight Number</th>
                <th>Destination</th>
                <th>No of Stops</th>
            </tr>
          <c:forEach var="flight" items="${FlightList}">

                                <tr>
                                    <td>
                                        <c:out value="${flight.flightId}" />
                                    </td>
                                    <td>
                                        <c:out value="${flight.flightName}" />
                                    </td>
                                    <td>
                                        <c:out value="${flight.flightNumber}" />
                                    </td>
                                    <td>
                                        <c:out value="${flight.destination}" />
                                    </td>
                                    <td>
                                        <c:out value="${flight.noOfStops}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
          
            
        </table>
    </div>   
</body>
</html>