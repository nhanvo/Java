<#-- @ftlvariable name="currentUser" type="org.nhanvo.shopdemo.model.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
</head>
<body>
<nav role="navigation">
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
    </#if>
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <button type="submit">Log out</button>
            </form>
        </li>  
        <li><a href="/product/create">Create a new product</a></li>     
        <li><a href="/products">View all products</a></li>
        <li><a href="/userinformation">View All User</a></li>
    </#if>
       
    </ul>
</nav>
</body>
</html>