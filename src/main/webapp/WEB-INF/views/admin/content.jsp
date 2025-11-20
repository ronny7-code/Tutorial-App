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

    <title>Admin - Content</title>

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


    <h2>
        <c:if test="${not empty course}">Update Content </c:if>
        <c:if test="${empty course}">Create Content </c:if>
    </h2>

    <c:if test="${not empty course}">
        <form action="${pageContext.request.contextPath}/admin/content/update/${course.id}?${_csrf.parameterName}=${_csrf.token}" method="POST" encType="multipart/form-data">
    </c:if>
    <c:if test="${empty course}">
        <form action="${pageContext.request.contextPath}/admin/content/add?${_csrf.parameterName}=${_csrf.token}" method="POST" encType="multipart/form-data">
    </c:if>

        <label>Content Name:</label><br>
        <input type="text" name="name" value="${content.name}" required><br><br>

        <label>Content Type:</label><br>
        <select  name="type" required>
            <option value="WORD_DOC"> Microsoft Word Document </option>
            <option value="PDF"> PDF File </option>
            <option value="VIDEO"> Video Recording </option>
        </select>
        <br> <br>
        <label>Description:</label><br>
        <textarea name="description" rows="4" cols="50" required>${content.description}</textarea>
        <br><br>
        <label>Course List:</label><br>
         <select  name="course" required>
         <c:forEach items="${courseList}" var="courses">
          <option>Courses</option>
          <option value="${courses.id}"> ${courses.name} </option>
         </c:forEach>
         </select>
         <br> <br>
                <label>Select a file:</label><br>
                <input type="file" name="file" placeholder="Select a file to upload.." required>

  <br> <br>
        <input type="submit" value="<c:if test='${not empty content}'>Update</c:if><c:if test='${empty content}'>Submit</c:if>">
    </form>
    <br>
    <hr>
    <br>

    <!-- Content Table -->

    <table border="1">
        <thead>
            <tr>
                <th>Content Name</th>
                <th>Courses</th>
                <th>Description</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="contents" items="${contentList}">
                <tr>
                    <td>${contents.name}</td>
                     <td>${contents.course.name}</td>
                    <td>${contents.description}</td>
                    <td><a href="${pageContext.request.contextPath}/admin/content/update/${course.id}">Edit</a></td>
                    <td><a href="${pageContext.request.contextPath}/admin/content/delete/${course.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

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