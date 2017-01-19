<jsp:useBean id="author" scope="request" type="javax.xml.stream.util.StreamReaderDelegate"/>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<table border="1px" style="color: black">
    <tr>
        <td  align="center">name:</td>
        <td align="center">${author.name}</td>
    </tr>
    <tr>
        <jsp:useBean id="books" scope="request" type="java.util.List"/>
        <c:forEach var="books" items="${books}">
            <table border="1px" style="color: black">
                <tr>
                    <td  align="center">books:</td>
                    <td align="center"> ${books}</td>
                </tr>
            </table>
        </c:forEach>
    </tr>
</table>



