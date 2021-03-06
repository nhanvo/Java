<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a new product</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Create a new product</h1>

<form role="form" name="createProductForm" action="" method="post">
    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name" required autofocus/>
    </div>
    <div>
        <label for="image">Image</label>
        <input type="text" name="image" id="image" required/>
    </div>
    <div>
        <label for="description">Description</label>
        <input type="text" name="description" id="description" required/>
    </div>
    <div>
        <label for="createdat">Create At</label>
        <input type="text" name="createdat" id="createdat" required/>
    </div>

    <div>
        <label for="updateat">Update At</label>
        <input type="text" name="updateat" id="updateat" required/>
    </div>

    <button type="submit">Save</button>
</form>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>