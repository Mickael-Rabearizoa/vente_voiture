<%@ page import="voiture.model.Typevoiture" %>
<%@ page import="java.util.List" %>
<%@ page import="voiture.model.Marque" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Typevoiture> typevoitureList = (List<Typevoiture>) request.getAttribute("listType");
    List<Marque> listMarque = (List<Marque>) request.getAttribute("listMarque");
%>
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
                    <h3 class="page-title"> Ajout model </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Ajout</li>
                            <li class="breadcrumb-item active" aria-current="page">model</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Ajout marque</h4>
                                <form class="forms-sample" action="ajout-marque" method="post">
                                    <div class="form-group">
                                        <label>Marque</label>
                                        <input name="marque" type="text" class="form-control" placeholder="Ajouter une marque">
                                    </div>
                                    <button type="submit" class="btn btn-gradient-primary me-2">Ajouter</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Ajout type voiture</h4>
                                <form class="forms-sample" action="ajout-type" method="post">
                                    <div class="form-group">
                                        <label>Ajout type voiture</label>
                                        <input type="text" name="type" class="form-control" placeholder="Ajouter une type voiture">
                                    </div>
                                    <button type="submit" class="btn btn-gradient-primary me-2">Ajouter</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Ajout model</h4>
                                <form class="forms-sample" action="ajout-model" method="post">
                                    <p class="text-danger"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>
                                    <div class="form-group">
                                        <label>Marque</label>
                                        <select class="form-control form-control-lg" name="marque">
                                            <% for(Marque marque : listMarque){ %>
                                                <option value=<%=marque.getId_Marque() %>><%=marque.getNom()%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail3">Model</label>
                                        <input type="model" name="model" class="form-control" id="exampleInputEmail3" placeholder="Ajouter un model"></input>
                                    </div>
                                    <div class="form-group">
                                        <label>Type voiture</label>
                                        <select class="form-control form-control-lg" name="type">
                                            <% for(Typevoiture typevoiture : typevoitureList){ %>
                                                <option value=<%=typevoiture.getId_Typevoiture() %>><%=typevoiture.getTypevoiture()%></option>
                                            <% } %>
                                        </select>
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