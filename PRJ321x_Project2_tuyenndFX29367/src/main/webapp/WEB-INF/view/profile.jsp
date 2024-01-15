
<%--
  Created by IntelliJ IDEA.
  User: Duc Tuyen
  Date: 12/11/2023
  Time: 4:11 PM
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

<div class="hero-wrap hero-wrap-2" style="background-image: url(/template/assets/images/bg_1.jpg);"
     data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-start">
            <div class="col-md-12 text-center mb-5">
                <h1 class="mb-3 bread">Hồ sơ </h1>
                <div style="margin-left: 0px" id="divImage">
                    <img id="avatar2" height="100" width="100" style="border-radius: 50px"
                         src="${user.image != null ? user.image : 'https://st.quantrimang.com/photos/image/072015/22/avatar.jpg'}">
                </div>
            </div>
        </div>
    </div>
</div>
<h1 class="alert alert-danger" hidden id="message1">${message != null ? 'Bạn cần bổ xung thông tin cho Công ty' : null}</h1>


<security:authorize access="hasRole('UCV')">
    <section class="site-section"
             style="margin-top: 10px">
        <div class="container">
            <form:form action="/UCV/update-cv"  modelAttribute="cv" enctype="multipart/form-data">
                <div class="row align-items-center mb-5">
                    <div class="col-lg-8 ">
                        <div class="d-flex align-items-center">
                            <div class="form-group">
                                <form:input path="id" type="hidden" class="form-control"/>
                                <form:input path="name" type="hidden" class="form-control"/>
                                <form:input path="linkCV" type="hidden" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <p><label for="fileToUpload4">Chọn CV (.pdf)</label></p>
                                <p><form:input path="multipartFile" name="file" id="fileToUpload4" type="file"  accept=".pdf"
                                               class="btn btn-success" onchange="checkTypeFile(this,'pdf')"/></p>
                              <a href="${cv.linkCV}"><h5 style="color: red">Xem Cv: ${cv.name}</h5></a>
                            </div>

                        </div>

                    </div>
                    <div class="col-lg-4">
                        <div class="row">
                            <div class="col-6">
                                <button type="submit" class="btn btn-block btn-primary btn-md">Lưu CV</button>
                            </div>
                        </div>
                    </div>

                </div>
            </form:form>

            <form:form action="/UCV/update-profile" method="post" modelAttribute="user"  enctype="multipart/form-data">
                <div class="row align-items-center mb-5">
                    <div class="col-lg-8 mb-4 mb-lg-0">
                        <div class="d-flex align-items-center">
                            <div>
                                <h2>Cập nhật thông tin</h2>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="row">
                            <div class="col-6">
                                <button type="submit" class="btn btn-block btn-primary btn-md">Lưu thông tin</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mb-5">
                    <div class="col-lg-12">
                        <div class="p-4 p-md-5 border rounded">
                            <h3 class="text-black mb-5 border-bottom pb-2">Thông tin chi tiết</h3>
                            <div class="form-group">
                                <form:input path="id" type="hidden" class="form-control"/>
                                <form:input path="password" type="hidden" class="form-control"/>
                                <form:input path="confirmPassword" type="hidden" class="form-control"/>
                                <form:input path="status" type="hidden" class="form-control"/>
                                <form:input path="image" type="hidden" class="form-control"/>
                                <form:input path="role" type="hidden" value="${user.role.roleName}"
                                            class="form-control"/>
                            </div>
                            <div class="form-group">
                                <p><label for="fileToUpload3">Choose Image</label></p>
                                <p><form:input path="multipartFile" name="file" id="fileToUpload3" type="file" accept=".jpg"
                                               class="btn btn-success" onchange="checkTypeFile(this,'jpg')"/></p>
                            </div>
                            <div class="form-group">
                                <label for="email2">Email</label>
                                <form:input path="email" type="email" class="form-control" id="email2" name="email"
                                       required="true" placeholder="you@yourdomain.com"/>
                            </div>
                            <div class="form-group">
                                <label for="job-title1">Full name</label>
                                <form:input path="fullName" type="text" class="form-control" name="fullName"
                                       required="true" id="job-title1" placeholder="Full name"/>
                            </div>
                            <div class="form-group">
                                <label for="job-location2">Địa chỉ</label>
                                <form:input path="address" type="text" name="address"
                                       class="form-control" id="job-location2" required="true" placeholder="e.g. New York"/>
                            </div>
                            <div class="form-group">
                                <label for="job-location3">Số điện thoại</label>
                                <form:input path="phoneNumber" type="text" name="phoneNumber"

                                       class="form-control" id="job-location3" required="true" placeholder="+ 84"/>
                            </div>
                            <div class="form-group">
                                <label for="editor1">Mô tả bản thân</label>
                                <form:textarea path="description" name="description"
                                          class="form-control" id="editor1" placeholder="Mô tả"/>
                            </div>

                        </div>
                    </div>

                </div>
            </form:form>
        </div>
    </section>

