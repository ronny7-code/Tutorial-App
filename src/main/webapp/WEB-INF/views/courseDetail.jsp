<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>eLearning - ${course.name} course detail</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/Frontend/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${pageContext.request.contextPath}/Frontend/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${pageContext.request.contextPath}/Frontend/css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
    <jsp:include page="topbar.jsp" />
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <jsp:include page="navbar.jsp" />
    <!-- Navbar End -->


    <!-- Course Start -->
    <div class="container-fluid bg-image py-5" style="margin: 90px 0;">
        <div class="container py-5">
            <div class="row align-items-center">
                <div class="col-lg-5 mb-5 mb-lg-0">
                    <div class="section-title position-relative mb-4">
                        <h6 class="d-inline-block position-relative text-secondary text-uppercase pb-2">${course.courseCategory.type}/${course.courseCategory.name}</h6>
                        <h1 class="display-4">${course.name}</h1>
                    </div>.
                     <p class="m-0">${course.courseCategory.description}</p>
                </div>
                <div class="col-lg-7">
                    <div class="section-title position-relative mb-4">
                        <div class="bg-white p-5">
                            <i class="fa fa-3x fa-quote-left text-primary mb-4"></i>
                            <p>${course.description}</p>
                            <div class="d-flex flex-shrink-0 align-items-center mt-4">
                                <img class="img-fluid mr-4" src="${pageContext.request.contextPath}/Frontend/img/testimonial-2.jpg" alt="">
                                <div>
                                    <h5>Start Date</h5>
                                    <span>End Date</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row align-items-center">
                <div class="col-lg-5 mb-5 mb-lg-0">
             <c:forEach items="${course.content}" var="content">
                                     <div class="row align-items-center">
                                             <div class="col-lg-5 mb-5 mb-lg-0">
                                                 <div class="section-title position-relative mb-4">
                                                     <h6 class="d-inline-block position-relative text-secondary text-uppercase pb-2">${content.name}</h6>
                                                     <h1 class="display-4">${content.type}</h1>
                                                     <c:if test="${content.type.equals('IMG')}">
                                                     <img src="C:\Users\bijay\Documents\Tutorial_App_Contents/${content.fileName}" height="200px" width="200px" alt="content image"/>
                                                     </c:if>
                                                 </div>.
                                                 <p class="m-0">${content.description}</p>
                                                  <p class="m-0"> ${content.name} </p>
                                             </div>
                                     </div>
                                 </c:forEach>
                                 </div>
                                 </div>
        </div>
    </div>

    <!-- course End -->

    <!-- About Start -->
        <div id="about-section">

        </div>
    <!-- About End -->

    <!-- Contact Start -->
    <div class="container-fluid py-5">
        <div class="container py-5">
            <div class="row align-items-center">
                <div class="col-lg-5 mb-5 mb-lg-0">
                    <div class="bg-light d-flex flex-column justify-content-center px-5" style="height: 450px;">
                        <div class="d-flex align-items-center mb-5">
                            <div class="btn-icon bg-primary mr-4">
                                <i class="fa fa-2x fa-map-marker-alt text-white"></i>
                            </div>
                            <div class="mt-n1">
                                <h4>Our Location</h4>
                                <p class="m-0">Nepal, Kathmandu</p>
                            </div>
                        </div>
                        <div class="d-flex align-items-center mb-5">
                            <div class="btn-icon bg-secondary mr-4">
                                <i class="fa fa-2x fa-phone-alt text-white"></i>
                            </div>
                            <div class="mt-n1">
                                <h4>Call Us</h4>
                                <p class="m-0">+977 9741875904</p>
                            </div>
                        </div>
                        <div class="d-flex align-items-center">
                            <div class="btn-icon bg-warning mr-4">
                                <i class="fa fa-2x fa-envelope text-white"></i>
                            </div>
                            <div class="mt-n1">
                                <h4>Email Us</h4>
                                <p class="m-0">bijay98813@gmail.com</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-7">
                    <div class="section-title position-relative mb-4">
                        <h6 class="d-inline-block position-relative text-secondary text-uppercase pb-2">Need Help?</h6>
                        <h1 class="display-4">Send Us A Message</h1>
                    </div>
                    <div class="contact-form">
                        <form>
                            <div class="row">
                                <div class="col-6 form-group">
                                    <input type="text" class="form-control border-top-0 border-right-0 border-left-0 p-0" placeholder="Your Name" required="required">
                                </div>
                                <div class="col-6 form-group">
                                    <input type="email" class="form-control border-top-0 border-right-0 border-left-0 p-0" placeholder="Your Email" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control border-top-0 border-right-0 border-left-0 p-0" placeholder="Subject" required="required">
                            </div>
                            <div class="form-group">
                                <textarea class="form-control border-top-0 border-right-0 border-left-0 p-0" rows="5" placeholder="Message" required="required"></textarea>
                            </div>
                            <div>
                                <button class="btn btn-primary py-3 px-5" type="submit">Send Message</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Contact End -->


    <!-- Footer Start -->
    <jsp:include page="footer.jsp"/>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary rounded-0 btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/Frontend/lib/easing/easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/Frontend/lib/waypoints/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/Frontend/lib/counterup/counterup.min.js"></script>
    <script src="${pageContext.request.contextPath}/Frontend/lib/owlcarousel/owl.carousel.min.js"></script>

      <script>
            const aboutLink = document.querySelector('a[href$="#about-section"]');
            if (aboutLink) {
                aboutLink.addEventListener('click', function(e) {
                    e.preventDefault();
                    document.querySelector('#about-section')
                        .scrollIntoView({ behavior: 'smooth' });
                });
            }
        </script>

    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/Frontend/js/main.js"></script>
</body>

</html>