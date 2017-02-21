<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Table</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Last name</th>
        <th>Middle name</th>
        <th>Date</th>
        <th>Gender</th>
    </tr>
    <c:forEach items="${list}" var="human">
        <tr>
            <c:choose>
                <c:when test="${human.name != '' && human.lastName != '' && human.middleName != ''}">
                    <td>${human.name}</td>
                    <td>${human.lastName}</td>
                    <td>${human.middleName}</td>
                    <td>${human.date}</td>
                    <td>
                        <c:choose>
                            <c:when test="${human.gender == ''}">
                                -
                            </c:when>
                            <c:otherwise>
                                ${human.gender}
                            </c:otherwise>
                        </c:choose>
                    </td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
</table>
<br><hr>
<a href="/index">Main page</a>
</body>
</html>
