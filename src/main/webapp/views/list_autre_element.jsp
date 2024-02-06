<%@ page import="java.util.List" %>
<%@ page import="voiture.repository.CouleurRepository" %>
<%@ page import="voiture.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Transmission> listTransmission = (List<Transmission>) request.getAttribute("listTransmission");
    List<Carburant> listCarburant = (List<Carburant>) request.getAttribute("listCarburant");
    List<Couleur> listCouleur = (List<Couleur>) request.getAttribute("listCouleur");
    List<Region> listRegion = (List<Region>) request.getAttribute("listRegion");
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
                    <h3 class="page-title"> Liste autre elements </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Liste</li>
                            <li class="breadcrumb-item active" aria-current="page">autre elements</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Liste transmission</h4>
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Transmission</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Transmission transmission : listTransmission) { %>
                                            <tr>
                                                <td><%=transmission.getTransmission_()%></td>
                                                <td class="text-danger"><a href="delete/transmission?id=<%= transmission.getId_Transmission()%>" class="text-danger"><i class="mdi mdi-delete"></i></a></td>
                                                <td class="text-success"><a href="#" class="text-success" onclick="createPopupModifierTransmission(`<%=transmission.getTransmission_()%>` , `<%=transmission.getId_Transmission()%>`);"><i class="mdi mdi-lead-pencil"></i></a></td>
                                            </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Liste carburant</h4>
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Carburant</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Carburant carburant : listCarburant) { %>
                                            <tr>
                                                <td><%=carburant.getCarburant()%></td>
                                                <td class="text-danger"><a href="delete/carburant?id=<%= carburant.getId_Carburant()%>" class="text-danger"><i class="mdi mdi-delete"></i></a></td>
                                                <td class="text-success"><a href="#" class="text-success" onclick="createPopupModifierCarburant(`<%=carburant.getCarburant()%>` , `<%=carburant.getId_Carburant()%>`);"><i class="mdi mdi-lead-pencil"></i></a></td>
                                            </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Liste Couleur</h4>
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Couleur</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Couleur couleur : listCouleur) { %>
                                    <tr>
                                        <td><%=couleur.getNom()%></td>
                                        <td class="text-danger"><a href="delete/couleur?id=<%=couleur.getId_Couleur() %>" class="text-danger"><i class="mdi mdi-delete"></i></a></td>
                                        <td class="text-success"><a href="#" class="text-success" onclick="createPopupModifierCouleur(`<%=couleur.getNom()%>` , `<%=couleur.getId_Couleur()%>`);"><i class="mdi mdi-lead-pencil"></i></a></td>
                                    </tr>
                                    <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Liste Region</h4>
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Region</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Region region : listRegion) { %>
                                    <tr>
                                        <td><%=region.getRegion()%></td>
                                        <td class="text-danger"><a href="delete/region?id=<%= region.getId_Region()%>" class="text-danger"><i class="mdi mdi-delete"></i></a></td>
                                        <td class="text-success"><a href="#" class="text-success" onclick="createPopupModifierRegion(`<%=region.getRegion()%>` , `<%=region.getId_Region()%>`);"><i class="mdi mdi-lead-pencil"></i></a></td>
                                    </tr>
                                    <% } %>
                                    </tbody>
                                </table>
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
<script>
    function createPopupModifierTransmission(transmission , id) {

        var popupDiv = document.createElement('div');
        popupDiv.className = 'popup';

        // ... (votre contenu HTML)

        // Ajout du pop-up à la fin du corps du document
        document.body.appendChild(popupDiv);

        // Contenu HTML du pop-up
        var popupContent = `
        <div class="col-md-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Modifier transmission</h4>
                    <form class="forms-sample" action="/modifier/transmission" method="post">
                        <div class="form-group">
                            <label>Transmission</label>
                            <input type="hidden" name="id" class="form-control" value="`+id+`">
                            <input type="text" name="nom" class="form-control" value="`+transmission+`">
                        </div>
                        <button type="submit" class="btn btn-gradient-primary me-2">Modifier</button>
                    </form>
                </div>
            </div>
        </div>
    `;

        // Ajout du contenu HTML au pop-up
        popupDiv.innerHTML = popupContent;

        // Ajout du pop-up à la fin du corps du document
        document.body.appendChild(popupDiv);

        // Ajout de l'overlay (fond flouté)
        var overlay = document.createElement('div');
        overlay.className = 'overlay';
        document.body.appendChild(overlay);

        // Afficher le pop-up et l'overlay lors de la création
        popupDiv.style.display = 'block';
        overlay.style.display = 'block';

        // Ajout d'un gestionnaire d'événements pour masquer le pop-up lors du clic sur l'overlay
        overlay.addEventListener('click', function () {
            popupDiv.style.display = 'none';
            overlay.style.display = 'none';
            document.body.removeChild(popupDiv);
            document.body.removeChild(overlay);
        });
    }
</script>

