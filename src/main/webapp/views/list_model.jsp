<%@ page import="voiture.model.Marque" %>
<%@ page import="java.util.List" %>
<%@ page import="voiture.model.Typevoiture" %>
<%@ page import="voiture.model.Modele" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Marque> marqueList = (List<Marque>) request.getAttribute("listMarque");
    List<Typevoiture> typevoitureList = (List<Typevoiture>) request.getAttribute("listType");
    List<Modele> modeleList = (List<Modele>) request.getAttribute("listModel");
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
                    <h3 class="page-title"> Liste model </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Liste</li>
                            <li class="breadcrumb-item active" aria-current="page">model</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Liste des marques </h4>
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Marque</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Marque marque : marqueList) { %>
                                            <tr>
                                                <td><%=marque.getNom()%></td>
                                                <td class="text-danger"><a href="delete/marque?id=<%=marque.getId_Marque()%>" class="text-danger"><i class="mdi mdi-delete"></i></a></td>
                                                <td class="text-success"><a href="#" class="text-success" onclick="createPopupModifierMarque(`<%=marque.getNom()%>` , `<%=marque.getId_Marque()%>`)"><i class="mdi mdi-lead-pencil"></i></a></td>
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
                                <h4 class="card-title">Liste des type de voiture</h4>
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Type de voiture</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Typevoiture typevoiture : typevoitureList) { %>
                                            <tr>
                                                <td><%=typevoiture.getTypevoiture()%></td>
                                                <td class="text-danger"><a href="delete/type?id=<%=typevoiture.getId_Typevoiture()%>" class="text-danger"><i class="mdi mdi-delete"></i></a></td>
                                                <td class="text-success"><a href="#" class="text-success" onclick="createPopupModifierType(`<%=typevoiture.getTypevoiture()%>` , `<%=typevoiture.getId_Typevoiture()%>`)"><i class="mdi mdi-lead-pencil"></i></a></td>
                                            </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Listed des Model</h4>
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th> Marque </th>
                                        <th> Model </th>
                                        <th> Type de voiture </th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Modele modele : modeleList) { %>
                                            <tr>
                                                <td><%=modele.getMarque().getNom()%></td>
                                                <td><%=modele.getModele()%></td>
                                                <td><%=modele.getTypevoiture().getTypevoiture()%></td>
                                                <td class="text-danger"><a href="delete/modele?id=<%= modele.getId_Modele()%>" class="text-danger"><i class="mdi mdi-delete"></i></a></td>
                                                <td class="text-success"><a href="#" class="text-success" onclick="createPopupModifierModel(`<%=modele.getMarque().getId_Marque()%>` ,`<%=modele.getModele()%>`, `<%=modele.getTypevoiture().getId_Typevoiture()%>` , <%=modele.getId_Modele() %> );"><i class="mdi mdi-lead-pencil"></i></a></td>
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
    function createPopupModifierMarque(marque , id) {

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
                    <h4 class="card-title">Modifier marque</h4>
                    <form class="forms-sample" action="modifier/marque" method="post">
                        <div class="form-group">
                            <label>Marque</label>
                            <input type="hidden" name="id" class="form-control" value="`+id+`">
                            <input type="text" name="nom" class="form-control" value="`+marque+`">
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
    function createPopupModifierType(type , id) {

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
                    <h4 class="card-title">Modifier type voiture</h4>
                    <form class="forms-sample" action="modifier/type" method="post">
                        <div class="form-group">
                            <label>Type de voiture</label>
                            <input type="hidden" name="id" class="form-control" value="`+id+`">
                            <input type="text" name="nom" class="form-control" value="`+type+`">
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
    function createPopupModifierModel(idMarque , model , idType , id) {
        var popupDiv = document.createElement('div');
        popupDiv.className = 'popup';

        // ... (votre contenu HTML)

        // Ajout du pop-up à la fin du corps du document
        document.body.appendChild(popupDiv);

        // Contenu HTML du pop-up
        var popupContent = `
        <div class="col-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Modifier model</h4>
                    <form class="forms-sample" action="modifier-model" method="post">
                        <div class="form-group">
                            <label>Marque</label>
                            <select name="idMarque" class="form-control form-control-lg" id="marqueDropdown">
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Model</label>
                            <input name="model" type="model" class="form-control" id="exampleInputEmail3" value="`+model+`">
                        </div>
                        <div class="form-group">
                            <label>Type voiture</label>
                            <select name="idType" class="form-control form-control-lg" id="TypeDropdown">
                            </select>
                        </div>
                        <input name="id" type="hidden" value="`+id+`"/>

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

        // Utilisation d'AJAX pour obtenir les options de la marque
        fetch('http://localhost:8080/getMarques', { method: 'GET' })
            .then(response => response.json())
            .then(marqueList => {
                // Log des données reçues (facultatif)
                console.log(marqueList);

                // Remplir le dropdown avec les options de marque
                var dropdown = document.getElementById('marqueDropdown');
                marqueList.forEach(marque => {
                    var option = document.createElement('option');
                    option.value = marque.Id_Marque; // Assurez-vous d'ajuster cela en fonction de votre objet Marque
                    option.text = marque.nom; // Assurez-vous d'ajuster cela en fonction de votre objet Marque
                    // Vous pouvez également ajuster la condition suivante en fonction de vos besoins
                    if (marque.Id_Marque === parseInt(idMarque, 10)) {
                        option.selected = true;
                    }
                    dropdown.appendChild(option);
                });

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
            })
            .catch(error => console.error('Erreur lors de la récupération des marques:', error));

        // Utilisation d'AJAX pour obtenir les options de la marque
        fetch('http://localhost:8080/getTypes', { method: 'GET' })
            .then(response => response.json())
            .then(typeList => {
                // Log des données reçues (facultatif)
                console.log(typeList);

                // Remplir le dropdown avec les options de marque
                var dropdown = document.getElementById('TypeDropdown');
                typeList.forEach(type => {
                    var option = document.createElement('option');
                    option.value = type.Id_Typevoiture; // Assurez-vous d'ajuster cela en fonction de votre objet Marque
                    option.text = type.typevoiture; // Assurez-vous d'ajuster cela en fonction de votre objet Marque
                    // Vous pouvez également ajuster la condition suivante en fonction de vos besoins
                    if (type.Id_Typevoiture === parseInt(idType, 10)) {
                        option.selected = true;
                    }
                    dropdown.appendChild(option);
                });
            })
            .catch(error => console.error('Erreur lors de la récupération des Types:', error));
    }
</script>

<script>
    function afficheErreur(erreur) {

        var popupDiv = document.createElement('div');
        popupDiv.className = 'popup';

        document.body.appendChild(popupDiv);

        var popupContent = `
        <p class="text-danger">Erreur: `+erreur+`</p>
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
<% if(request.getAttribute("erreur") != null){ %>
    <script> afficheErreur(`<%=request.getAttribute("erreur")%>`)</script>
<% } %>

</html>