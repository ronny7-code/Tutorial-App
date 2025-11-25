<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>eLearning - User Profile</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/Frontend/img/favicon.ico" rel="icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${pageContext.request.contextPath}/Frontend/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Custom Stylesheet -->
    <link href="${pageContext.request.contextPath}/Frontend/css/style.css" rel="stylesheet">
</head>
<body>
    <!-- Topbar -->
    <jsp:include page="topbar.jsp" />

    <!-- Navbar -->
    <jsp:include page="navbar.jsp" />

    <!-- Profile Header -->
    <div class="container-fluid bg-primary py-5 mb-5">
        <div class="container py-5 text-center text-white">
            <h1 class="display-4">Welcome, ${sessionScope.loggedUser.name}</h1>
            <p class="lead">Here is your dashboard and enrolled courses</p>
        </div>
    </div>

    <!-- User Info Section -->
    <div class="container py-5">
        <div class="row">
            <!-- Profile Card -->
            <div class="col-lg-4 mb-4">
                <div class="card shadow-sm">
                    <div class="card-body text-center">
                        <img src="${pageContext.request.contextPath}/Frontend/img/me.jpg" alt="Profile Picture" class="rounded-circle mb-3" width="120">
                        <h4>${user.firstName} ${user.lastName}</h4>
                        <p class="text-muted">${user.phoneNumber}</p>
                        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger btn-sm mt-3">Logout</a>
                    </div>
                </div>
            </div>

            <!-- Enrolled Courses -->
            <div class="col-lg-8">
                <h3 class="mb-4">Your Courses</h3>
                <div class="row">
                    <c:forEach var="course" items="${courseList}">
                        <div class="col-md-6 mb-4">
                            <div class="card h-100 shadow-sm">
                                <img class="card-img-top" src="${pageContext.request.contextPath}/Frontend/img/courses-1.jpg" alt="Course Image">
                                <div class="card-body">
                                    <h5 class="card-title">${course.name}</h5>
                                    <p class="card-text">${course.description}</p>
                                    <a href="${pageContext.request.contextPath}/user/course/${course.id}" class="btn btn-primary btn-sm">View Course</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp" />

    <!-- JavaScript -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/Frontend/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/Frontend/js/main.js"></script>
</body>
</html>