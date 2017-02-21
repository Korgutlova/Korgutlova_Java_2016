<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>
<form method="get" action="/calculator">
    <input name="oneArg" type="text"/>
    <select title="Operation" name="operation">
        <option selected value="SUM">+</option>
        <option value="SUB">-</option>
        <option value="MULT">*</option>
        <option value="DIV">/</option>
    </select>
    <input name="twoArg" type="text"/>
    <input type="submit" value="Send"/>
</form>
<#if result??>
    <h3>${result}</h3>
</#if>
</body>
</html