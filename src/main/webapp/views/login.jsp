<%
    Object errorLogin = request.getAttribute("loginError");
    Object errorPassword = request.getAttribute("passwordError");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header -->
<%@ include file="partials/header.jsp" %>
<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
            <div class="row flex-grow">
                <div class="col-lg-4 mx-auto">
                    <div class="auth-form-light text-left p-5">
                        <div class="brand-logo">
                            <img src="assets/images/default-monochrome.svg">
                        </div>
                        <h4>Bienvenue</h4>
                        <h6 class="font-weight-light">Veuillez entrer votre compte</h6>
                        <form class="pt-3" action="login" method="post">
                            <div class="form-group">
                                <p class="text-danger"><%= request.getAttribute("loginError") == null ? "" : request.getAttribute("loginError") %></p>
                                <input type="email" name="login" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="Username" value="john_admin@gamail.com">
                            </div>
                            <div class="form-group">
                                <p class="text-danger"><%= request.getAttribute("passwordError") == null ? "" : request.getAttribute("passwordError") %></p>
                                <input type="password" name="password" class="form-control form-control-lg" id="exampleInputPassword1" placeholder="Password" value="motdepasse1">
                            </div>
                            <button class="btn btn-block btn-lg font-weight-medium auth-form-btn btn-gradient-primary mt-3" type="submit">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<!-- import js -->
<%@ include file="partials/import_js.jsp" %>
</html>