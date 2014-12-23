<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
hello, <c:choose><c:when test="${name==null}">there</c:when><c:otherwise><c:out value="${name}"></c:out></c:otherwise></c:choose>!
</body>
</html>
