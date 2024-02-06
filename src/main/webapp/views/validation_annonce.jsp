<%@ page import="voiture.model.V_AnnonceUtilisateur" %>
<%@ page import="java.util.List" %>
<%@ page import="voiture.model.Photo" %>
<script src="assets/js/format-number.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<V_AnnonceUtilisateur> listAnnonce = (List<V_AnnonceUtilisateur>) request.getAttribute("listAnnonce");
%>
<!-- header -->
<%@ include file="partials/header.jsp" %>
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/MagnificPopup/magnific-popup.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
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
                    <h3 class="page-title"> Validation annonce </h3>

                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <div class="page-header">
                                <h3 class="page-title">
                                    <a href="#" onclick="createPopupModifierCommission()">
                                        <span class="page-title-icon bg-gradient-primary text-white me-2">
                                          <i class="mdi mdi-percent menu-icon"></i>
                                        </span>
                                        Commision
                                    </a>
                                </h3>
                            </div>
                        </ol>
                    </nav>
                </div>
                <%
                    int counterAnnonce = 1;
                %>
                <% for (V_AnnonceUtilisateur v_annonceUtilisateur : listAnnonce) { %>
                    <div class="row">
                        <div class="col-lg-10 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-5">
                                            <% String image = "image.jpg"; %>
                                            <% if(v_annonceUtilisateur.getPhotoList().isEmpty() == false){
                                                image = v_annonceUtilisateur.getPhotoList().get(0).getPhoto();
                                            } %>
                                            <img src=<%=image %> alt="Sans image" width="400px" height="250px"></img>
                                        </div>
                                        <div class="col-lg-5 padding">
                                            <h4><%= v_annonceUtilisateur.getMarque()+" "+v_annonceUtilisateur.getNom_modele()%> </h4>
                                            <p>Proposé par: <%=v_annonceUtilisateur.getPrenom_utilisateur()%></p>
                                            <p>Prix: <script>document.write(formaterNombre(<%=v_annonceUtilisateur.getPrix()%>)) </script> Ar</p>
                                            <p>Date annonce: <%=v_annonceUtilisateur.getDateannonce()%></p>
                                            <button class="btn btn-block btn-lg btn-gradient-primary mt-4 js-show-modal1" id="<%="annonce"+counterAnnonce%>">Voir detail</button>
                                            <a href="valider-annonce?idAnnonce=<%=v_annonceUtilisateur.getId_Annonceutilisateur()%> " class="btn btn-block btn-lg btn-success mt-4 margin-end">Valider</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <% counterAnnonce++; %>
                <% } %>
            </div>
            <!-- footer -->
            <%@ include file="partials/footer.jsp" %>
        </div>
    </div>
</div>

<%
    int counterModal = 1;
