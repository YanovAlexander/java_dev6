<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
     <c:import url="${contextPath}/WEB-INF/jsp/navigation.jsp"/>
        <form action="/books">
            <label for="name"> Book name: </label><br>
            <input type="text" id="bookName" name="bookName"><br>
            <button type="submit">Find</button>
        </form>
        <table>
            <thead>
                <c:if test="${not empty books}">
                    <tr>
                        <td style="text-align: center">Book name:</td>
                        <td style="text-align: center">Count pages:</td>
                        <td style="text-align: center">Authors:</td>
                    </tr>
                </c:if>
                <c:if test="${empty books}">
                    <p>There is not books by specified name</p>
                </c:if>
            </thead>
            <tbody>
                <c:forEach var = "book" items="${books}">
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
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>