</security:authorize>

<security:authorize access="hasRole('CTY')">
    <section class="site-section"
             style="margin-top: 10px">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 mb-5">
                    <h2 class="mb-4">Thông tin cá nhân</h2>
                    <form:form action="/CTY/update-profile" modelAttribute="user" method="post"
                               enctype="multipart/form-data">
                        <div class="row mb-5">
                            <div class="col-lg-12">
                                <div class="p-4 p-md-5 border rounded">
                                    <div class="form-group">
                                        <p><label for="fileToUpload2">Choose Image</label></p>
                                        <p><form:input path="multipartFile" name="file" id="fileToUpload2" type="file" accept=".jpg"
                                                       class="btn btn-success" onchange="checkTypeFile(this,'jpg')"/></p>
                                    </div>
                                    <div class="form-group">
                                        <form:input path="id" type="hidden" class="form-control"/>
                                        <form:input path="password" type="hidden" class="form-control"/>
                                        <form:input path="confirmPassword" type="hidden" class="form-control"/>
                                        <form:input path="status" type="hidden" class="form-control"/>
                                        <form:input path="image" type="hidden" class="form-control"/>
                                        <form:input path="role" type="hidden" value="${user.role.roleName}"
                                                    class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <form:input path="email" type="email" class="form-control" id="email"
                                                    name="email"
                                                    required="true"
                                                    placeholder="you@yourdomain.com"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="job-title2">Họ và tên</label>
                                        <form:input path="fullName" type="text" class="form-control" name="fullName"
                                                    id="job-title2" required="true"
                                                    placeholder="Full name"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="job-location4">Địa chỉ</label>
                                        <form:input path="address" type="text" name="address"
                                                    required="true" class="form-control" id="job-location4"
                                                    placeholder="e.g. New York"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="job-location5">Số điện thoại</label>
                                        <form:input path="phoneNumber" type="text" name="phoneNumber"
                                                    required="true" class="form-control" id="job-location5"
                                                    placeholder="+ 84"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="editor2">Mô tả bản thân</label>
                                        <form:textarea path="description" name="description"
                                                       class="form-control" id="editor2" placeholder="Mô tả"/>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <input type="submit" value="Lưu thông tin"
                                                   class="btn px-4 btn-primary text-white">
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </form:form>
                </div>
                <div class="col-lg-6">
                    <h2 class="mb-4">Thông tin công ty</h2>
                    <form:form action="/CTY/${user.id}/update-company" method="post" modelAttribute="company" enctype="multipart/form-data">
                        <div class="row mb-5">
                            <div class="col-lg-12">
                                <div class="p-4 p-md-5 border rounded">
                                    <div class="form-group">
                                        <p><label for="fileToUpload1">Choose Logo</label></p>
                                        <p><input  name="multipartFile" id="fileToUpload1" type="file" accept=".jpg"
                                                       class="btn btn-success" onchange="checkTypeFile(this,'jpg')"/></p>
                                        <div id="divLogo">
                                            <img id="avatar1" height="100" width="100" style="border-radius: 50px"
                                                src="${company.logo != null ? company.logo : 'https://st.quantrimang.com/photos/image/072015/22/avatar.jpg'}">
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" class="form-control" required="true" id="email1" name="email"
                                               placeholder="you@yourdomain.com"
                                               value="${company.email != null ? company.email : null}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="job-title3">Tên công ty</label>
                                        <input type="text" class="form-control" name="nameCompany"
                                               id="job-title3" placeholder="Full name" required
                                               value="${company.nameCompany != null ? company.nameCompany : null}">
                                        <input type="hidden" class="form-control" name="user_id"
                                               id="job-title4" value="${company.user != null ? company.user.id : null}">
                                        <input type="hidden" class="form-control" name="id"
                                               id="job-title" placeholder="Full name"
                                               value="${company.id != null ? company.id: null}">

                                    </div>
                                    <div class="form-group">
                                        <label for="job-location">Địa chỉ</label>
                                        <input type="text" name="address"
                                               required class="form-control" id="job-location"
                                               placeholder="e.g. New York"
                                               value="${company.address != null ? company.address: null}">
                                    </div>
                                    <div class="form-group">
                                        <label for="job-location6">Số điện thoại công ty</label>
                                        <input type="text" name="phoneNumber"
                                               required class="form-control" id="job-location6" placeholder="+ 84"
                                               value="${company.phoneNumber != null ? company.phoneNumber: null}">
                                    </div>
                                    <div class="form-group">
                                        <label for="job-location1">Mô tả công ty</label>
                                        <textarea name="description" class="form-control" id="job-location1"
                                                  placeholder="Mô tả"
                                                  value="${company.description != null ? company.description: null}">${company.description != null ? company.description: null}</textarea>
                                    </div>

                                    <div style="margin-left: 0px" id="divImag1">
                                        <img id="avatar" height="100" width="100"
                                             style="border-radius: 50px;margin-bottom: 15px" src="${company.logo}">
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <input type="submit" value="Lưu thông tin"
                                                   class="btn px-4 btn-primary text-white">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>

                </div>
            </div>
        </div>
    </section>
