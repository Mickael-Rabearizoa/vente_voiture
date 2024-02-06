<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header -->
<%@ include file="partials/header.jsp" %>
<body>
<div class="container-scroller">
    <!-- navbar -->
    <%@ include file="partials/navbar.jsp" %>
    <div class="container-fluid page-body-wrapper">
        <!-- sidebar -->
        <%@ include file="partials/sidebar.jsp" %>
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title"> Ajout autre elements </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Ajout</li>
                            <li class="breadcrumb-item active" aria-current="page">autre elements</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Ajout transmission</h4>
                                <form class="forms-sample" action="ajout-transmission" method="post">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">transmission</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="transmission" class="form-control" placeholder="Ajouter une transmission">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-gradient-primary me-2">Ajouter</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Ajout Carburant</h4>
                                <form class="forms-sample" action="ajout-carburant" method="post">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">carburant</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="carburant" class="form-control" placeholder="Ajouter une carburant">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-gradient-primary me-2">Ajouter</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Ajout Couleur</h4>
                                <form class="forms-sample" action="ajout-couleur" method="post">
                                    <div class="form-group row">
                                        <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Couleur</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="couleur" class="form-control" id="exampleInputUsername" placeholder="Ajouter une couleur">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-gradient-primary me-2">Ajouter</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Ajout Region</h4>
                                <form class="forms-sample" action="ajout-region" method="post">
                                    <div class="form-group row">
                                        <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Region</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="region" class="form-control" id="exampleInputUsername2" placeholder="Ajouter une region">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-gradient-primary me-2">Ajouter</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- footer -->
            <%@ include file="partials/footer.jsp" %>
        </div>
    </div>
</div>
</body>
<!-- import js -->
<%@ include file="partials/import_js.jsp" %>
</html>