<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Category Form</title>
</head>
<body>

    <h2>
        <c:if test="${not empty category}">Update Course Category</c:if>
        <c:if test="${empty category}">Create Course Category</c:if>
    </h2>

    <c:if test="${not empty category}">
        <form action="${pageContext.request.contextPath}/admin/category/update/${category.id}" method="POST">
    </c:if>
    <c:if test="${empty category}">
        <form action="${pageContext.request.contextPath}/admin/category/add" method="POST">
    </c:if>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        <label>Category Name:</label><br>
        <input type="text" name="name" value="${category.name}" required><br><br>

        <label>Description:</label><br>
        <textarea name="description" rows="4" cols="50" required>${category.description}</textarea><br><br>

        <input type="submit" value="<c:if test='${not empty category}'>Update</c:if><c:if test='${empty category}'>Submit</c:if>">
    </form>

    <br>
    <hr>
    <br>

    <!-- Category Table -->
    <table border="1">
        <thead>
            <tr>
                <th>Category Name</th>
                <th>Description</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="category" items="${category_list}">
                <tr>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td><a href="${pageContext.request.contextPath}/admin/category/update/${category.id}">Edit</a></td>
                    <td><a href="${pageContext.request.contextPath}/admin/category/delete/${category.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>