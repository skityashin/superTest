<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<script src="http://code.jquery.com/jquery-1.8.3.js"></script>


<c:forEach var="books" items="${books}">
    <table id="ttt" border="1px" style="color: black">
        <tr>
            <td align="center">Title: ${books.title}</td>
        </tr>
        <tr>
            <td align="center">Id_books: ${books.id_books}</td>
        </tr>
        <tr>
            <td align="center">Author: ${books.author}</td>
        </tr>
        <br>
    </table>
</c:forEach>


