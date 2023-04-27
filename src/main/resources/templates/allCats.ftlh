<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>


<form method="post" action="/add">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name"><br>
    <#if errors??>
        <div class="invalid-feedback">
            ${errors}
        </div>
    </#if>
    <label for="email">Email:</label>
    <input type="email" name="email" id="email"><br>
    <#if emailError??>
        <div class="invalid-feedback">
            ${emailError}
        </div>
    </#if>
    <input type="submit" value="Add">
</form>

</body>
</html>