<%--
  Created by IntelliJ IDEA.
  User: Duc Tuyen
  Date: 12/21/2023
  Time: 11:43 AM
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
                <security:authorize access="isAuthenticated()">
                    <security:authorize access="hasRole('CTY')">
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
                    </security:authorize>
                    <security:authorize access="hasRole('UCV')">
                        <li class="nav-item cta mr-md-1"><a href="/UCV/list-saveJob/1" class="nav-link">Công việc đã lưu</a></li>
                        <li class="nav-item cta mr-md-1"><a href="/UCV/list-applyJob/1" class="nav-link">Công việc đã ứng tuyển</a></li>
                        <li class="nav-item cta mr-md-1"><a href="/UCV/list-companyFollow/1" class="nav-link">Công ty đã theo dõi</a></li>
                        <li class="nav-item cta mr-md-1 dropdown">
                            <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton1"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                TK: <security:authentication property="principal.fullName"/>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                <a class="dropdown-item" href="/UCV/">Hồ sơ</a>
                                <a class="dropdown-item" href="/author/logout">Đăng xuất</a>
                            </div>

                        </li>
                    </security:authorize>
                </security:authorize>
                <security:authorize access="!isAuthenticated()">
                    <li class="nav-item cta cta-colored"><a href="/author/showMyLoginPage" class="nav-link">Đăng
                        nhập</a></li>
                </security:authorize>


            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->

