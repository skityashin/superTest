<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<a href='/author/create'>
  <p style="text-align: center"><button class='great_btn'>Create</button> </p>
</a>


<form action="/author/deleteAddress" method="post" id="del-address">
  <p style="text-align: center"><input style="width: 150px" placeholder="Author" name="name">
    <button class='great_btn'>Delete Author</button> </p>
</form>


<form action="/author/deleteBooks" method="post" id="del-books">
  <p style="text-align: center"><input style="width: 150px" placeholder="Books" name="titles">
    <button class='great_btn'>Delete Books</button> </p>
</form>


<form action="/author/searchAuthor" method="get" id="search-author">
  <p style="text-align: center"><input style="width: 150px" placeholder="Author" name="name">
    <button class='great_btn'>Search Author</button></p>
</form>

<form action="/author/searchBooks" method="get" id="search-books">
  <p style="text-align: center"><input style="width: 150px" placeholder="Books" name="titles">
    <button class='great_btn'>Search Books</button></p>
</form>


