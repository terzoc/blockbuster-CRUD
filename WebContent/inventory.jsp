<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>blockbuster</title>
  </head>
  <body>
    <div>
      <h1>Inventory Management</h1>
      <h2><a href="/movies">View All</a></h2>
    </div>
    <div>
      <table border="1">
        <caption>All Movies in Collection</caption>
        
        <tr>
          <td>Title</td>
          <td>Length</td>
          <td>Copies</td>
          <td>Available</td>
        </tr>
        <c:forEach var="movie" items="${movies}">
          <tr>
            <td><c:out value="${movie.title}" /></td>
            <td><c:out value="${movie.legnth}" /></td>
            <td><c:out value="${movie.copies}" /></td>
            <td><c:out value="${movie.available}" /></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>