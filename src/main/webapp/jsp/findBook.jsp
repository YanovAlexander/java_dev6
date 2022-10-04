<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="#">Library</a>
            </div>
            <ul class="nav navbar-nav">
              <li class="active"><a href="/">Home</a></li>
              <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Books <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="/books/form">Find book</a></li>
                  <li><a href="#">Page 1-2</a></li>
                  <li><a href="#">Page 1-3</a></li>
                </ul>
              </li>
              <li><a href="#">Authors</a></li>
              <li><a href="#">Journals</a></li>
            </ul>
          </div>
        </nav>
        <form action="/books">
            <label for="name"> Book name: </label><br>
            <input type="text" id="bookName" name="bookName"><br>
            <button type="submit">Find</button>
        </form>

        <table>
            <thead>
                <tr>
                    <td style="text-align: center">Book name:</td>
                    <td style="text-align: center">Count pages:</td>
                    <td style="text-align: center">Authors:</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${book.name}"/>
                    </td>
                    <td>
                        <c:out value="${book.countPages}"/>
                    </td>
                    <td>
                         <c:forEach var = "author" items="${book.authors}">
                             <a href="#"><c:out value = "${author.firstName}"/> <c:out value = "${author.lastName}"/></a>
                         </c:forEach>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>