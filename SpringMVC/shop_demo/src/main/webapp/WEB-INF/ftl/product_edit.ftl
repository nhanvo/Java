<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="product" type="org.nhanvo.shopdemo.model.Product" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Edit product</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Edit product</h1>

<form role="form" name="editProductForm" action="/product/edit/${product.id}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${product.name}" required autofocus/>
    </div>
    <div>
        <label for="image">Image</label>
        <input type="text" name="image" id="image" value = "${product.image}" required/>
    </div>
    <div>
        <label for="description">Description</label>
        <input type="text" name="description" id="description" value = "${product.description}" required/>
    </div>
    <div>
        <label for="createdat">Create At</label>
        <input type="text" name="createdat" id="createdat" value = "${product.createdAt}" required/>
    </div>

    <div>
        <label for="updateat">Update At</label>
        <input type="text" name="updateat" id="updateat" value = "${product.updateAt}" required/>
    </div>

    <button type="submit">Save</button>
</form>

</body>
</html>