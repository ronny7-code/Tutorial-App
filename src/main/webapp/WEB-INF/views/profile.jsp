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

    <!-- Header Banner -->
    <div class="container-fluid bg-primary py-5 mb-5">
        <div class="container text-center py-5 text-white">
            <h1 class="display-4">Welcome, ${user.firstName}</h1>
            <p class="lead">Your Learning Profile & Recommendations</p>
        </div>
    </div>

    <!-- User Profile Section -->
    <div class="container py-5">
        <div class="row justify-content-center">

            <!-- Profile Card -->
            <div class="col-lg-4 mb-4">
                <div class="card shadow-sm text-center p-4">
                    <img src="${pageContext.request.contextPath}/Frontend/img/me.jpg"
                         alt="Profile Picture" class="rounded-circle mb-3" width="130">

                    <h4 class="text-primary mb-1">${user.firstName} ${user.lastName}</h4>
                    <p class="text-muted mb-3">${user.username}</p>

                    <a href="${pageContext.request.contextPath}/logout"
                       class="btn btn-danger btn-sm px-4">Logout</a>
                </div>
            </div>

            <!-- Profile Details -->
            <div class="col-lg-8">
                <div class="bg-light rounded p-4 shadow-sm">
                    <h4 class="text-primary mb-4">Profile Information</h4>

                    <div class="row mb-3">
                        <div class="col-sm-4 font-weight-bold">Full Name:</div>
                        <div class="col-sm-8">${user.firstName} ${user.lastName}</div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-sm-4 font-weight-bold">Username:</div>
                        <div class="col-sm-8">${user.username}</div>
                    </div>

                    <c:if test="${not empty user.phoneNumber}">
                        <div class="row mb-3">
                            <div class="col-sm-4 font-weight-bold">Phone:</div>
                            <div class="col-sm-8">${user.phoneNumber}</div>
                        </div>
                    </c:if>

                    <c:if test="${not empty user.address}">
                        <div class="row mb-3">
                            <div class="col-sm-4 font-weight-bold">Address:</div>
                            <div class="col-sm-8">${user.address}</div>
                        </div>
                    </c:if>

                    <c:if test="${not empty user.gender}">
                        <div class="row mb-3">
                            <div class="col-sm-4 font-weight-bold">Gender:</div>
                            <div class="col-sm-8">${user.gender}</div>
                        </div>
                    </c:if>

                    <c:if test="${not empty user.DOB}">
                        <div class="row mb-3">
                            <div class="col-sm-4 font-weight-bold">Date of Birth:</div>
                            <div class="col-sm-8">${user.DOB}</div>
                        </div>
                    </c:if>

                    <div class="text-center mt-4">
                        <a href="${pageContext.request.contextPath}/update-profile"
                           class="btn btn-primary px-4">Edit Profile</a>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <!-- Recommended Courses -->
    <div class="container-fluid px-0 py-5 mt-4">
        <div class="row mx-0 justify-content-center">
            <div class="col-lg-6 text-center mb-4">
                <h6 class="text-secondary text-uppercase">Recommended For You</h6>
                <h1 class="display-5">Based On Your Learning</h1>
            </div>
        </div>

        <div class="owl-carousel courses-carousel">
            <c:forEach var="course" items="${recommendedCourses}">
                <div class="courses-item position-relative">
                    <img class="img-fluid"
                         src="${pageContext.request.contextPath}/Frontend/img/courses-1.jpg" alt="">
                    <div class="courses-text">
                        <h4 class="text-center text-white px-3">${course.name}</h4>
                        <div class="border-top w-100 mt-3">
                            <div class="d-flex justify-content-between p-4 text-white">
                                <span><i class="fa fa-user mr-2"></i>${course.instructor}</span>
                                <span><i class="fa fa-star mr-2"></i>${course.rating}</span>
                            </div>
                        </div>
                        <div class="w-100 bg-white text-center p-3">
                            <a class="btn btn-primary btn-sm"
                               href="${pageContext.request.contextPath}/course/${course.id}">
                                View Course
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp" />

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/Frontend/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/Frontend/js/main.js"></script>

</body>
</html>