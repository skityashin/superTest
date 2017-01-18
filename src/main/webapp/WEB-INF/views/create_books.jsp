<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div>
    <form action="/books/create" method="post" id="create-books">
        <table border="1px" style="color: black">
            <tr>
                <td  align="center" >title:</td>
                <td  align="center" ><input type="text" value="" name="title"></td>
            </tr>
            <tr>
                <td  align="center" >id_books:</td>
                <td  align="center" ><input type="text" value="" name="id_books"></td>
            </tr>
            <tr>
                <td  align="center" >author:</td>
                <td  align="center" ><input type="text" value="" name="author"></td>
            </tr>
            <tr >
                <td rowspan="4" align="center" > <input type="submit"></td>
            </tr>
        </table>
    </form>
</div>
