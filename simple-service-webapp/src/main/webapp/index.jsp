<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jersey RESTful Web Application!</title>

    <!-- jQuery import -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    
</head>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="rest/myres">Jersey resource</a>
    <p>Hello there! Testing maven tomcat plugin for deploying!</p>
    <p><a href="rest/myres/Sprince0031">Click this to see use of URL parameters.</a></p><br>
    <form id="product-add" accept-charset="UTF-8">
        Product Name: <input type="text" name="name" id="name"><br>
        Price: <input type="text" name="price" id="price"><br>
        <input type="button" value="Add Product" onclick="addAuthHeaderAndSubmit()">
    </form>
    <script>
        function addAuthHeaderAndSubmit() {
            let url = "rest/product/add";
            let username = "admin";
            let password = "admin";
            let name = document.getElementById("name").value;
            let price = document.getElementById("price").value
            $.ajax({
                type: "POST",
                url: url,
                headers: {
                    "Authorization": "Basic " + btoa(username+":"+password),
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                data: {
                    name: name,
                    price: price
                },
                success: function(data, status) {
                    console.log("Data: " + data + "\nStatus: " + status);
                    alert("Product, " + name + " with price " + price + " has been added!");
                }
            });
        }
    </script>
</body>
</html>
