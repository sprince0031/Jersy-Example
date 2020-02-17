<html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myres">Jersey resource</a>
    <p>Hello there! Testing maven tomcat plugin for deploying!</p>
    <p><a href="webapi/myres/Sprince0031">Click this to see use of URL parameters.</a></p><br>
    <form action="webapi/product/add" method="post">
        Product Id: <input type="text" name="id"><br>
        Product Name: <input type="text" name="name"><br>
        Price: <input type="text" name="price"><br>
        <input type="submit" value="Add Product">
    </form><br>
    <form action="webapi/myres/joke/random" method="get">
        <input type="submit" value="Get Random Joke!">
    </form>
</body>
</html>