<div class="hero-wrap img" style="background-image: url(/template/assets/images/bg_1.jpg);">
    <div class="overlay"></div>
    <div class="container">
        <div class="row d-md-flex no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-10 d-flex align-items-center ">
                <div class="text text-center pt-5 mt-md-5">
                    <p class="mb-4">Tìm việc làm, Cơ hội việc làm và Nghề nghiệp</p>
                    <h1 class="mb-5">Cách dễ dàng nhất để có được công việc mới của bạn</h1>
                    <div class="ftco-counter ftco-no-pt ftco-no-pb">
                        <div class="row">
                            <div class="col-md-4 d-flex justify-content-center counter-wrap ">
                                <div class="block-18">
                                    <div class="text d-flex">
                                        <div class="icon mr-2">
                                            <span class="flaticon-visitor"></span>
                                        </div>
                                        <div class="desc text-left">
                                            <strong class="number" data-number="46"
                                                    th:text="${numberCandidate}"></strong>
                                            <span>Ứng cử viên</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 d-flex justify-content-center counter-wrap ">
                                <div class="block-18 text-center">
                                    <div class="text d-flex">
                                        <div class="icon mr-2">
                                            <span class="flaticon-visitor"></span>
                                        </div>
                                        <div class="desc text-left">
                                            <strong class="number" data-number="450"
                                                    th:text="${numberCompany}"></strong>
                                            <span>Công ty</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 d-flex justify-content-center counter-wrap">
                                <div class="block-18 text-center">
                                    <div class="text d-flex">
                                        <div class="icon mr-2">
                                            <span class="flaticon-resume"></span>
                                        </div>
                                        <div class="desc text-left">
                                            <strong class="number" data-number="80000"
                                                    th:text="${numberRecruitment}"></strong>
                                            <span>Tuyển dụng</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="ftco-search my-md-5">
                        <div class="row">
                            <div class="col-md-12 nav-link-wrap">
                                <div class="nav nav-pills text-center" id="v-pills-tab" role="tablist"
                                     aria-orientation="vertical">
                                    <a class="nav-link active mr-md-1" id="v-pills-1-tab" data-toggle="pill"
                                       href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true">Tìm
                                        công việc</a>

                                    <a class="nav-link" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2"
                                       role="tab" aria-controls="v-pills-2" aria-selected="false">Tìm theo công ty</a>
                                    <a class="nav-link" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3"
                                       role="tab" aria-controls="v-pills-3" aria-selected="false">Tìm theo địa điểm</a>
                                </div>
                            </div>
                            <div class="col-md-12 tab-wrap">
                                <div class="tab-content p-4" id="v-pills-tabContent">
                                    <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel"
                                         aria-labelledby="v-pills-nextgen-tab">
                                        <form action="/home/recruitment/searchByCategory/1" method="get"
                                              class="search-job">
                                            <div class="row no-gutters">

                                                <div class="col-md-10 mr-md-2">
                                                    <div class="form-group">
                                                        <div class="form-field">
                                                            <div class="icon"><span class="icon-map-marker"></span>
                                                            </div>
                                                            <input type="text" name="keySearch" class="form-control"
                                                                   placeholder="Tìm kiếm công việc">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md">
                                                    <div class="form-group">
                                                        <div class="form-field">
                                                            <button type="submit" class="form-control btn btn-primary">
                                                                Tìm kiếm
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>

                                    <div class="tab-pane fade" id="v-pills-2" role="tabpanel"
                                         aria-labelledby="v-pills-performance-tab">
                                        <form action="/home/recruitment/searchByCompany/1" method="get"
                                              class="search-job">
                                            <div class="row no-gutters">

                                                <div class="col-md-10 mr-md-2">
                                                    <div class="form-group">
                                                        <div class="form-field">
                                                            <div class="icon"><span class="icon-map-marker"></span>
                                                            </div>
                                                            <input type="text" name="keySearch" class="form-control"
                                                                   placeholder="Tìm kiếm theo công ty">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md">
                                                    <div class="form-group">
                                                        <div class="form-field">
                                                            <button type="submit" class="form-control btn btn-primary">
                                                                Tìm kiếm
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="tab-pane fade" id="v-pills-3" role="tabpanel"
                                         aria-labelledby="v-pills-performance-tab">
                                        <form action="/home/recruitment/searchByAddress/1" method="get"
                                              class="search-job">
                                            <div class="row no-gutters">

                                                <div class="col-md-10 mr-md-2">
                                                    <div class="form-group">
                                                        <div class="form-field">
                                                            <div class="icon"><span class="icon-map-marker"></span>
                                                            </div>
                                                            <input type="text" name="keySearch" class="form-control"
                                                                   placeholder="Tìm kiếm theo địa điểm">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md">
                                                    <div class="form-group">
                                                        <div class="form-field">
                                                            <button type="submit" class="form-control btn btn-primary">
                                                                Tìm kiếm
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section bg-light" th:if="${session.user}">
    <div class="container">
        <h4 style="margin-top: -20px">Kết quả tìm kiếm cho : <span>${keySearch}</span></h4>
        <div class="row">
            <div class="col-lg-12 pr-lg-5">
                <div class="row">
                    <c:if test="${recruitmentList.size() > 0}">
                        <c:forEach var="recruitment" items="${recruitmentList}">
                            <div class="col-md-12 ">
                                <div class="job-post-item p-4 d-block d-lg-flex align-items-center">
                                    <div class="one-third mb-4 mb-md-0">
                                        <div class="job-post-item-header align-items-center">
                                            <span class="subadge">${recruitment.type}</span>
                                            <h2 class="mr-3 text-black"><a style="text-decoration: none"
                                                                           href="/home/recruitment/detail/${recruitment.id}">${recruitment.title}</a>
                                            </h2>
                                        </div>
                                        <div class="job-post-item-body d-block d-md-flex">
                                            <div class="mr-3"><span class="icon-layers"></span> <a
                                                    style="text-decoration: none"
                                                    href="#">${recruitment.company.nameCompany}</a>
                                            </div>
                                            <div><span
                                                    class="icon-my_location"></span><span>${recruitment.address}</span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="one-forth ml-auto d-flex align-items-center mt-4 md-md-0"
                                         style="width: 330px !important;">
                                        <a href="/home/recruitment/detail/${recruitment.id}"
                                           class="btn btn-primary py-2 ml-2">Xem chi tiết</a>
                                    </div>
                                    <security:authorize access="!hasRole('CTY')">
                                    <div class="one-forth ml-auto d-flex align-items-center mt-4 md-md-0">
                                        <div>
                                            <a onclick="saveJob(${recruitment.id})"
                                               class="icon text-center d-flex justify-content-center align-items-center icon mr-2">
                                                <span class="icon-heart"></span>
                                            </a>
                                        </div>
                                        <a data-toggle="modal" data-target="${'#exampleModal'}${recruitment.id}"
                                           class="btn btn-primary py-2">Apply Job</a>
                                    </div>
                                    </security:authorize>
                                </div>
                            </div>
                            <!-- end -->
                            <!-- Modal -->
                            <div class="modal fade" id="${'exampleModal'}${recruitment.id}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Ứng tuyển:
                                                <span>${recruitment.title}</span></h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form method="post" action="/UCV/apply-job">
                                            <div class="modal-body">
                                                <div class="row">
                                                    <div class="col-12">
                                                        <select id="${'choose'}${recruitment.id}"
                                                                onchange="choosed(${recruitment.id})"
                                                                class="form-control"
                                                                aria-label="Default select example">
                                                            <option selected>Chọn phương thức nộp</option>
                                                            <option value="1">Dùng cv đã cập nhật</option>
                                                            <option value="2">Nộp cv mới</option>
                                                        </select>
                                                    </div>
                                                    <div id="${'loai1'}${recruitment.id}" style="display:none"
                                                         class="col-12">
                                                        <label
                                                                class="col-form-label">Giới thiệu:</label>
                                                        <textarea rows="10" cols="3" class="form-control"
                                                                  id="${'text1'}${recruitment.id}">

                                                    </textarea>
                                                    </div>
                                                    <div id="${'loai2'}${recruitment.id}" style="display:none"
                                                         class="col-12">

                                                        <label
                                                                class="col-form-label">Chọn cv:</label>
                                                        <input type="file" class="form-control"
                                                               id="${'fileUpload'}${recruitment.id}" name="file"
                                                               required accept=".pdf" onchange="checkPdfFile(this)">
                                                        <label
                                                                class="col-form-label">Giới thiệu:</label>

                                                        <textarea rows="10" name="description"
                                                                  id="${'text2'}${recruitment.id}" class="form-control"
                                                                  placeholder="Giới thiệu"
                                                        ></textarea>
                                                    </div>

                                                </div>
                                                <div class="modal-footer">
                                                    <input id="checkLogin" hidden value="${userDetails}">
                                                    <input id="userDetailsId" hidden value="${userDetails.id}">
                                                    <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">
                                                        Đóng
                                                    </button>
                                                    <button type="button" id="${'button1'}${recruitment.id}"
                                                            style="display: none"
                                                            onclick="apply1(${recruitment.id})"
                                                            class="btn btn-primary">Nộp
                                                    </button>
                                                    <button type="button" id="${'button2'}${recruitment.id}"
                                                            style="display: none"
                                                            onclick="apply2(${recruitment.id})"
                                                            class="btn btn-primary">Nộp
                                                    </button>
                                                </div>
                                            </div>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${recruitmentList.size() == 0}">
                        <div style="text-align: center">
                            <p style="color: red">Không có kết quả nào</p>
                        </div>
                    </c:if>
                </div>

                <div class="row mt-5">
                    <div class="col text-center">
                        <div class="block-27">
                            <ul>
                                <c:if test="${pageNumber > 1}">
                                    <li>
                                        <a href="/home/recruitment/searchByCompany/${pageNumber -1}?keySearch=${keySearch}">&lt;</a>
                                    </li>
                                </c:if>
                                <li>
                                    <a href="/home/recruitment/searchByCompany/${pageNumber}?keySearch=${keySearch}">${pageNumber}</a>
                                </li>
                                <c:if test="${recruitmentList.size() == 2}">
                                    <li>
                                        <a href="/home/recruitment/searchByCompany/${pageNumber +1}?keySearch=${keySearch}">&gt;</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>