<script>
    function createPopupModifierCarburant(carburant , id) {

        var popupDiv = document.createElement('div');
        popupDiv.className = 'popup';

        // ... (votre contenu HTML)

        // Ajout du pop-up à la fin du corps du document
        document.body.appendChild(popupDiv);

        // Contenu HTML du pop-up
        var popupContent = `
        <div class="col-md-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Modifier carburant</h4>
                    <form class="forms-sample" action="/modifier/carburant" method="post">
                        <div class="form-group">
                            <label>Carburant</label>
                            <input type="hidden" name="id" class="form-control" value="`+id+`">
                            <input type="text" name="nom" class="form-control" value="`+carburant+`">
                        </div>
                        <button type="submit" class="btn btn-gradient-primary me-2">Modifier</button>
                    </form>
                </div>
            </div>
        </div>
    `;

        // Ajout du contenu HTML au pop-up
        popupDiv.innerHTML = popupContent;

        // Ajout du pop-up à la fin du corps du document
        document.body.appendChild(popupDiv);

        // Ajout de l'overlay (fond flouté)
        var overlay = document.createElement('div');
        overlay.className = 'overlay';
        document.body.appendChild(overlay);

        // Afficher le pop-up et l'overlay lors de la création
        popupDiv.style.display = 'block';
        overlay.style.display = 'block';

        // Ajout d'un gestionnaire d'événements pour masquer le pop-up lors du clic sur l'overlay
        overlay.addEventListener('click', function () {
            popupDiv.style.display = 'none';
            overlay.style.display = 'none';
            document.body.removeChild(popupDiv);
            document.body.removeChild(overlay);
        });
    }
</script>

<script>
    function createPopupModifierCouleur(couleur , id) {

        var popupDiv = document.createElement('div');
        popupDiv.className = 'popup';

        // ... (votre contenu HTML)

        // Ajout du pop-up à la fin du corps du document
        document.body.appendChild(popupDiv);

        // Contenu HTML du pop-up
        var popupContent = `
        <div class="col-md-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Modifier Couleur</h4>
                    <form class="forms-sample" action="/modifier/couleur" method="post">
                        <div class="form-group">
                            <label>Couleur</label>
                            <input type="hidden" name="id" class="form-control" value="`+id+`">
                            <input type="text" name="nom" class="form-control" value="`+couleur+`">
                        </div>
                        <button type="submit" class="btn btn-gradient-primary me-2">Modifier</button>
                    </form>
                </div>
            </div>
        </div>
    `;

        // Ajout du contenu HTML au pop-up
        popupDiv.innerHTML = popupContent;

        // Ajout du pop-up à la fin du corps du document
        document.body.appendChild(popupDiv);

        // Ajout de l'overlay (fond flouté)
        var overlay = document.createElement('div');
        overlay.className = 'overlay';
        document.body.appendChild(overlay);

        // Afficher le pop-up et l'overlay lors de la création
        popupDiv.style.display = 'block';
        overlay.style.display = 'block';

        // Ajout d'un gestionnaire d'événements pour masquer le pop-up lors du clic sur l'overlay
        overlay.addEventListener('click', function () {
            popupDiv.style.display = 'none';
            overlay.style.display = 'none';
            document.body.removeChild(popupDiv);
            document.body.removeChild(overlay);
        });
    }
</script>

<script>
    function createPopupModifierRegion(region , id) {

        var popupDiv = document.createElement('div');
        popupDiv.className = 'popup';

        // ... (votre contenu HTML)

        // Ajout du pop-up à la fin du corps du document
        document.body.appendChild(popupDiv);

        // Contenu HTML du pop-up
        var popupContent = `
        <div class="col-md-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Modifier Region</h4>
                    <form class="forms-sample" action="/modifier/region" method="post">
                        <div class="form-group">
                            <label>Region</label>
                            <input type="hidden" name="id" class="form-control" value="`+id+`">
                            <input type="text" name="nom" class="form-control" value="`+region+`">
                        </div>
                        <button type="submit" class="btn btn-gradient-primary me-2">Modifier</button>
                    </form>
                </div>
            </div>
        </div>
    `;

        // Ajout du contenu HTML au pop-up
        popupDiv.innerHTML = popupContent;

        // Ajout du pop-up à la fin du corps du document
        document.body.appendChild(popupDiv);

        // Ajout de l'overlay (fond flouté)
        var overlay = document.createElement('div');
        overlay.className = 'overlay';
        document.body.appendChild(overlay);

        // Afficher le pop-up et l'overlay lors de la création
        popupDiv.style.display = 'block';
        overlay.style.display = 'block';

        // Ajout d'un gestionnaire d'événements pour masquer le pop-up lors du clic sur l'overlay
        overlay.addEventListener('click', function () {
            popupDiv.style.display = 'none';
            overlay.style.display = 'none';
            document.body.removeChild(popupDiv);
            document.body.removeChild(overlay);
        });
    }
</script>
</html>