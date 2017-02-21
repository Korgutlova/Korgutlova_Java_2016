<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>
<form method="post" action="/result">
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
<c:choose>
    <c:when test="${result != null}">
        <h3>${result}</h3>
    </c:when>
</c:choose>
</body>
</html>
