<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Lab2</title>
    <style type="text/css">
        <%@include file="styles/main.css" %>
    </style>
</head>
<body>
<div class="db-div">
    <div>
        <form name="edit" action="http://localhost:8080/edit" method="get">
            <input type="number" placeholder="Company" name="id" value="<%=request.getParameter("id")%>" readonly="readonly"><br>
            <input type="text" placeholder="Company" name="companyName" value="<%=request.getParameter("companyName")%>"><br>
            <input type="text" placeholder="Model" name="model" value="<%=request.getParameter("model")%>"><br>
            <input type="number" placeholder="Price" name="price" value="<%=request.getParameter("price")%>"><br>
            <input class="jsp" type="submit" value="Save">
        </form>
    </div>
</div>
</body>
</html>