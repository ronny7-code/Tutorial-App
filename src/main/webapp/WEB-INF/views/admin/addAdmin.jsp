<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/assets/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       <jsp:include page="sidebar.jsp" />
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column pl-4">

            <!-- Main Content -->
    <br>
    <h2>
        <c:if test="${empty admin}">Create New Admin</c:if>
    </h2>
        <form action="${pageContext.request.contextPath}/admin/add" method="POST">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        <hr>
        <br>
        <label>Name: &nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="name"  required>  &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;

        <label>Address: &nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="address" required><br><br>

        <label>Gender: &nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="gender"  required> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;

        <label>Email: &nbsp;&nbsp;&nbsp;</label>
        <input type="email" name="email"  required><br><br>

        <label>Phone Number: &nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="phoneNumber" required> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;

        <label>Username: &nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="username" required><br><br>

        <label>Password: &nbsp;&nbsp;&nbsp;</label>
        <input type="password" name="password" required> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;

        <label>Confirm Password: &nbsp;&nbsp;&nbsp;</label>
        <input type="password" name="cPassword"  required><br><br>

        <input type="submit" value="Submit">
    </form>

    <br>
    <hr>
    <br>

            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; JCode Pvt Ltd. 2025</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/assets/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${pageContext.request.contextPath}/assets/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${pageContext.request.contextPath}/assets/js/demo/chart-area-demo.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/demo/chart-pie-demo.js"></script>

</body>

</html>