<%--
  Created by IntelliJ IDEA.
  User: Duc Tuyen
  Date: 12/15/2023
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Work CV</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700&display=swap" rel="stylesheet">

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/aos.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/jquery.timepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/css/bootstrap-reboot.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/css/mixins/_text-hide.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/icomoon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/bootstrap/bootstrap-grid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/assets/css/bootstrap/bootstrap-reboot.css">

    <!-- JS -->
    <script src="${pageContext.request.contextPath}/template/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/jquery-migrate-3.0.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/jquery.easing.1.3.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/jquery.waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/jquery.stellar.min.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/jquery.magnific-popup.min.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/aos.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/jquery.animateNumber.min.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/scrollax.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/google-map.js"></script>
    <script src="${pageContext.request.contextPath}/template/assets/js/main.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid px-md-4	">
        <a class="navbar-brand" href="/">Work CV</a>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="/" class="nav-link">Trang chủ</a></li>
                <li class="nav-item cta mr-md-1"><a href="/CTY/recruitment" class="nav-link">Đăng tuyển</a></li>
                <li class="nav-item cta mr-md-1 dropdown">
                    <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        TK: <security:authentication property="principal.fullName"/>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="/CTY/">Hồ sơ</a>
                        <a class="dropdown-item" href="/CTY/list-postRecruitment/1">Danh sách bài đăng</a>
                        <a class="dropdown-item" href="/author/logout">Đăng xuất</a>
                    </div>

                </li>


            </ul>
        </div>
    </div>
</nav>

<div class="hero-wrap hero-wrap-2" style="background-image: url('/template/assets/images/bg_1.jpg');"
     data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-start">
            <div class="col-md-12 text-center mb-5">
                <p class="breadcrumbs mb-0"><span class="mr-3"><a href="/">Trang chủ <i
                        class="ion-ios-arrow-forward"></i></a></span> Đăng bài<span></span></p>
                <h1 class="mb-3 bread">Đăng bài tuyển dụng</h1>
            </div>
        </div>
    </div>
</div>
<c:if test="${postRecruitment_message_success != null}">
    <div class="toast" data-delay="2500"
         style="position:fixed; top: 100PX; right: 10PX;z-index: 2000;width: 300px">
        <script>
            swal({
                title: 'Đăng tuyển thành công!',
                /* text: 'Redirecting...', */
                icon: 'success',
                timer: 3000,
                buttons: true,
                type: 'success'
            })
        </script>
    </div>
</c:if>
<c:if test="${postRecruitment_message_fail != null}">
    <div class="toast" data-delay="2500"
         style="position:fixed; top: 100PX; right: 10PX;z-index: 2000;width: 300px">
        <script>
            swal({
                title: 'Đăng tuyển thất bại!',
                /* text: 'Redirecting...', */
                icon: 'success',
                timer: 3000,
                buttons: true,
                type: 'success'
            })
        </script>
    </div>
</c:if>
<section class="site-section">
    <div class="container">
        <form:form action="/CTY/${company.id}/recruitment/add" method="post" modelAttribute="recruitment">
            <div class="row align-items-center mb-5">
                <div class="col-lg-8 mb-4 mb-lg-0">
                    <div class="d-flex align-items-center">
                        <div>
                            <h2>Đăng bài</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row mb-5">
                <div class="col-lg-12">
                    <div class="p-4 p-md-5 border rounded" method="post">
                        <h3 class="text-black mb-5 border-bottom pb-2">Chi tiết bài tuyển dụng</h3>
                        <div class="form-group">
                            <form:input path="id" type="hidden" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="email">Tiêu đề</label>
                            <form:input path="title" type="text" class="form-control" id="email" name="title"
                                        required="true" placeholder="Tiêu đề"/>
                        </div>
                        <div class="form-group">
                            <label for="job-location1">Mô tả công việc</label>
                            <form:textarea path="description" id="job-location1" name="description" class="form-control"
                                           placeholder="Mô tả"/>
                        </div>
                        <div class="form-group">
                            <label for="job-title1">Kinh nghiệm</label>
                            <form:input path="experience" type="text" class="form-control" id="job-title1"
                                        name="experience" placeholder="Kinh nghiệm"/>
                        </div>
                        <div class="form-group">
                            <label for="job-title2">Số người cần tuyển</label>
                            <form:input path="quantity" type="number" class="form-control" id="job-title2"
                                        name="quantity" placeholder="Số người cần tuyển"/>
                        </div>
                        <div class="form-group">
                            <label for="job-location2">Địa chỉ</label>
                            <form:input path="address" type="text" class="form-control" id="job-location2"
                                        name="address" placeholder="Địa chỉ công ty"/>
                        </div>
                        <div class="form-group">
                            <label for="job-location3">Hạn ứng tuyển</label>
                            <form:input path="deadline" type="date" class="form-control" id="job-location3"
                                        name="deadline"/>
                        </div>
                        <div class="form-group">
                            <label for="job-location4">Lương</label>
                            <form:input path="salary" type="text" class="form-control" id="job-location4" name="salary"
                                        placeholder="Mức lương"/>
                        </div>

                        <div class="form-group">
                            <label for="job-region1">Loại công việc</label>
                            <form:select path="type" id="job-region1" class="form-control" name="type"
                                         aria-label="Default select example" required="true">

                                <form:option value="Part time">Part time</form:option>
                                <form:option value="Full time">Full time</form:option>
                                <form:option value="Freelancer">Freelancer</form:option>
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="job-region2">Danh mục công việc</label>
                            <form:select path="category" id="job-region2" class="form-control" name="category_id"
                                         aria-label="Default select example" required="true">

                                <form:option value="JAVA">JAVA</form:option>
                                <form:option value="NodeJS">NodeJS</form:option>
                                <form:option value="C++">C++</form:option>
                                <form:option value="C#">C#</form:option>
                                <form:option value="Python">Python</form:option>
                            </form:select>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-12">
                                <input type="submit" value="Đăng tuyển"
                                       class="btn px-4 btn-primary text-white">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</section>

<footer replace="public/fragments :: footer" class="ftco-footer ftco-bg-dark ftco-section">

</footer>
</body>
</html>