</security:authorize>

<c:if test="${update_message_success != null}">
    <div class="toast" data-delay="2000" style="position:fixed;top: 100PX; right: 10PX;z-index: 2000;width: 300px">
        <script>
            swal({
                title: 'Cập nhật thành công!',
                /* text: 'Redirecting...', */
                icon: 'success',
                timer: 3000,
                buttons: true,
                type: 'success'
            })
        </script>
    </div>
</c:if>
<c:if test="${update_message_fail !=null}">
    <div class="toast" data-delay="2000" style="position:fixed;top: 100PX; right: 10PX;z-index: 2000;width: 300px">
        <script>
            swal({
                title: 'Cập nhật thất bại!',
                /* text: 'Redirecting...', */
                icon: 'success',
                timer: 3000,
                buttons: true,
                type: 'success'
            })
        </script>
    </div>
</c:if>


<script>
    $('#file-upload').change(function () {
        var i = $(this).prev('label').clone();
        var file = $('#file-upload')[0].files[0].name;
        $(this).prev('label').text(file);
    });
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

    function checkTypeFile(input,typeFile) {
        let ext = input.value.match(/\.([^\.]+)$/)[1];
        console.log("ext:  " + ext);
        switch (ext) {
            case typeFile:
                break;
            default:
                alert('Chỉ cho phép upload file đuôi .' + typeFile);
                input.value = '';
        }

    }
</script>



<footer replace="public/fragments :: footer" class="ftco-footer ftco-bg-dark ftco-section">

</footer>
</body>
</html>