%>
<% for (V_AnnonceUtilisateur v_annonceUtilisateur : listAnnonce) { %>
    <div class="wrap-modal1 js-modal1 p-t-60 p-b-20" id="<%="annonce-modal"+counterModal%>">
        <div class="overlay-modal1 js-hide-modal1"></div>

        <div class="container">
            <div class="bg0 p-t-60 p-b-30 p-lr-15-lg how-pos3-parent">
                <button class="how-pos3 hov3 trans-04 js-hide-modal1">
                    <img src="images/icons/icon-close.png" alt="CLOSE">
                </button>

                <div class="row">
                    <div class="col-md-6 col-lg-7 p-b-30">
                        <div class="p-l-25 p-r-30 p-lr-0-lg">
                            <div class="wrap-slick3 flex-sb flex-w">
                                <div class="wrap-slick3-dots"></div>
                                <div class="wrap-slick3-arrows flex-sb-m flex-w"></div>

                                <div class="slick3 gallery-lb">

                                    <% for (Photo photo : v_annonceUtilisateur.getPhotoList()) { %>
                                        <div class="item-slick3" data-thumb=<%=photo.getPhoto()%>>
                                            <div class="wrap-pic-w pos-relative">
                                                <img src=<%=photo.getPhoto()%> alt="IMG-PRODUCT" width="400px" height="300px">

                                                <a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href=<%=photo.getPhoto()%>>
                                                    <i class="mdi mdi-arrow-expand"></i>
                                                </a>
                                            </div>
                                        </div>
                                    <% } %>
                                    <div class="item-slick3" data-thumb="assets/images/voiture/BMW_noir1.jpg">
                                        <div class="wrap-pic-w pos-relative">
                                            <img src="assets/images/voiture/BMW_noir1.jpg" alt="IMG-PRODUCT" width="400px" height="300px">

                                            <a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="assets/images/voiture/BMW_noir1.jpg">
                                                <i class="mdi mdi-arrow-expand"></i>
                                            </a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-5 p-b-30">
                        <div class="p-r-50 p-t-5 p-lr-0-lg">
                            <h4 class="mtext-105 cl2 js-name-detail p-b-14">
                                <%=v_annonceUtilisateur.getMarque()+" "+v_annonceUtilisateur.getNom_modele() %>
                            </h4>

                            <span class="mtext-106 cl2">
                                <script>document.write(formaterNombre(<%=v_annonceUtilisateur.getPrix() %>)) </script>
                            </span>

                            <p class="stext-102 cl3 p-t-23">
                                <%=v_annonceUtilisateur.getDescription() %>
                            </p>

                            <hr>

                            <p class="mtext-106 cl2">Vendeur: <%=v_annonceUtilisateur.getNom_utilisateur()+" "+v_annonceUtilisateur.getPrenom_utilisateur() %></p>

                            <p class="mtext-106 cl2">Date annonce: <%=v_annonceUtilisateur.getDateannonce() %></p>

                            <div class="flex-w flex-m p-l-100 p-t-40 respon7">
                                <div class="flex-m bor9 p-r-10 m-r-11">
                                    <a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 js-addwish-detail tooltip100" data-tooltip="Add to Wishlist">
                                        <i class="zmdi zmdi-favorite"></i>
                                    </a>
                                </div>

                                <a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100" data-tooltip="Facebook">
                                    <i class="fa fa-facebook"></i>
                                </a>

                                <a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100" data-tooltip="Twitter">
                                    <i class="fa fa-twitter"></i>
                                </a>

                                <a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100" data-tooltip="Google Plus">
                                    <i class="fa fa-google-plus"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <% counterModal++; %>
<% } %>



</body>
<!-- import js -->
<%@ include file="partials/import_js.jsp" %>

<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/slick/slick.min.js"></script>
<script src="js/slick-custom.js"></script>
<!--===============================================================================================-->
<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<script>
    $('.gallery-lb').each(function() { // the containers for all your galleries
        $(this).magnificPopup({
            delegate: 'a', // the selector for gallery item
            type: 'image',
            gallery: {
                enabled:true
            },
            mainClass: 'mfp-fade'
        });
    });
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

<script>
    function createPopupModifierCommission() {

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
                    <h4 class="card-title">Modifier commission</h4>
                    <form class="forms-sample" action="/modifier/commission" method="post">
                        <div class="form-group">
                            <label>Commission</label>
                            <input type="text" name="commission" class="form-control" placeholder="commission en %">
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


    /*==================================================================

    [ Show modal1 ]*/
    <%
        int nbFonction = 1;
    %>
    <% for (V_AnnonceUtilisateur v_annonceUtilisateur : listAnnonce) { %>
            // Utilisez le paramètre dans votre fonction
            $('<%="#annonce"+nbFonction %>').on('click', function(e) {
                e.preventDefault();
                $('<%="#annonce-modal"+nbFonction %>').textContent = "Yes";
                $('<%="#annonce-modal"+nbFonction %>').addClass('show-modal1');
            });
            <% nbFonction++; %>
    <% } %>


    $('.js-hide-modal1').on('click',function(){
        $('.js-modal1').removeClass('show-modal1');
    });
</script>

</html>