<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<form method="post" action="/table">
    <input placeholder="Enter name" type="text" name="name">
    <input placeholder="Enter Last name" type="text" name="lastName">
    <input placeholder="Enter Middle name" type="text" name="middleName">
    <input type="date" name="date">
    <select name="gender">
        <option selected value="">Select gender</option>
        <option value="female">Female</option>
        <option value="male">Male</option>
    </select>
    <input type="submit" value="Send">
</form>
</body>
</html>