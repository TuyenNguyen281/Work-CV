



<%--
  Created by IntelliJ IDEA.
  User: Duc Tuyen
  Date: 12/4/2023
  Time: 5:30 PM
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
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid px-md-4	">
        <a class="navbar-brand" href="/">Work CV</a>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="/" class="nav-link">Trang chủ</a></li>
                    <li class="nav-item cta cta-colored"><a href="/author/showMyLoginPage" class="nav-link">Đăng
                        nhập</a></li>
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
                        class="ion-ios-arrow-forward"></i></a></span> đăng nhập<span></span></p>
                <h1 class="mb-3 bread">Đăng nhập / Đăng kí</h1>
            </div>
        </div>
    </div>
</div>


</div>

<h1 class="alert alert-danger" hidden id="message1">${message}</h1>
<section class="site-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 mb-5">
                <h2 class="mb-4">Đăng kí</h2>
                <form:form action="/author/register" method="post" class="p-4 border rounded" modelAttribute="user">
                    <div class="row form-group">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="fname1">Email</label>
                            <form:input type="email" id="fname1"  class="form-control" placeholder="Email"
                                   required="true" path="email"/>
                        </div>
                    </div>

                    <div class="row form-group">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="fname2">Họ và tên</label>
                            <form:input type="text" id="fname2"  class="form-control" placeholder="Họ và tên"
                                   required="true" path="fullName"/>
                        </div>
                    </div>

                    <div class="row form-group">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="password">Mật khẩu</label>
                            <form:input type="password" id="password"  class="form-control"
                                   placeholder="Mật khẩu" onkeyup='check()' required="true" path="password"/>
                        </div>
                    </div>
                    <div class="row form-group mb-4">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="rePassword">Nhập lại mật khẩu</label>
                            <form:input type="password" id="rePassword"  class="form-control"
                                   placeholder="Nhập lại mật khẩu" required="true" onkeyup='check()' path="confirmPassword"/>
                           <br> <span id='message'></span>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="fname5">Vai trò</label>
                            <form:select class="form-control" id="fname5"  aria-label="Default select example"
                                    required="true" path="role">
                                <form:option value="ROLE_UCV">Ứng cử viên</form:option>
                                <form:option value="ROLE_CTY">Công ty</form:option>
                            </form:select>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12">
                            <input type="submit" value="Đăng kí" class="btn px-4 btn-primary text-white">
                        </div>
                    </div>
                </form:form>
            </div>
            <div class="col-lg-6">
                <h2 class="mb-4">Đăng nhập</h2>
                <form:form action="/author/login" method="post" class="p-4 border rounded">

                    <div class="row form-group">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="fname">Email</label>
                            <input type="email" id="fname" name="email" class="form-control" placeholder="Email"
                                   required>
                        </div>
                    </div>
                    <div class="row form-group mb-4">
                        <div class="col-md-12 mb-3 mb-md-0">
                            <label class="text-black" for="fname6">Mật khẩu</label>
                            <input type="password" id="fname6" name="password" class="form-control"
                                   placeholder="Mật khẩu" required>
                        </div>
                    </div>

                    <div class="row form-group">
                        <div class="col-md-12">
                            <input type="submit" value="Đăng nhập" class="btn px-4 btn-primary text-white">
                        </div>
                    </div>

                </form:form>


            </div>
        </div>
    </div>
</section>

<footer th:replace="public/fragments :: footer" class="ftco-footer ftco-bg-dark ftco-section">

</footer>
<script>
    function check() {
        if (document.getElementById('password').value ==
            document.getElementById('rePassword').value) {
            document.getElementById('message').style.color = 'green';
            document.getElementById('message').innerHTML = 'matching';
        } else {
            document.getElementById('message').style.color = 'red';
            document.getElementById('message').innerHTML = 'not matching';
        }
    }

    (function () {
        let message = document.getElementById("message1").textContent;
        let element = document.getElementById("message1");
        console.log(message);
        if(message !=="") {
            element.removeAttribute("hidden");
            setTimeout(function () {
                // Closing the alert
                $('.alert').alert('close');
            },8000);
        }

    })();
</script>
</body>
</html>