<script>
    function saveJob(id) {
        let name = "#idRe" + id;
        let idRe = $(name).val();

        if (!$('#checkLogin').val()) {
            swal({
                title: 'Bạn cần phải đăng nhập!!',
                /* text: 'Redirecting...', */
                icon: 'error',
                timer: 3000,
                buttons: true,
                type: 'error'
            })
        } else {
            $.ajax(
                {
                    type: 'POST',
                    url: '/UCV/saveJob',
                    data: {recruitmentId: id},
                    success: function (message) {
                        console.log(message);
                        if (message === "success") {
                            swal({
                                title: 'Lưu thành công!',
                                /* text: 'Redirecting...', */
                                icon: 'success',
                                timer: 3000,
                                buttons: true,
                                type: 'success'
                            })
                        } else if (message === "exist") {
                            swal({
                                title: 'Bạn đã lưu bài này rồi!',
                                /* text: 'Redirecting...', */
                                icon: 'error',
                                timer: 3000,
                                buttons: true,
                                type: 'error'
                            })
                        } else  {
                            swal({
                                title: 'Lưu không thành công!',
                                /* text: 'Redirecting...', */
                                icon: 'error',
                                timer: 3000,
                                buttons: true,
                                type: 'error'
                            })
                        }
                    }
                }
            )
        }
    }
    function choosed(id) {
        let name = '#choose' + id;
        let name1 = 'loai1' + id;
        let name2 = 'loai2' + id;
        let button1 = 'button1' + id;
        let button2 = 'button2' + id;
        let giaitri = $(name).val();
        if (giaitri == 1) {
            document.getElementById(name1).style.display = 'block'
            document.getElementById(name2).style.display = 'none'
            document.getElementById(button1).style.display = 'block'
            document.getElementById(button2).style.display = 'none'
        } else {
            document.getElementById(name2).style.display = 'block'
            document.getElementById(name1).style.display = 'none'
            document.getElementById(button2).style.display = 'block'
            document.getElementById(button1).style.display = 'none'
        }
    }

    function checkPdfFile(input) {
        let ext = input.value.match(/\.([^\.]+)$/)[1];
        switch (ext) {
            case 'pdf':
                break;
            default:
                alert('Chỉ cho phép upload file .pdf');
                input.value = '';
        }
    }

    function apply1(id) {
        let nameModal = "#exampleModal" + id;
        let userDetailId = "#userDetailsId"
        let nameText = "#text1" + id;
        let textValue = $(nameText).val();
        let userId = $(userDetailId).val();
        let button1 = '#button1' + id;
        $(button1).prop('disabled', true);
        let formData = new FormData();
        formData.append('userId', userId);
        formData.append('recruitmentId', id)
        formData.append('text', textValue);

        if (!$('#checkLogin').val()) {
            swal({
                title: 'Bạn cần phải đăng nhập!!',
                /* text: 'Redirecting...', */
                icon: 'error',
                timer: 3000,
                buttons: true,
                type: 'error'
            })
            $(button1).prop('disabled', false);

        } else {
            $.ajax(
                {
                    type: 'POST',
                    url: '/UCV/apply-job',
                    processData: false,
                    contentType: false,
                    data: formData,
                    success: function (message) {
                        console.log("message_apply:  " + message)
                        if (message === "success") {
                            swal({
                                title: 'Ứng tuyển thành công!',
                                /* text: 'Redirecting...', */
                                icon: 'success',
                                timer: 3000,
                                buttons: true,
                                type: 'success'
                            })
                            $(nameModal).modal('hide');
                            $(nameText).val("");
                            $(button1).prop('disabled', false);

                        } else if (message === "exist") {
                            swal({
                                title: 'Bạn đã ứng tuyển công việc này!',
                                /* text: 'Redirecting...', */
                                icon: 'error',
                                timer: 3000,
                                buttons: true,
                                type: 'error'
                            })
                            $(nameModal).modal('hide');
                            $(nameText).val("");
                            $(button1).prop('disabled', false);

                        } else if (message === "fail") {
                            swal({
                                title: 'Ứng tuyển không thành công!',
                                /* text: 'Redirecting...', */
                                icon: 'error',
                                timer: 3000,
                                buttons: true,
                                type: 'error'
                            })
                            $(nameModal).modal('hide');
                            $(nameText).val("");
                            $(button1).prop('disabled', false);

                        } else if (message === "cv not exist") {
                            swal({
                                title: 'Bạn chưa có cv!',
                                /* text: 'Redirecting...', */
                                icon: 'error',
                                timer: 3000,
                                buttons: true,
                                type: 'error'
                            })
                            $(nameModal).modal('hide');
                            $(nameText).val("");
                            $(button1).prop('disabled', false);

                        }
                    }
                }
            );
        }

    }

    function apply2(id) {
        let nameModal = "#exampleModal" + id;
        let userDetailId = "#userDetailsId"
        let nameFile = "#fileUpload" + id;
        let nameText = "#text2" + id;
        let textValue = $(nameText).val();
        let fileUpload = $(nameFile).get(0);
        let files = fileUpload.files;
        let userId = $(userDetailId).val();
        let button2 = '#button2' + id;
        $(button2).prop('disabled', true);
        let formData = new FormData();
        formData.append('userId', userId);
        formData.append('recruitmentId', id)
        formData.append('text', textValue);
        formData.append('file', fileUpload.files[0]);

        if (files[0] == null) {
            swal({
                title: 'Bạn cần phải chọn cv!',
                /* text: 'Redirecting...', */
                icon: 'error',
                timer: 3000,
                buttons: true,
                type: 'error'
            })
            $(button2).prop('disabled', false);

        } else if (!$('#checkLogin').val()) {
            swal({
                title: 'Bạn cần phải đăng nhập!!',
                /* text: 'Redirecting...', */
                icon: 'error',
                timer: 3000,
                buttons: true,
                type: 'error'
            })
            $(button2).prop('disabled', false);

        } else {
            $.ajax(
                {
                    type: 'POST',
                    url: '/UCV/apply-job',
                    processData: false,
                    contentType: false,
                    data: formData,
                    success: function (message) {
                        console.log("message_apply:  " + message)
                        if (message === "success") {
                            swal({
                                title: 'Ứng tuyển thành công!',
                                /* text: 'Redirecting...', */
                                icon: 'success',
                                timer: 3000,
                                buttons: true,
                                type: 'success'
                            })
                            $(nameModal).modal('hide');
                            $(nameFile).val("");
                            $(nameText).val("");
                            $(button2).prop('disabled', false);

                        } else if (message === "exist") {
                            swal({
                                title: 'Bạn đã ứng tuyển công việc này!',
                                /* text: 'Redirecting...', */
                                icon: 'error',
                                timer: 3000,
                                buttons: true,
                                type: 'error'
                            })
                            $(nameModal).modal('hide');
                            $(nameFile).val("");
                            $(nameText).val("");
                            $(button2).prop('disabled', false);

                        } else if (message === "fail") {
                            swal({
                                title: 'Ứng tuyển không thành công!',
                                /* text: 'Redirecting...', */
                                icon: 'error',
                                timer: 3000,
                                buttons: true,
                                type: 'error'
                            })
                            $(nameModal).modal('hide');
                            $(nameFile).val("");
                            $(nameText).val("");
                            $(button2).prop('disabled', false);

                        }
                    }
                }
            );
        }

    }
</script>


<footer :replace="public/fragments :: footer" class="ftco-footer ftco-bg-dark ftco-section">

</footer>

</body>
</html>
