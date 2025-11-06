<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Category Form</title>
</head>
<body>
    <h2>Create Course Category</h2>

    <form action="${pageContext.request.contextPath}/admin/category/add" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <label for="name">Category Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label for="description">Description:</label><br>
        <textarea name="description" rows="4" cols="50" required></textarea><br><br>

        <input type="submit" value="Submit">
    </form>

    <table>
    <thead>
    <th>
    <td>Category Name</td>
    <td>Description</td>
    <td>Edit</td>
    <td>Delete</td>
    </th>
    </thead>

    </table>

</body>
</html>