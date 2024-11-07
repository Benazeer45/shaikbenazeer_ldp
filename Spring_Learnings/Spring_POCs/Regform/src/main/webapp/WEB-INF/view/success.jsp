<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Success</title>
</head>
<body>
    <h1>Form Submitted Successfully!</h1>
    <p>Email: ${email}</p>
    <p>Username: ${username}</p>
    <p>Selected Option: ${dropdownOption}</p>
    <p>Gender: ${gender}</p>
    <p>Subscribed to Newsletter: ${subscribe != null ? 'Yes' : 'No'}</p>
</body>
</html>
