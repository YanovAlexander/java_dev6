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
        <form action="/books" method="post">
            <label for="bookName"> Book name: </label><br>
            <input type="text" id="bookName" name="bookName"><br>
            <label for="countPages"> Count pages: </label><br>
            <input type="number" id="countPages" name="countPages"><br>
            <select name='authorId'>
                <c:forEach items="${authors}" var="author">
                    <option value="${author.id}">${author.firstName} ${author.lastName}</option>
                </c:forEach>
            </select><br>
            <button type="submit">Create book</button>
        </form>
    </body>
</html>