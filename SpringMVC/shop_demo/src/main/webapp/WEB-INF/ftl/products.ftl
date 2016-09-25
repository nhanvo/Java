<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="products" type="java.util.List<org.nhanvo.shopdemo.model.Product>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Products</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>        
    </ul>
</nav>

<h1>List of Products</h1>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Image</th>
        <th>Description</th>
        <th>CreateAt</th>
        <th>UpdateAt</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
    <tr>
        <td><a href="/product/${product.id}">${product.name}</td>
        <td>${product.image}</td>
        <td>${product.description}</td>
        <td>${product.createdAt}</td>
        <td>${product.updateAt}</td>
        <td><a href="/product/edit/${product.id}">Edit</a></td>
        <td>
            <form role="form" name="form" action="/product/delete/${product.id}">
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>