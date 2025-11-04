<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Category Form</title>
</head>
<body>
    <h2>Create Course Category</h2>

    <form action="${pageContext.request.contextPath}/submitCourseCategory" method="POST">
        <label for="name">Category Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label for="description">Description:</label><br>
        <textarea name="description" rows="4" cols="50" required></textarea><br><br>

        <input type="submit" value="Submit">
    </form>

</body>
</html>