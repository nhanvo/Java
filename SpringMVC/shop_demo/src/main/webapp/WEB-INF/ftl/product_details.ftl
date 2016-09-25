<#-- @ftlvariable name="product" type="org.nhanvo.shopdemo.model.Product" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Product details</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/products/">Back</a></li>
    </ul>
</nav>

<h1>Product details</h1>

<p>Name: ${product.name}</p>

<p>Image: ${product.image} </p>

<p>Description: ${product.description} </p>

<p>Create At: ${product.createdAt}</p>

<p>Update At: ${product.updateAt}</p>

</body>
</html>