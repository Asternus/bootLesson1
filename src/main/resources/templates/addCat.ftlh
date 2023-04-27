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

<form id="studentForm" onsubmit="submitForm(); return false;">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br>
    <button type="submit">Submit</button>
</form>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function submitForm() {
        var formData = {
            "name": $("#name").val(),
            "email": $("#email").val()
        };

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/categories",
            data: JSON.stringify(formData),
            dataType: "json",
            success: function (data) {
                alert("Form data saved successfully!");
            },
            error: function (error) {
                alert("Error saving form data.");
            }
        });
    }
</script>

</body>
</html>